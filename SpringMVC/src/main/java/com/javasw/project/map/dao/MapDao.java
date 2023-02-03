package com.javasw.project.map.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.javasw.project.map.model.MapVo;

@Repository
public class MapDao {

//	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static MapDao instance = new MapDao();

	private MapDao() {
	}

	public static MapDao getInstance() {
		return instance;
	}
	
	public void apiData(Model model) {
		String query = "INSERT INTO api (no, cat, estbl_nm, tel_no, road_nm_addr, lat, lot) VALUES (?, ?, ?, ?, ?, ?, ?)";
		MapVo vo = (MapVo)model.asMap().get("store"); 	
		
		
		String no = String.valueOf(vo.getNo());
		String cat = vo.getCat(); 		
		String estbl_nm = vo.getEstbl_nm(); 		
		String tel_no = vo.getTel_no(); 			
		String road_nm_addr = vo.getRoad_nm_addr();	
		String lat = String.valueOf(vo.getLat()); 	
		String lot = String.valueOf(vo.getLot());
		
        boolean condition = false;	// 값을 확인하기 위해 사용 나중에 AOP로 변환하자
        if (condition) {	// if (condition == true)
			System.out.println("no : " + no);
			System.out.println("cat : " + cat);
			System.out.println("estbl_nm : " + estbl_nm);
			System.out.println("tel_no : " + tel_no);
			System.out.println("road_nm_addr : " + road_nm_addr);
			System.out.println("lat : " + lat);
			System.out.println("lot : " + lot);
		}
        jdbcTemplate.update(query, no, cat, estbl_nm, tel_no, road_nm_addr, lat, lot);
        
//        중복검사
//        String selectQuery = "SELECT * FROM api WHERE no = ? and cat = ? and estbl_nm = ? and tel_no = ? and road_nm_addr = ? and lat = ? and lot = ?";
//        List<Map<String, Object>> result = jdbcTemplate.queryForList(selectQuery, no, cat, estbl_nm, tel_no, road_nm_addr, lat, lot);
//        if (result.isEmpty()) {
//        	jdbcTemplate.update(query, no, cat, estbl_nm, tel_no, road_nm_addr, lat, lot);
//        }
	}
//1
    public void apiData(String no, String cat, String estbl_nm, String tel_no, String road_nm_addr, String lat, String lot) {
    		String query = "INSERT INTO api (no, cat, estbl_nm, tel_no, road_nm_addr, lat, lot) VALUES (?, ?, ?, ?, ?, ?, ?)";
//    		중복검사
    		System.out.println("SELECT");
    		String selectQuery = "SELECT * FROM api WHERE no = ? and cat = ? and estbl_nm = ? and tel_no = ? and road_nm_addr = ? and lat = ? and lot = ?";
    		System.out.println("리턴된것을 리스트로");
    		List<Map<String, Object>> result = jdbcTemplate.queryForList(selectQuery, no, cat, estbl_nm, tel_no, road_nm_addr, lat, lot);
    		System.out.println("리턴값이 없으면 실행");
    		if (result.isEmpty()) {	// 비어 있으면 true
    			System.out.println("api에서 가져온거 저장");
    			jdbcTemplate.update(query, no, cat, estbl_nm, tel_no, road_nm_addr, lat, lot);
    		}
	}
//2
//    public void apiData(int no, String cat, String estbl_nm, String tel_no, String road_nm_addr, Double lat, Double lot) {
//		String query = "INSERT INTO api (no, cat, estbl_nm, tel_no, road_nm_addr, lat, lot) VALUES (?, ?, ?, ?, ?, ?, ?)";
////		중복검사
//		String selectQuery = "SELECT * FROM api WHERE no = ? and cat = ? and estbl_nm = ? and tel_no = ? and road_nm_addr = ? and lat = ? and lot = ?";
//		List<Map<String, Object>> result = jdbcTemplate.queryForList(selectQuery, no, cat, estbl_nm, tel_no, road_nm_addr, lat, lot);
//		if (result.isEmpty()) {	// 비어 있으면 true
//		  jdbcTemplate.update(query, no, cat, estbl_nm, tel_no, road_nm_addr, lat, lot);
//		}
//    }
}
