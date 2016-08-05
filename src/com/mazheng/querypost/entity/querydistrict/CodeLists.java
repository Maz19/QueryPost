package com.mazheng.querypost.entity.querydistrict;

public class CodeLists {

	private int PostNumber;
	private String Province;
	private String City;
	private String District;
	private String Address;

	public CodeLists(int postNumber, String province, String city, String district,
			String address) {
		super();
		PostNumber = postNumber;
		Province = province;
		City = city;
		District = district;
		Address = address;
	}

	public CodeLists() {
		super();
	}

	public int getPostNumber() {
		return PostNumber;
	}

	public void setPostNumber(int postNumber) {
		PostNumber = postNumber;
	}

	public String getProvince() {
		return Province;
	}

	public void setProvince(String province) {
		Province = province;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Lists [PostNumber=" + PostNumber + ", Province=" + Province
				+ ", City=" + City + ", District=" + District + ", Address="
				+ Address + "]";
	}

}
