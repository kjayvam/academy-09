package com.javasw.project.map.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.javasw.project.map.service.ApiExplorer;
import com.javasw.project.map.service.IMapService;

@Repository 
public class MapController_Service {

//	@Autowired
//	@Qualifier("ApiExplorer")
	private IMapService apiService;

	@Autowired
	public void setApiService(@Qualifier("ApiExplorer")IMapService apiService) {
		this.apiService = apiService;
	}

	public IMapService getApiService() {
		return apiService;
	}
}
