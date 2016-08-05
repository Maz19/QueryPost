package com.mazheng.querypost.adapter;

import java.util.List;

import com.mazheng.querypost.R;
import com.mazheng.querypost.entity.list.Province;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ProvinceAdapter extends BaseAdapter {
	private Context context;
	private List<Province> province;
	private LayoutInflater inflater;

	public ProvinceAdapter(Context context, List<Province> province) {
		this.context = context;
		this.province = province;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return province.size();
	}

	@Override
	public Province getItem(int position) {
		return province.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_lv_list, null);
			holder = new ViewHolder();
			holder.tvText = (TextView) convertView.findViewById(R.id.tv_item_list_text);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();

		Province r = getItem(position);
		holder.tvText.setText(r.getProvince());
		Log.i("123", "convertView"+convertView.toString());

		return convertView;
	}

	class ViewHolder {
		TextView tvText;

	}

}
