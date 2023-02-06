package com.human.seoulroad.review4;

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
@Table(name = "REVIEW_LIST9")
public class review9 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sortnum9;
	
	@Column
	private String id9;

	@Column
	private String reviewContents9;
	
	@Column
	private String reviewStar9;
	
	
	private LocalDateTime createDate9;

}

