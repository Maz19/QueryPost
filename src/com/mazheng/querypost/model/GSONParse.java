package com.mazheng.querypost.model;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.mazheng.querypost.MyApplication;
import com.mazheng.querypost.entity.list.City;
import com.mazheng.querypost.entity.list.ListAll;
import com.mazheng.querypost.entity.list.Province;
import com.mazheng.querypost.entity.querydistrict.CodeLists;
import com.mazheng.querypost.entity.querydistrict.CodeQueryResult;
import com.mazheng.querypost.entity.querynumber.AreasResult;
import com.mazheng.querypost.entity.querynumber.QueryResult;
import com.mazheng.querypost.utils.UrlFactory;


public class GSONParse {
	/**
	 * 通过邮编查询地名
	 * 
	 * @param callback
	 * @param postcode
	 */
	public void getCityCode(final AsyncCallback callback, String postcode) {
		// Log.i("123", "getCityCode");
		String url = UrlFactory.getCity(postcode);
		StringRequest request = new StringRequest(Method.GET, url, new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				// Log.i("123", "response" + response.toString());
				List<CodeLists> lis = new ArrayList<CodeLists>();
				Gson gson = new Gson();
				CodeQueryResult res = gson.fromJson(response, CodeQueryResult.class);
				lis = res.getResult().getList();
				Log.i("lis", "Gsonlis" + lis.toString());
				callback.onSuccess(lis);
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
			}
		});
		// Log.i("123", "request" + request.toString());
		MyApplication.getQueue().add(request);

	}

	public void getPostNumber(final AsyncCallback callback, String area) {
		String url = UrlFactory.getNumber(area);
		Log.i("123", "URL= "+url);
		
		StringRequest request = new StringRequest(url, new Listener<String>() {
			


			@Override
			public void onResponse(String response) {
				Log.i("123", "response : "+response);
				List<AreasResult> ar = new ArrayList<AreasResult>();
				Log.i("123", "ar= "+ar);
				Gson gson = new Gson();
				QueryResult qr = gson.fromJson(response, QueryResult.class);
				ar = qr.getResult();
				callback.onSuccess(ar);
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Log.i("123", "error : "+error);

			}

		});
		request.setRetryPolicy( new DefaultRetryPolicy( 100000,//默认超时时间，应设置一个稍微大点儿的，例如本处的500000 
		        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,//默认最大尝试次数 
		        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ) );
		
		MyApplication.getQueue().add(request);
	}

	/**
	 * 获取省份城市列表 `
	 * 
	 * @param callback
	 */
	public void getProvinceListView(final AsyncCallback callback) {
		String url = UrlFactory.getList();
		// Log.i("123", "url"+url.toString());
		StringRequest request = new StringRequest(Method.GET, url, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				List<Province> lp = new ArrayList<Province>();
				// Log.i("123", "lr"+lp.toString());
				Gson gson = new Gson();
				ListAll la = gson.fromJson(response, ListAll.class);
				lp = la.getResult();
				// Log.i("123", "ld"+ld.toString());
				callback.onSuccess(lp);

			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		// Log.i("123", "request" + request.toString());
		MyApplication.getQueue().add(request);

	}

	public void getCityListView(final AsyncCallback callback) {
		String url = UrlFactory.getList();
		StringRequest request = new StringRequest(Method.GET, url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				List<City> lc = new ArrayList<City>();
				Gson gson = new Gson();
				ListAll la = gson.fromJson(response, ListAll.class);
				for (int i = 0; i < la.getResult().size(); i++) {

					lc = la.getResult().get(i).getcity();
					// Log.i("123", lc.toString());
				}

				callback.onSuccess(lc);

			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		MyApplication.getQueue().add(request);

	}

	public interface AsyncCallback {
		void onSuccess(Object success);

		void onError(Object error);
	}

}
