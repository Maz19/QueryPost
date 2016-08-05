package com.mazheng.querypost.entity.list;

import java.util.List;

/**
 * 省份
 * 上一级ListAll.java
 * @author Administrator
 *
 */

public class Province {
	private int id;
	private String province;
	private List<City> city;

	public Province(int id, String province, List<City> city) {
		super();
		this.id = id;
		this.province = province;
		this.city = city;
	}

	public Province() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public List<City> getcity() {
		return city;
	}

	public void setcity(List<City> city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "ListResult [id=" + id + ", province=" + province + ", city=" + city + "]";
	}

}
