package com.javasw.project.map.model;

import org.springframework.stereotype.Repository;

@Repository
public class MapVo {

	private int no; 				// 연번
	private String cat; 			// 유형
	private String estbl_nm; 		// 업소명
	private String tel_no; 			// 전화번호
	private String road_nm_addr;	// 도로명 주소
	private double lat; 			// 위도
	private double lot; 			// 경도

	public void setNo(int no) {
		this.no = no;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public void setEstbl_nm(String estbl_nm) {
		this.estbl_nm = estbl_nm;
	}

	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}

	public void setRoad_nm_addr(String road_nm_addr) {
		this.road_nm_addr = road_nm_addr;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public void setLot(double lot) {
		this.lot = lot;
	}

	public int getNo() {
		return no;
	}

	public String getCat() {
		return cat;
	}

	public String getEstbl_nm() {
		return estbl_nm;
	}

	public String getTel_no() {
		return tel_no;
	}

	public String getRoad_nm_addr() {
		return road_nm_addr;
	}

	public double getLat() {
		return lat;
	}

	public double getLot() {
		return lot;
	}

}
