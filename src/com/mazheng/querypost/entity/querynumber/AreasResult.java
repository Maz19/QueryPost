package com.mazheng.querypost.entity.querynumber;

public class AreasResult {
	private String postnumber;
	private String province;
	private String city;
	private String district;
	private String address;
	private String jd;

	public AreasResult(String postnumber, String province, String city, String district, String address, String jd) {
		super();
		this.postnumber = postnumber;
		this.province = province;
		this.city = city;
		this.district = district;
		this.address = address;
		this.jd = jd;
	}

	public AreasResult() {
		super();
	}

	public String getPostnumber() {
		return postnumber;
	}

	public void setPostnumber(String postnumber) {
		this.postnumber = postnumber;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJd() {
		return jd;
	}

	public void setJd(String jd) {
		this.jd = jd;
	}

	@Override
	public String toString() {
		return "AreasResult [postnumber=" + postnumber + ", province=" + province + ", city=" + city + ", district="
				+ district + ", address=" + address + ", jd=" + jd + "]";
	}

}
