package com.mazheng.querypost.entity.list;

import java.util.List;

/**
 * 城市
 * 上一级ListResult.java
 * 
 * @author Administrator
 *
 */

public class City {
	private int id;
	private String city;
	private List<District> district;

	public City(int id, String city, List<District> district) {
		super();
		this.id = id;
		this.city = city;
		this.district = district;
	}

	public City() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<District> getDistrict() {
		return district;
	}

	public void setDistrict(List<District> district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", city=" + city + ", district=" + district + "]";
	}

}
