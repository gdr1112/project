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
@Table(name = "REVIEW_LIST8")
public class review8 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sortnum8;
	
	@Column
	private String id8;

	@Column
	private String reviewContents8;
	
	@Column
	private String reviewStar8;
	
	
	private LocalDateTime createDate8;

}

