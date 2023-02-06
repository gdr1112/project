package com.human.seoulroad.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	
	@GetMapping("/roadtest")
	public String roadTest() {
		return "test/test";
	}
	
	@GetMapping(path = "/seoulwalktest/{result}")
	public String sns(@PathVariable(name = "result") String result ,Model model) {
		model.addAttribute("result",result);
		return "test/testresult";
		
	}
	
	// 테스트 결과 보여주기
	@PostMapping("/seoulwalktest")
	public String tr(Model model,
					 @RequestParam String q1,
					 @RequestParam String q2,
					 @RequestParam String q3,
					 @RequestParam String q4,
					 @RequestParam String q5,
					 @RequestParam String q6,
					 @RequestParam String q7,
					 @RequestParam String q8){

		
		switch(searchWeight(q1, q3, q5, q7)) {
		case 0://가족 코스 분류
			
			switch(q4) {
			case "a"://가족1-예술의전당
				model.addAttribute("result","예술의 전당");
				break;
			case "b"://가족2-양재시민의숲
				model.addAttribute("result","양재시민의 숲");
				break;
			case "c"://가족3-선유도공원
				model.addAttribute("result","선유도공원");
				break;
			}
			
			break;
			
		case 1://커플 코스 분류
			
			switch(q2) {
			case "a"://커플1-하늘공원
				model.addAttribute("result","하늘공원");
				break;
			case "b"://커플2-안양천
				model.addAttribute("result","안양천 벚꽃길");
				break;
			case "c"://커플3-올림픽공원
				model.addAttribute("result","올림픽 공원");
				break;
			}			
			
			break;
			
		case 2://맛집 코스 분류
			
			switch(q6) {
			case "a"://맛집1-망리단길
				model.addAttribute("result","망리단길");
				break;
			case "b"://맛집2-북한산 둘레길
				model.addAttribute("result","북한산 둘레길");
				break;
			}			
			
			break;
			
		case 3://자연 코스 분류
			
			switch(q8) {
			case "a"://자연1-태릉
				model.addAttribute("result","태릉 강릉");
				break;
			case "b"://자연2-관악산
				model.addAttribute("result","관악산");
				break;
			}					
			
			break;
		
		}
		
		
		return "test/testresult";
	}
	
	
	
	
	// 가중치 함수 -> 인덱스 반환
	public int searchWeight(String q1,String q3,String q5,String q7) {
		int less = 3;
		int middle = 5;
		int high = 10;
		int[] weight = {10,10,10,10};
		
		//q1
		if(q1.equals("T")) {
			weight[0] = weight[0] + middle;
			weight[1] = weight[1] + middle;
			weight[2] = weight[2] + less;
		}else {
			weight[1] = weight[1] - 10;
			weight[3] = weight[3] + high;
		}
		
		//q3
		if(q3.equals("T")) {
			weight[0] = weight[0] + high;
			weight[1] = weight[1] + less;
			weight[2] = weight[2] + high;
			weight[3] = weight[3] + middle;
		}else {
			weight[1] = weight[1] + high;
			weight[2] = weight[2] + less;
		}
		
		//q5
		if(q5.equals("T")) {
			weight[0] = weight[0] + middle;
			weight[1] = weight[1] + middle;
			weight[2] = weight[2] + less;
		}else {
			weight[3] = weight[3] + high;
		}	
		
		//q7
		if(q7.equals("F")) {
			weight[2] = weight[2] + high;
		}
		
		// 인덱스 반환
		int[] max = {0};
		int maxindex = 0;
		for(int i = 0 ; i<weight.length ; i++) {
			if(weight[i] > max[0]) {
				max[0] = weight[i];
				maxindex = i;
			}
		}
		
		return maxindex;
	}
}
