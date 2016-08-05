package com.mazheng.querypost.activity;

import java.util.ArrayList;
import java.util.List;

import com.mazheng.querypost.R;
import com.mazheng.querypost.adapter.ListCityAdapter;
import com.mazheng.querypost.adapter.ListDistrictAdapter;
import com.mazheng.querypost.adapter.ListProvinceAdapter;
import com.mazheng.querypost.entity.list.City;
import com.mazheng.querypost.entity.list.District;
import com.mazheng.querypost.entity.list.Province;
import com.mazheng.querypost.model.GSONParse;
import com.mazheng.querypost.model.GSONParse.AsyncCallback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

/**
 * 省份城市界面
 * 
 * @author Administrator
 * 
 */
public class ListActivity extends Activity implements OnClickListener {
	private Button btright;
	private ListProvinceAdapter listProvinceAdapter;
	private ListCityAdapter listCityAdapter;
	private ListDistrictAdapter listDistrictAdapter;
	private ArrayList<District> subDistricts = new ArrayList<District>();
	private ArrayList<Province> provinces = new ArrayList<Province>();
	private ArrayList<City> subCities = new ArrayList<City>(); // cities的子集合

	private ListView lvProvince;
	private ListView lvCity;
	private ListView lvDistrict;
	private GSONParse gson = new GSONParse();
	private Context context; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_list);
		Log.i("123", "ListActivity");
		lvProvince = (ListView) findViewById(R.id.lv_list_province);
		lvCity = (ListView) findViewById(R.id.lv_list_city);
		lvDistrict = (ListView) findViewById(R.id.lv_list_district);

		btright = (Button) findViewById(R.id.bt_list_right);

		btright.setOnClickListener(this);
		setListener();

		gson.getProvinceListView(new AsyncCallback() {

			@Override
			public void onSuccess(Object success) {
				setAdapter(success);

			}

			@Override
			public void onError(Object error) {

			}
		});

	}

	private void setListener() {
		
		lvProvince.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				subCities.clear();
				subDistricts.clear();
				Province pro = provinces.get(position);
				for (int i = 0; i < pro.getcity().size(); i++) {
					City city = new City();
					String aid = pro.getcity().get(i).getCity();
					List<District> dis = pro.getcity().get(i).getDistrict();
					city.setDistrict(dis);
					for (int j = 0; j < dis.size(); j++) {
						String s = dis.get(j).getDistrict();
//						Log.i("123","wangban: "+ s);
						
					}
					city.setCity(aid);
					subCities.add(city);

				}
				setCityAdapter(subCities);

			}

		});
		lvCity.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				subDistricts.clear();
				//Log.i("123", "123");
				List<District> districts = subCities.get(position).getDistrict();
				//Log.i("123", "c "+c.getCity());
				for (int i = 0; i < districts.size(); i++) {
					District dis = new District();
//					Log.i("123", "dis: "+dis.getDistrict());
					
					String d=districts.get(i).getDistrict();
					dis.setDistrict(d);

					subDistricts.add(dis);

				}

				setDistrictAdapter(subDistricts);
			}

		});

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_list_right:
			Intent i1 = new Intent(ListActivity.this, MainActivity.class);
			startActivity(i1);

			break;

		

		}

	}

	public void setAdapter(Object success) {
		provinces = (ArrayList<Province>) success;
		
		listProvinceAdapter = new ListProvinceAdapter(ListActivity.this,
				(List<Province>) success);
		lvProvince.setAdapter(listProvinceAdapter);

	}

	public void setCityAdapter(Object success) {

		listCityAdapter = new ListCityAdapter(ListActivity.this,
				(List<City>) success);
		lvCity.setAdapter(listCityAdapter);
	}

	public void setDistrictAdapter(Object success) {
		listDistrictAdapter = new ListDistrictAdapter(ListActivity.this,
				(List<District>) success);
		lvDistrict.setAdapter(listDistrictAdapter);

	}

}
