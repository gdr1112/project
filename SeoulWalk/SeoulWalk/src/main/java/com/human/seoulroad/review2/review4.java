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
@Table(name = "REVIEW_LIST4")
public class review4 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sortnum4;
	
	@Column
	private String id4;

	@Column
	private String reviewContents4;
	
	@Column
	private String reviewStar4;
	
	
	private LocalDateTime createDate4;

}

