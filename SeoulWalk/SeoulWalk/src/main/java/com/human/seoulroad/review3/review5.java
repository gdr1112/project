package com.human.seoulroad.review3;

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
@Table(name = "REVIEW_LIST5")
public class review5 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sortnum5;
	
	@Column
	private String id5;

	@Column
	private String reviewContents5;
	
	@Column
	private String reviewStar5;
	
	
	private LocalDateTime createDate5;

}

