package com.mazheng.querypost.adapter;

import java.util.List;

import com.mazheng.querypost.R;
import com.mazheng.querypost.entity.list.District;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListDistrictAdapter extends BaseAdapter {

	private Context context;

	private List<District> district;
	private LayoutInflater inflater;

	public ListDistrictAdapter(Context context, List<District> district) {
		this.context = context;
		this.district = district;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return district.size();
	}

	@Override
	public District getItem(int position) {
		// TODO Auto-generated method stub
		return district.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_lv_list, null);
			holder = new ViewHolder();
			holder.tvText = (TextView) convertView
					.findViewById(R.id.tv_item_list_text);
			convertView.setTag(holder);

		}
		holder = (ViewHolder) convertView.getTag();
		District d = getItem(position);
		holder.tvText.setText(d.getDistrict());

		return convertView;
	}

	class ViewHolder {
		TextView tvText;
	}

}
