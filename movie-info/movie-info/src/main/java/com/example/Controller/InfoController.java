package com.example.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path="/api")
public class InfoController {
	
	@Autowired
	public RestTemplate restTemplate;

	@RequestMapping(path="/info")
	public List<String> movieinfo() {
		
		List<String> list = new ArrayList<>();
		list.add("Batman");
		list.add("Supermnan");
		list.add("Spiderman");
		
		return list;
	}
	
	@RequestMapping(path = "/fromrating")
	public List<Integer> fromrating(){
		List<Integer> list= restTemplate.getForObject("http://movie-ratings/movie/rating", List.class);
		return list;
	}
}
