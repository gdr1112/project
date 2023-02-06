package com.human.seoulroad.review5;

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
@Table(name = "REVIEW_LIST11")
public class review11 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sortnum11;
	
	@Column
	private String id11;

	@Column
	private String reviewContents11;
	
	@Column
	private String reviewStar11;
	
	
	private LocalDateTime createDate11;

}

