package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;

@Controller
public class MyController {
	
	@GetMapping("/")
	public @ResponseBody String root() throws Exception {
		return "Valid_initBinder (3)";
	}
	
	@GetMapping("/insertForm")
	public String insert1() {
		return "createPage";
	}
	
	//@Valid -> contentDto 유효성 검증하겠다는 표시
	@GetMapping("/create")
	public String insert2(@ModelAttribute("dto") @Valid ContentDto contentDto, BindingResult result) {
		String page = "createDonePage";
		System.out.println(contentDto);
		/*
		 	1. Validator 2. ValidationUtils 버전
			강한 결합 상태
			ContentValidator validator = new ContentValidator();
			validator.validate(contentDto, result);
		*/
		if(result.hasErrors()) {
			//System.out.println("getAllErrors : " + result.getAllErrors());
			
			if(result.getFieldError("writer") != null) {
				System.out.println("1: " + result.getFieldError("writer").getCode());
			}
			if(result.getFieldError("content") != null) {
				System.out.println("2: " + result.getFieldError("content").getCode());
			}
			
			page = "createPage";
		}
		return page;
	}
	/* 진행순서
	 	1) 파라미터로 객체 변수 들어오면
	 	2) 스프링이 binder 변수에 저장된 객체 통해서 즉시 유효성 검사
	 	3) 에러가 있다면 result 변수에 저장
	 */
	
	// 프로젝트 시작시 먼저 실행되어 메서드 등록
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		//약한 결합 상태 
		binder.setValidator(new ContentValidator());
	}
	
}
