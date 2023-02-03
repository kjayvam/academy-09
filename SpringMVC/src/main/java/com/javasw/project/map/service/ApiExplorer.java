package com.javasw.project.map.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.javasw.project.map.dao.MapDao;

@Service
public class ApiExplorer implements IMapService{
	public void execute(Model model) throws IOException, ParseException {
//오픈 API 샘플코드사용ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		String ServiceKey = "%2FGJ6bHlNqTlBqxllSmamENtTJqgM8pwpvFZM3xcS0yAAvFMcZaBp5OcYx9WHe0JFAMyppriUvj1kyyE2H%2Bo08A%3D%3D";	// 일반 인증키(Encoding)
//        1. URL 만들기
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/3510500/good_price_business/getList");	// URL
//        2. 오픈 API의 요청하여 규격에 맞는 파라미터 생성
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + ServiceKey);	// Service Key
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));	// 페이지번호(default : 1)
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("2", "UTF-8"));	// 페이지당수(default : 10)
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8"));	// JSON/XML(default : JSON)
//        3. URL 객체 생성
        URL url = new URL(urlBuilder.toString());
//        4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        5. 통신을 위한 메소드 SET
        conn.setRequestMethod("GET");
//        6. 통신을 위한 Content-type SET 
        conn.setRequestProperty("Content-type", "application/json");
//        7. 통신 응답 코드 확인 (200~300이면 API 요청이 성공했다는 뜻)
        System.out.println("Response code: " + conn.getResponseCode());
//        8. 전달받은 데이터를 BufferedReader 객체로 저장.
        BufferedReader rd;
        
        if(200 <= conn.getResponseCode() && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
//        9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장
        StringBuilder sb = new StringBuilder();
        String line;
        
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
//        10. 객체 해제
        rd.close();
        conn.disconnect();
//        11. 전달받은 데이터 확인
        String response = sb.toString();
        System.out.println(response);
//        12. parsing하여 데이터 추출
    	JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject)parser.parse(response);
    	JSONObject responseObject = (JSONObject) obj.get("response");
        JSONObject bodyObject = (JSONObject) responseObject.get("body");
        JSONObject itemsObject = (JSONObject) bodyObject.get("items");
        JSONArray itemArray = (JSONArray) itemsObject.get("item");
//        12-1. 추출 데이터 보기	// true & false		// 확인하기 위해 사용한것이다 AOP로 변환하자
        boolean condition = false;	
        if (condition) {	// if (condition == true)
        	System.out.println("JSON(obj) : " + obj);
        	System.out.println("JSON(response) : " + responseObject);
        	System.out.println("JSON(body) : " + bodyObject);
        	System.out.println("JSON(items) : " + itemsObject);
        	System.out.println("JSON(item[]) : " + itemArray);
        }
//        13. 조회 데이터 크기만큼 for문 + 테이블저장 
        MapDao dao = MapDao.getInstance();
        for (int i=0 ; i< itemArray.size() ; i++) {
        	JSONObject eqData = (JSONObject) itemArray.get(i);
//1
        	String no = (String) eqData.get("no").toString();
        	String cat = (String) eqData.get("cat").toString();	
        	String estbl_nm = (String) eqData.get("estbl_nm").toString();	
        	String tel_no = (String) eqData.get("tel_no");				
        	String road_nm_addr	= (String) eqData.get("road_nm_addr").toString();	
        	String lat = (String) eqData.get("lat").toString();	
        	String lot = (String) eqData.get("lot").toString();	
        	dao.apiData(no, cat, estbl_nm, tel_no, road_nm_addr, lat, lot);
//2
//        	int no = (int) eqData.get("no");
//        	String cat = (String) eqData.get("cat").toString();	
//        	String estbl_nm = (String) eqData.get("estbl_nm").toString();	
//        	String tel_no = (String) eqData.get("tel_no");				
//        	String road_nm_addr	= (String) eqData.get("road_nm_addr").toString();	
//        	double lat = (double) eqData.get("lat");	
//        	double lot = (double) eqData.get("lot");	
//        	dao.apiData(no, cat, estbl_nm, tel_no, road_nm_addr, lat, lot);
//3
//        	MapVo mapVo =  new MapVo();
//        	mapVo.setNo(Integer.parseInt((String) no));
//        	mapVo.setCat((String) cat);
//        	mapVo.setEstbl_nm((String) estbl_nm);
//        	mapVo.setTel_no((String) tel_no);
//        	mapVo.setRoad_nm_addr((String) road_nm_addr);
//        	mapVo.setLat(Double.parseDouble((String) lat));
//        	mapVo.setLot(Double.parseDouble((String) lot));
//        	
//        	model.addAttribute("store", mapVo);
////        14. DAO에 보내기
//        	dao.apiData(model);
		 }
    }
}
