package com.src.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.src.model.StudentData;
import com.src.service.TechChefService;

@RestController
public class TechChefController {

	
	@Autowired
	public TechChefService service;
	
	@GetMapping("/email/{id}")
	public String getData(@PathVariable String id) {
		StudentData response = service.restTemplate().getForObject("https://reqres.in/api/users/"+id, StudentData.class);
		
		return response.getData().getEmail();
	}
}
