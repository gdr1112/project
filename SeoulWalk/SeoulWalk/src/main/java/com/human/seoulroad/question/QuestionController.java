package com.human.seoulroad.question;

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

import com.human.seoulroad.answer.AnswerForm;
import com.human.seoulroad.user.CustomOAuth2UserService;
import com.human.seoulroad.user.SessionUserDTO;
import com.human.seoulroad.user.SiteUser;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("board")
@Controller
public class QuestionController {
	
	private final QuestionService questionService;
	private final CustomOAuth2UserService userService;

	
	// qna 페이지 매핑
	@GetMapping("qna")
	public String qna(Model model,
			@RequestParam(value="page", defaultValue="0") int page,
			@RequestParam(value="kw", defaultValue="") String kw) {
		
		Page<Question> paging = this.questionService.getList(page, kw);
		model.addAttribute("paging",paging);
		model.addAttribute("kw", kw);
		
		return "bbs/bbsQna";
	}
	
	
	// 질문 상세 페이지 매핑
	@RequestMapping(value = "qna/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id,
			AnswerForm answerForm) {
		
		// 서비스를 통해 객체를 가져와 템플릿에 전달
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		
		return "bbs/bbsQnaDetail";
	}
	
	// 질문 등록 메서드 
	@GetMapping("qna/create")
	public String questionCreate(QuestionForm questionForm, HttpServletRequest request, RedirectAttributes re) {
		if(userService.getSession() == null) {
            // 회원이 아닐 시, 이전 uri를 flashattribute로 보내준다
			String uri = request.getHeader("Referer");
			re.addFlashAttribute("referer",uri);
			return "redirect:/user/login";
		}else {
			return "bbs/bbsQnaForm";
		}
    }
	
	// 질문 등록 처리 메서드
	@PostMapping("qna/create")
	// 제목, 내용, 작성자를 파라미터로 받음
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
        	
            return "bbs/bbsQnaForm";
        }

        // 세션 만료
        if(userService.getSession() == null) {
        	return "redirect:/main";
        }else { // 로그인한경우
        	SessionUserDTO userinfo = userService.getSession();
        	SiteUser siteUser = this.userService.getUser(userinfo.getEmail());
        	
        	this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
        	return "redirect:/board/qna";
        }

    }
	
	
	// 수정 URL매핑 (GET)
    @PreAuthorize("isAuthenticated()") // 로그인 필요
    @RequestMapping("/qna/modify/{id}")
    public String questionModify(QuestionForm questionForm,
    							 @PathVariable("id") Integer id, 
    							 Principal principal) {
    	
        Question question = this.questionService.getQuestion(id);
        SessionUserDTO userinfo = userService.getSession();
        
        if(!question.getAuthor().getEmail().equals(userinfo.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        
        // 수정시 questionForm 리턴
        questionForm.setSubject(question.getSubject());
        questionForm.setContent(question.getContent());
        return "bbs/bbsQnaForm";
    }
    
    // 수정 URL매핑 (POST)
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/qna/modify/{id}")
    public String questionModify(@Valid QuestionForm questionForm,
    							 BindingResult bindingResult, 
    							 Principal principal, 
    							 @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "bbs/bbsQnaForm";
        }
        Question question = this.questionService.getQuestion(id);
        SessionUserDTO userinfo = userService.getSession();
        if (!question.getAuthor().getEmail().equals(userinfo.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.questionService.modify(question,
        							questionForm.getSubject(),
        							questionForm.getContent());
        return String.format("redirect:/board/qna/detail/%s", id);
    }
    
    // 삭제 URL 매핑 (GET)
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/qna/delete/{id}")
    public String questionDelete(Principal principal,
    							 @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        SessionUserDTO userinfo = userService.getSession();
        
        // 사용자 검사
        if (!question.getAuthor().getEmail().equals(userinfo.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        this.questionService.delete(question);
        return "redirect:/";
    }

    // 추천 URL 매핑 (GET)
    @GetMapping("/qna/vote/{id}")
    public String questionVote(Principal principal, @PathVariable("id") Integer id, HttpServletRequest request, RedirectAttributes re) {
        
        // 로그인 하지 않을 시 추천 x
        if(userService.getSession() == null) {
			String uri = request.getHeader("Referer");
			re.addFlashAttribute("referer",uri);
        	return "redirect:/user/login";
        }
        
        else { // 로그인시 수행되는 메서드
        	Question question = this.questionService.getQuestion(id);
	        SiteUser siteUser = this.userService.getUser(userService.getSession().getEmail());
	        
	        // 추천 중복검사
	        if (question.getVoter().contains(siteUser) == true) {
	        	this.questionService.votedel(question, siteUser);
	        }
	        else {
	        	this.questionService.vote(question, siteUser);
	        }
	        return String.format("redirect:/board/qna/detail/%s", id);
        }
    }

}
