package com.yubi.geographycolumns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yubi.geographycolumns.entity.OldNewMap;
import com.yubi.geographycolumns.service.GeographyService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/geography")
public class GeographyController {
	
	@Autowired
	private GeographyService service;
	
	@GetMapping("/list")
	public ResponseEntity<List<String>> getDistinctListforUpdate(@RequestParam String tabName,@RequestParam String colName){
		List<String> result=service.getList(tabName, colName);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@PutMapping("/update/{tabName}/{colName}")
	public ResponseEntity updateColValues(@PathVariable String tabName,@PathVariable String colName,@RequestBody List<OldNewMap> newList ){
		service.updateColValues(tabName, colName,newList);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
