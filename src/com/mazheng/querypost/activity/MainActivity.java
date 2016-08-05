package com.mazheng.querypost.activity;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;
import com.mazheng.querypost.R;
import com.mazheng.querypost.entity.querydistrict.CodeLists;
import com.mazheng.querypost.entity.querynumber.AreasResult;
import com.mazheng.querypost.model.GSONParse;
import com.mazheng.querypost.model.GSONParse.AsyncCallback;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 通过邮编查询地名界面
 * 
 * @author Administrator
 * 
 */

public class MainActivity extends Activity implements OnClickListener {
	@ViewInject(R.id.et_query_editor)
	private EditText etEditor;
	// @ViewInject(R.id.tv_query_display)
	// private TextView tvDisplay;
	@ViewInject(R.id.bt_query_button)
	private Button btButton;
	private List<CodeLists> lis;
	private List<AreasResult> res;
	@ViewInject(R.id.tv_displsy_number)
	private TextView tvNumber;

	@ViewInject(R.id.tv_display_district)
	private TextView tvDisplayDistrict;
	@ViewInject(R.id.tv_display_city)
	private TextView tvDisplayCity;
	@ViewInject(R.id.bt_main_backlist)
	private Button btBackList;

	@ViewInject(R.id.tv_display_province)
	private TextView tvDisplayProvince;
	private GSONParse parse = new GSONParse();
	private String postcode;
	private String area;
	private String text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Log.i("123", "onCreat");
		x.view().inject(this);

		btButton.setOnClickListener(this);
		btBackList.setOnClickListener(this);
	}

	/**
	 * 单击按钮查询地名
	 */
	

	@Override
	public void onClick(View v) {
	 text = etEditor.getText().toString();
		Pattern p = Pattern.compile("[0-9]*");
		Matcher m = p.matcher(text);

		switch (v.getId()) {

		case R.id.bt_query_button:

			if (m.matches()) {
				Log.i("123", "query");
				query();
			} else {
				Log.i("123", "find");
				find();
			}

			break;
		case R.id.bt_main_backlist:
			Intent intent = new Intent(MainActivity.this, ListActivity.class);

			startActivity(intent);
			break;
		}
	}

	/**
	 * 输入PostCode查询地区
	 */
	public void query() {

		parse.getCityCode(new AsyncCallback() {

			@Override
			public void onSuccess(Object success) {
				lis = (List<CodeLists>) success;

				tvDisplayProvince.setText(lis.get(0).getProvince());
				tvDisplayCity.setText(lis.get(1).getCity());
				tvDisplayDistrict.setText(lis.get(2).getDistrict());
			}

			@Override
			public void onError(Object error) {

			}
		}, text);

	}

	/**
	 * 
	 * 输入地址查询邮编
	 */

	public void find() {
		try {
parse.getPostNumber(new AsyncCallback() {
				

				@Override
				public void onSuccess(Object success) {
					res = (List<AreasResult>) success;
					Log.i("123", "res="+res);
					tvNumber.setText(res.get(0).getPostnumber());
				}

				@Override
				public void onError(Object error) {
					Log.i("123", "456");

				}
			}, text);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			
		

	}

}
