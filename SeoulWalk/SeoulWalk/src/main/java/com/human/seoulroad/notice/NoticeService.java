package com.human.seoulroad.notice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.human.seoulroad.DataNotFoundException;
import com.human.seoulroad.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeService {
	
	private final NoticeRepository noticeRepository;

	// 페이징 메서드
    public Page<Notice> getList(int page, String kw) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.noticeRepository.findAllByKeyword(kw, pageable);
    }
    
    // 공지 조회 메서드
    public Notice getNotice(Integer id) {
    	Optional<Notice> notice = this.noticeRepository.findById(id);
    	if(notice.isPresent()) {
    		return notice.get();
    	}else {
    		throw new DataNotFoundException("notice not found");
    	}

    }
    
    // 공지 생성 메서드
    public void create(String subject, String content, SiteUser user) {
    	Notice q = new Notice();
    	q.setSubject(subject);
    	q.setContent(content);
    	q.setCreateDate(LocalDateTime.now());
    	q.setAuthor(user);
    	this.noticeRepository.save(q);
    }
    
    // 공지 수정하는 메서드
    public void modify(Notice notice, String subject, String content) {
    	notice.setSubject(subject);
    	notice.setContent(content);
    	notice.setModifyDate(LocalDateTime.now());
        this.noticeRepository.save(notice);
    }
    
    // 질문 삭제 메서드
    public void delete(Notice notice) {
        this.noticeRepository.delete(notice);
    }
    
    // 질문 추천 메서드
    public void vote(Notice notice, SiteUser siteUser) {
    	notice.getVoter().add(siteUser);
        this.noticeRepository.save(notice);
    }
    
    // 질문 추천 취소 메서드
    public void votedel(Notice notice, SiteUser siteUser) {
    	notice.getVoter().remove(siteUser);
    	this.noticeRepository.save(notice);
    }
}
