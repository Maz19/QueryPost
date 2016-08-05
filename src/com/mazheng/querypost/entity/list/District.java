package com.mazheng.querypost.entity.list;

import java.util.List;
/**
 * 地区
 * 上一级City.java
 * @author Administrator
 *
 */

public class District {
	private int id;
	private String district;
	public District(int id, String district) {
		this.id = id;
		this.district = district;
	}
	public District() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	@Override
	public String toString() {
		return "District [id=" + id + ", district=" + district + "]";
	}
	
}
