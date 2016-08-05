package com.mazheng.querypost.adapter;

import java.util.List;

import com.mazheng.querypost.R;
import com.mazheng.querypost.adapter.ProvinceAdapter.ViewHolder;
import com.mazheng.querypost.entity.list.City;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListCityAdapter extends BaseAdapter {
	private Context context;
	private List<City> city;
	private LayoutInflater inflater;

	public ListCityAdapter(Context context, List<City> city) {
		super();
		this.context = context;
		this.city = city;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return city.size();
	}

	@Override
	public City getItem(int position) {
		return city.get(position);
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
			holder.tvText = (TextView) convertView
					.findViewById(R.id.tv_item_list_text);
			convertView.setTag(holder);

		}
		holder = (ViewHolder) convertView.getTag();
		City c = getItem(position);
		holder.tvText.setText(c.getCity());

		return convertView;
	}

	class ViewHolder {
		TextView tvText;
	}

}
