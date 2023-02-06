package com.human.seoulroad.course;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

//CREATE TABLE IF NOT EXISTS COURSE4 AS SELECT * FROM CSVREAD('classpath:course4.csv');

@Entity
@Getter
@Table(name = "COURSE4")
public class Course4 {
	
	@Id
	private int sortnum;
	
	@Column
	private String lat;
	
	@Column
	private String lng;

}
