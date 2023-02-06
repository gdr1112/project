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
@Table(name = "REVIEW_LIST10")
public class review10 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sortnum10;
	
	@Column
	private String id10;

	@Column
	private String reviewContents10;
	
	@Column
	private String reviewStar10;
	
	
	private LocalDateTime createDate10;

}

