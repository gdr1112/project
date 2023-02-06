package com.human.seoulroad.review3;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class reviewForm5 {

	private String id5;
	
	@NotEmpty(message="내용을 입력해주세요.")
	@Size(max=100)
	private String reviewContents5;
	
	@NotEmpty(message="별점을 선택해주세요.")
	private String reviewStar5;
}

