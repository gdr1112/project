package com.human.seoulroad.review3;

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
public class reviewController3 {
	
	private final CustomOAuth2UserService userService;
	
	private final reviewService5 reviewService5;
	private final reviewService6 reviewService6;
	private final reviewService7 reviewService7;

    @GetMapping("/family")
    public String list(Model model, @RequestParam(value="page5", defaultValue="0") int page5,
						    		@RequestParam(value="page6", defaultValue="0") int page6,
						    		@RequestParam(value="page7", defaultValue="0") int page7)
    {
        Page<review5> paging5 = this.reviewService5.getList(page5);
        model.addAttribute("paging5", paging5);
        
        Page<review6> paging6 = this.reviewService6.getList(page6);
        model.addAttribute("paging6", paging6);
        
        Page<review7> paging7 = this.reviewService7.getList(page7);
        model.addAttribute("paging7", paging7);
        return "rcmFamily";
        
    }
    @GetMapping("/create5")
    public String reviewCreate5(reviewForm5 reviewForm5,HttpServletRequest request, RedirectAttributes re) {
    	
		if(userService.getSession() == null) {
			String uri = request.getHeader("Referer");
			re.addFlashAttribute("referer",uri);
        	return "redirect:/user/login";
		}
    	
        return "reviewForm5";
    }
    @GetMapping("/create6")
    public String reviewCreate6(reviewForm6 reviewForm6,HttpServletRequest request, RedirectAttributes re) {
		if(userService.getSession() == null) {
			String uri = request.getHeader("Referer");
			re.addFlashAttribute("referer",uri);
        	return "redirect:/user/login";
		}    	
        return "reviewForm6";
    }
    @GetMapping("/create7")
    public String reviewCreate7(reviewForm7 reviewForm7,HttpServletRequest request, RedirectAttributes re) {
		if(userService.getSession() == null) {
			String uri = request.getHeader("Referer");
			re.addFlashAttribute("referer",uri);
        	return "redirect:/user/login";
		}    	
        return "reviewForm7";
    }
    
    
    @PostMapping("/create5")
    public String reviewCreate5(@Valid reviewForm5 reviewForm5, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reviewform5";
        }
    	this.reviewService5.create(reviewForm5.getReviewStar5(), userService.getSession().getNickname(), reviewForm5.getReviewContents5());
        return "redirect:/recommendcourse/family"; 
    }
    
    @PostMapping("/create6")
    public String reviewCreate6(@Valid reviewForm6 reviewForm6, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reviewform6";
        }
    	this.reviewService6.create(reviewForm6.getReviewStar6(), userService.getSession().getNickname(), reviewForm6.getReviewContents6());
        return "redirect:/recommendcourse/family"; 
    }
    
    @PostMapping("/create7")
    public String reviewCreate7(@Valid reviewForm7 reviewForm7, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reviewform7";
        }
    	this.reviewService7.create(reviewForm7.getReviewStar7(), userService.getSession().getNickname(), reviewForm7.getReviewContents7());
        return "redirect:/recommendcourse/family"; 
    }

    
}