package com.human.seoulroad.notice;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.human.seoulroad.user.CustomOAuth2UserService;
import com.human.seoulroad.user.SessionUserDTO;
import com.human.seoulroad.user.SiteUser;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("board")
@Controller
public class NoticeController {
	
	private final NoticeService noticeService;
	private final CustomOAuth2UserService userService;

	// 공지 페이지 매핑
	@GetMapping("notice")
	public String qna(Model model,
			@RequestParam(value="page", defaultValue="0") int page,
			@RequestParam(value="kw", defaultValue="") String kw) {
		
		Page<Notice> paging = this.noticeService.getList(page, kw);
		model.addAttribute("paging",paging);
		model.addAttribute("kw", kw);
		
		return "bbs/bbsNotice";
	}
	
	// 공지 상세 페이지 매핑
	@RequestMapping(value = "notice/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		
		// 서비스를 통해 객체를 가져와 템플릿에 전달
		Notice notice = this.noticeService.getNotice(id);
		model.addAttribute("notice", notice);
		
		return "bbs/bbsNoticeDetail";
	}
	
	// 공지 등록 메서드
	@GetMapping("notice/create")
	public String noticeCreate(NoticeForm noticeForm) {
		return "bbs/bbsNoticeForm";
	}

	// 공지 등록 처리 메서드
	@PostMapping("notice/create")
	// 제목, 내용, 작성자를 파라미터로 받음
	public String questionCreate(@Valid NoticeForm noticeForm, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
        	
            return "bbs/bbsNoticeForm";
        }

        // 세션 만료
        if(userService.getSession() == null) {
        	return "redirect:/main";
        }else { // 로그인한경우
        	SessionUserDTO userinfo = userService.getSession();
        	SiteUser siteUser = this.userService.getUser(userinfo.getEmail());
        	
        	this.noticeService.create(noticeForm.getSubject(), noticeForm.getContent(), siteUser);
        	return "redirect:/board/notice";
        }

    }
	
	// 공지 수정 메서드
    @PreAuthorize("isAuthenticated()") // 로그인 필요
    @RequestMapping("/notice/modify/{id}")
    public String questionModify(NoticeForm noticeForm,
    							 @PathVariable("id") Integer id, 
    							 Principal principal) {
    	
        Notice notice = this.noticeService.getNotice(id);
        SessionUserDTO userinfo = userService.getSession();
        
        if(!notice.getAuthor().getEmail().equals(userinfo.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        
        // 수정시 questionForm 리턴
        noticeForm.setSubject(notice.getSubject());
        noticeForm.setContent(notice.getContent());
        return "bbs/bbsNoticeForm";
    }
    
    // 수정 메서드 처리
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/notice/modify/{id}")
    public String questionModify(@Valid NoticeForm questionForm,
    							 BindingResult bindingResult, 
    							 Principal principal, 
    							 @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "bbs/bbsNoticeForm";
        }
        Notice notice = this.noticeService.getNotice(id);
        SessionUserDTO userinfo = userService.getSession();
        if (!notice.getAuthor().getEmail().equals(userinfo.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.noticeService.modify(notice,
        							questionForm.getSubject(),
        							questionForm.getContent());
        return String.format("redirect:/board/notice/detail/%s", id);
    }
    
    // 공지 삭제 메서드
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/notice/delete/{id}")
    public String questionDelete(Principal principal,
    							 @PathVariable("id") Integer id) {
    	Notice notice = this.noticeService.getNotice(id);
        SessionUserDTO userinfo = userService.getSession();
        
        // 사용자 검사
        if (!notice.getAuthor().getEmail().equals(userinfo.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        this.noticeService.delete(notice);
        return "redirect:/";
    }

    // 공지 추천 메서드
    @PreAuthorize("isAuthenticated()") // 로그인한 사람만 추천 가능
    @GetMapping("/notice/vote/{id}")
    public String questionVote(Principal principal, @PathVariable("id") Integer id, HttpServletRequest request, RedirectAttributes re) {
        
        // 로그인 하지 않을 시 추천 x
        if(userService.getSession() == null) {
			String uri = request.getHeader("Referer");
			re.addFlashAttribute("referer",uri);
        	return "redirect:/user/login";
        }
        
        else { // 로그인시 수행되는 메서드
        	Notice notice = this.noticeService.getNotice(id);
        	SiteUser siteUser = this.userService.getUser(userService.getSession().getEmail());
        
	        // 추천 중복검사
	        if (notice.getVoter().contains(siteUser) == true) {
	        	this.noticeService.votedel(notice, siteUser);
	        }
	        else {
	        	this.noticeService.vote(notice, siteUser);
	        }
	        return String.format("redirect:/board/notice/detail/%s", id);
        }
        
        
    }
    
}
