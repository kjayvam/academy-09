package com.javasw.project.map.controller;

import com.javasw.project.map.di.MapController_Service;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.io.IOException;

@Controller
//@EnableScheduling	// 스케줄링 반복 작업 수행 실시
public class MapController {
	
//	@Autowired
//	@Qualifier("MapController_Service")
	MapController_Service cs;	

//	public static void main(String[] args) throws IOException, ParseException {
//		Model model = new ExtendedModelMap();
//		executeApi(model);
//	}

//	@Scheduled(cron = 초(0~59), 분(0~59), 시(0~23), 일(1~31), 월(1~12), 요일(0~7))	요일은 일요일부터 시작
//	@Scheduled(cron = "* * * 1 * *") // 매월 1일 실행
	public void executeApi(Model model) throws IOException, ParseException {
		System.out.println("cs : " + cs);
		cs.getApiService().execute(model);
//		ApiExplorer api = new ApiExplorer();
//		api.execute(model);
	}
}
