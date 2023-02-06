package com.human.seoulroad.course;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

@RequestMapping("/course")
@Controller
public class CourseController {
	
	@Autowired
	CourseRepository csRepository;
	
	
	@RequestMapping("")
	public String course() {
		return "course";
	}
	@RequestMapping("/1")
	public String course1(Model model) {
		
		// 데이터베이스 값 가져오기
		List<String> cs1List = csRepository.selectAll1();
		
		// 가져온 값 확인 - 타입 : java.util.ArrayList - 0번지 값 - 37.689445,127.047285
//		System.out.println(cs1List.getClass().getName());
//		System.out.println(cs1List.get(0));
		
		
		
		// 프런트로 넘겨주기 - 타임리프
//		model.addAttribute("cs",cs1List);
		
		// 배열 값 출력
//		System.out.println(Arrays.deepToString(cs1List.toArray()));
		
		// 프런트로 넘겨주기 - 자바스크립트 (json으로)
		String json = new Gson().toJson(cs1List);
//		System.out.println(json);

		model.addAttribute("cs",json);

		return "course1";
	}
	
	@RequestMapping("/2")
	public String course2(Model model) {
		List<String> cs = csRepository.selectAll2();
		String json = new Gson().toJson(cs);
		model.addAttribute("cs",json);
		return "course2";
	}
	
	@RequestMapping("/3")
	public String course3(Model model) {
		List<String> cs = csRepository.selectAll3();
		String json = new Gson().toJson(cs);
		model.addAttribute("cs",json);
		return "course3";
	}
	
	@RequestMapping("/4")
	public String course4(Model model) {
		List<String> cs = csRepository.selectAll4();
		String json = new Gson().toJson(cs);
		model.addAttribute("cs",json);
		return "course4";
	}
	
	@RequestMapping("/5")
	public String course5(Model model) {
		List<String> cs = csRepository.selectAll5();
		String json = new Gson().toJson(cs);
		model.addAttribute("cs",json);
		return "course5";
	}
	
	@RequestMapping("/6")
	public String course6(Model model) {
		List<String> cs = csRepository.selectAll6();
		String json = new Gson().toJson(cs);
		model.addAttribute("cs",json);
		return "course6";
	}
	
	@RequestMapping("/7")
	public String course7(Model model) {
		List<String> cs = csRepository.selectAll7();
		String json = new Gson().toJson(cs);
		model.addAttribute("cs",json);
		return "course7";
	}
	
	@RequestMapping("/8")
	public String course8(Model model) {
		List<String> cs = csRepository.selectAll8();
		String json = new Gson().toJson(cs);
		model.addAttribute("cs",json);
		return "course8";
	}
}
