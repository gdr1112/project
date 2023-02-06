package com.human.seoulroad.review2;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "REVIEW_LIST2")
public class review2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sortnum2;
	
	@Column
	private String id2;

	@Column
	private String reviewContents2;
	
	@Column
	private String reviewStar2;
	
	
	private LocalDateTime createDate2;

}

