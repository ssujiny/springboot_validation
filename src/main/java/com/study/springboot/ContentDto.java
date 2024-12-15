package com.study.springboot;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ContentDto {
	/* 1~3. 버전
	private int id;
	private String writer;
	private String content;
	*/
	
	private int id;
	
	@NotNull(message="writer is null.")
	@NotEmpty(message="writer is empty.")
	@Size(min=3, max=10, message="writer min 3, max 10")
	private String writer;
	
	@NotNull(message="content is null.")
	@NotEmpty(message="content is empty.")
	private String content;
	
}
