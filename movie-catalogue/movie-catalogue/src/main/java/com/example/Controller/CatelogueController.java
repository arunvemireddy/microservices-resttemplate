package com.example.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/movie")
public class CatelogueController {

	@RequestMapping(path="/catelogue")
	public List<Integer> catelogue(){
		List<Integer> list = new ArrayList<>();
		list.add(1);
		return list;
	}
}
