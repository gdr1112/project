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
@Table(name = "REVIEW_LIST7")
public class review7 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sortnum7;
	
	@Column
	private String id7;

	@Column
	private String reviewContents7;
	
	@Column
	private String reviewStar7;
	
	
	private LocalDateTime createDate7;

}

