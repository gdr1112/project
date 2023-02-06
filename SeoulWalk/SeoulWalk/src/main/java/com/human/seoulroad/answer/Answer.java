package com.human.seoulroad.answer;

import java.time.LocalDateTime;
import java.util.Set;

import com.human.seoulroad.question.Question;
import com.human.seoulroad.user.SiteUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
	
	// 답변 id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	// 답변 내용
	@Column(columnDefinition = "TEXT")
	private String content;
	
	// 답변 시각
	private LocalDateTime createDate;
	
	// 질문
	@ManyToOne
	private Question question;
	
	@ManyToOne
	// 답변 글쓴이
	private SiteUser author;
	
	// 수정 시간
	private LocalDateTime modifyDate;
	
	// 추천인
    @ManyToMany
    Set<SiteUser> voter;
}
