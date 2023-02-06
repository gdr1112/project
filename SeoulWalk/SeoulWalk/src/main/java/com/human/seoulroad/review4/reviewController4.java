package com.human.seoulroad.review4;

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

@RequestMapping("/recommendcourse")
@RequiredArgsConstructor
@Controller
public class reviewController4 {
	
	private final CustomOAuth2UserService userService;
	
	private final reviewService8 reviewService8;
	private final reviewService9 reviewService9;

    @GetMapping("/restaurant")
    public String list(Model model, @RequestParam(value="page8", defaultValue="0") int page8,
						    		@RequestParam(value="page9", defaultValue="0") int page9)
    {
        Page<review8> paging8 = this.reviewService8.getList(page8);
        model.addAttribute("paging8", paging8);
               
        Page<review9> paging9 = this.reviewService9.getList(page9);
        model.addAttribute("paging9", paging9);
        return "rcmRestaurant";
        
    }
    @GetMapping("/create8")
    public String reviewCreate8(reviewForm8 reviewForm8,HttpServletRequest request, RedirectAttributes re) {
    	
		if(userService.getSession() == null) {
			String uri = request.getHeader("Referer");
			re.addFlashAttribute("referer",uri);
        	return "redirect:/user/login";
		}
    	
        return "reviewForm8";
    }

    @GetMapping("/create9")
    public String reviewCreate9(reviewForm9 reviewForm9,HttpServletRequest request, RedirectAttributes re) {
		if(userService.getSession() == null) {
			String uri = request.getHeader("Referer");
			re.addFlashAttribute("referer",uri);
        	return "redirect:/user/login";
		}    	
        return "reviewForm9";
    }
    
    
    @PostMapping("/create8")
    public String reviewCreate8(@Valid reviewForm8 reviewForm8, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reviewform8";
        }
    	this.reviewService8.create(reviewForm8.getReviewStar8(), userService.getSession().getNickname(), reviewForm8.getReviewContents8());
        return "redirect:/recommendcourse/restaurant"; 
    }
    

    
    @PostMapping("/create9")
    public String reviewCreate9(@Valid reviewForm9 reviewForm9, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reviewform9";
        }
    	this.reviewService9.create(reviewForm9.getReviewStar9(), userService.getSession().getNickname(), reviewForm9.getReviewContents9());
        return "redirect:/recommendcourse/restaurant"; 
    }

    
}