package com.yubi.geographycolumns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yubi.geographycolumns.dao.GeographyColumnsRepositoryImpl;
import com.yubi.geographycolumns.entity.OldNewMap;

@Service
public class GeographyService {
	
	@Autowired
	private GeographyColumnsRepositoryImpl repo;
	
	public List<String> getList(String tabName,String colName){
		return repo.getDistinctList(tabName, colName);
	}

	public void updateColValues(String tabName, String colName, List<OldNewMap> newList) {
		repo.updateCols(tabName,colName,newList);
		
	}
}
