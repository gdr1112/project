package com.human.seoulroad.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "COURSE1")
public class Course1 {
	
	@Id
	private int sortnum;
	
	@Column()
	private String lat;
	
	@Column()
	private String lng;

}
