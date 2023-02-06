package com.human.seoulroad.review5;

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
public class reviewController5 {
	
	private final CustomOAuth2UserService userService;
	
	private final reviewService10 reviewService10;
	private final reviewService11 reviewService11;

    @GetMapping("/nature")
    public String list(Model model, @RequestParam(value="page10", defaultValue="0") int page10,
						    		@RequestParam(value="page11", defaultValue="0") int page11)
    {
        Page<review10> paging10 = this.reviewService10.getList(page10);
        model.addAttribute("paging10", paging10);
               
        Page<review11> paging11 = this.reviewService11.getList(page11);
        model.addAttribute("paging11", paging11);
        return "rcmNature";
        
    }
    @GetMapping("/create10")
    public String reviewCreate8(reviewForm10 reviewForm10,HttpServletRequest request, RedirectAttributes re) {
    	
		if(userService.getSession() == null) {
			String uri = request.getHeader("Referer");
			re.addFlashAttribute("referer",uri);
        	return "redirect:/user/login";
		}
    	
        return "reviewForm10";
    }

    @GetMapping("/create11")
    public String reviewCreate11(reviewForm11 reviewForm11,HttpServletRequest request, RedirectAttributes re) {
		if(userService.getSession() == null) {
			String uri = request.getHeader("Referer");
			re.addFlashAttribute("referer",uri);
        	return "redirect:/user/login";
		}    	
        return "reviewForm11";
    }
    
    
    @PostMapping("/create10")
    public String reviewCreate10(@Valid reviewForm10 reviewForm10, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reviewform10";
        }
    	this.reviewService10.create(reviewForm10.getReviewStar10(), userService.getSession().getNickname(), reviewForm10.getReviewContents10());
        return "redirect:/recommendcourse/nature"; 
    }
    

    
    @PostMapping("/create11")
    public String reviewCreate11(@Valid reviewForm11 reviewForm11, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reviewform11";
        }
    	this.reviewService11.create(reviewForm11.getReviewStar11(), userService.getSession().getNickname(), reviewForm11.getReviewContents11());
        return "redirect:/recommendcourse/nature"; 
    }

    
}