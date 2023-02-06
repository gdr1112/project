package com.human.seoulroad.course;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

//CREATE TABLE IF NOT EXISTS COURSE8 AS SELECT * FROM CSVREAD('classpath:course8.csv');

@Entity
@Getter
@Table(name = "COURSE8")
public class Course8 {
	
	@Id
	private int sortnum;
	
	@Column
	private String lat;
	
	@Column
	private String lng;

}
