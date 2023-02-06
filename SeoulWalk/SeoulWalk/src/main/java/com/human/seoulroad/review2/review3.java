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
@Table(name = "REVIEW_LIST3")
public class review3 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sortnum3;
	
	@Column
	private String id3;

	@Column
	private String reviewContents3;
	
	@Column
	private String reviewStar3;
	
	
	private LocalDateTime createDate3;

}

