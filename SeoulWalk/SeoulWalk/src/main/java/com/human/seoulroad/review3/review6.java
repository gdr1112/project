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
@Table(name = "REVIEW_LIST6")
public class review6 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sortnum6;
	
	@Column
	private String id6;

	@Column
	private String reviewContents6;
	
	@Column
	private String reviewStar6;
	
	
	private LocalDateTime createDate6;

}

