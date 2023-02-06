package com.human.seoulroad.notice;

import java.time.LocalDateTime;
import java.util.Set;

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
public class Notice {
	
	// 공지 id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	// 공지 제목
	@Column(length = 200)
	private String subject;
	
	// 공지 내용
	@Column(columnDefinition = "TEXT")
	private String content;	
	
	// 공지 시간
	private LocalDateTime createDate;
	
	// 공지 글쓴이
	@ManyToOne
	private SiteUser author;
	
	// 수정 시간
	private LocalDateTime modifyDate;
	
	// 추천인
    @ManyToMany
    Set<SiteUser> voter;

}
