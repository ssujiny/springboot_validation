package com.study.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator	{
	
	@Override
	public boolean supports(Class<?> arg0) {
		//검증할 객체의 클래스 타입 정보
		return ContentDto.class.isAssignableFrom(arg0);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {
		
		// 모든 객체를 받을 수 있도록 Object로 받아서 형변환("자식은 부모한테 대입가능")
		ContentDto dto = (ContentDto)obj;
		
		/* 1. Validator 버전
		String sWriter = dto.getWriter();
		if(sWriter == null || sWriter.trim().isEmpty()) {
			System.out.println("Writer is null or empty");
			errors.rejectValue("writer", "trouble");
		}
		
		String sContent = dto.getContent();
		if(sContent == null || sContent.trim().isEmpty()) {
			System.out.println("content is null or empty");
			errors.rejectValue("content", "trouble");
		}
		*/
		
		// 2. ValidationUtil 버전
		ValidationUtils.rejectIfEmpty(errors, "writer", "writer is empty");
		String sWriter = dto.getWriter();
		if(sWriter.length() < 3) {
			errors.rejectValue("writer", "writer is too short");
		}
		
		ValidationUtils.rejectIfEmpty(errors, "content", "content is empty");
	}

	
}
