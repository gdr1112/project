package com.human.seoulroad.review2;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.human.seoulroad.user.CustomOAuth2UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("recommendcourse")
@RequiredArgsConstructor
@Controller
public class reviewController2 {
	
	private final CustomOAuth2UserService userService;
	
	private final reviewService2 reviewService2;
	private final reviewService3 reviewService3;
	private final reviewService4 reviewService4;

    @GetMapping("/couple")
    public String list(Model model, @RequestParam(value="page2", defaultValue="0") int page2,
						    		@RequestParam(value="page3", defaultValue="0") int page3,
						    		@RequestParam(value="page4", defaultValue="0") int page4)
    {
        Page<review2> paging2 = this.reviewService2.getList(page2);
        model.addAttribute("paging2", paging2);
        
        Page<review3> paging3 = this.reviewService3.getList(page3);
        model.addAttribute("paging3", paging3);
        
        Page<review4> paging4 = this.reviewService4.getList(page4);
        model.addAttribute("paging4", paging4);
        
        return "rcmCouple";
        
    }
    @GetMapping("/create2")
    public String reviewCreate2(reviewForm2 reviewForm2, HttpServletRequest request, RedirectAttributes re) {
    	
		if(userService.getSession() == null) {
			String uri = request.getHeader("Referer");
			re.addFlashAttribute("referer",uri);
        	return "redirect:/user/login";
		}
    	
        return "reviewForm2";
    }
    @GetMapping("/create3")
    public String reviewCreate3(reviewForm3 reviewForm3,HttpServletRequest request, RedirectAttributes re) {
		if(userService.getSession() == null) {
			String uri = request.getHeader("Referer");
			re.addFlashAttribute("referer",uri);
        	return "redirect:/user/login";
		}    	
        return "reviewForm3";
    }
    @GetMapping("/create4")
    public String reviewCreate4(reviewForm4 reviewForm4,HttpServletRequest request, RedirectAttributes re) {
		if(userService.getSession() == null) {
			String uri = request.getHeader("Referer");
			re.addFlashAttribute("referer",uri);
        	return "redirect:/user/login";
		}    	
        return "reviewForm4";
    }
    
    
    @PostMapping("/create2")
    public String reviewCreate2(@Valid reviewForm2 reviewForm2, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reviewform2";
        }
    	this.reviewService2.create(reviewForm2.getReviewStar2(), userService.getSession().getNickname(), reviewForm2.getReviewContents2());
        return "redirect:/recommendcourse/couple"; 
    }
    
    @PostMapping("/create3")
    public String reviewCreate3(@Valid reviewForm3 reviewForm3, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reviewform3";
        }
    	this.reviewService3.create(reviewForm3.getReviewStar3(), userService.getSession().getNickname(), reviewForm3.getReviewContents3());
        return "redirect:/recommendcourse/couple"; 
    }
    
    @PostMapping("/create4")
    public String reviewCreate4(@Valid reviewForm4 reviewForm4, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reviewform4";
        }
    	this.reviewService4.create(reviewForm4.getReviewStar4(), userService.getSession().getNickname(), reviewForm4.getReviewContents4());
        return "redirect:/recommendcourse/couple"; 
    }

    
}