package com.human.seoulroad.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.human.seoulroad.answer.Answer;
import com.human.seoulroad.user.SiteUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
	
	// 질문ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	// 질문 제목
	@Column(length = 200)
	private String subject;
	
	
	// 질문 내용
	@Column(columnDefinition = "TEXT")
	private String content;
	
	// 질문 시간
	private LocalDateTime createDate;
	
	
	// 질문에 해당하는 답변
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;
	
	// 질문 글쓴이
	@ManyToOne
	private SiteUser author;
	
	// 수정 시간
	private LocalDateTime modifyDate;
	
	// 추천인
    @ManyToMany
    Set<SiteUser> voter;
}