package com.mazheng.querypost.utils;

public class UrlFactory {
	public static String getCity(String postcode) {
		String path = "http://v.juhe.cn/postcode/query?postcode="
				+ postcode
				+ "&page=&pagesize=&dtype=&key=96ac0a9e8c69651438d7aae5f531ed70";
		return path;

	}

	public static String getList() {
		String path = "http://v.juhe.cn/postcode/pcd?pid=&cid=&did=&q=&dtype=&key=96ac0a9e8c69651438d7aae5f531ed70";
		return path;

	}

	public static String getNumber(String area) {
		String path = "http://api.avatardata.cn/PostNumber/QueryAddress?key=dbe5b897801546719fb722cf5955be26&address="
				+ area;
		return path;

	}

}
