package com.human.seoulroad.review4;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class reviewForm8 {

	private String id8;
	
	@NotEmpty(message="내용을 입력해주세요.")
	@Size(max=100)
	private String reviewContents8;
	
	@NotEmpty(message="별점을 선택해주세요.")
	private String reviewStar8;
}

