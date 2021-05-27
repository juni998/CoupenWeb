package com.group6.demo.controller;

import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

@Controller
public class CustomErrorController implements ErrorController {
	private static final Logger logger = LoggerFactory.getLogger(CustomErrorController.class);
	
	//에러 페이지 정의
	private final String ERROR_404_PAGE_PATH = "/error/404";
	private final String ERROR_500_PAGE_PATH = "/error/500";
	private final String ERROR_ETC_PAGE_PATH = "/error/error";
	
	@RequestMapping(value = "/error") 
	public String CustomError(HttpServletRequest request, Model model) {
		//에러 코드 획득
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE); 
		
		//에러 코드에 대한 상태 정보
		HttpStatus httpStatus = HttpStatus.valueOf(Integer.valueOf(status.toString())); 
		
		if (status != null) {
			// HttpStatus와 비교해 페이지 분기를 나누기 위한 변수
			int statusCode = Integer.valueOf(status.toString());
			
			//로그로 상태값을 기록 및 출력
			logger.info("httpStatus : " + statusCode);
			
			//404
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				//에러 페이지에 표시할 정보
				model.addAttribute("code", status.toString());
				model.addAttribute("msg", httpStatus.getReasonPhrase());
				model.addAttribute("timestamp", new Date()); 
				return ERROR_404_PAGE_PATH;
			}
			//500
			if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				// 서버에 대한 에러는 사용자한테 표시x
				return ERROR_500_PAGE_PATH; 
			}
		}
		return ERROR_ETC_PAGE_PATH;
	}
	//@Override
	public String getErrorPath() {
		return "/error";
	}		
	
	
	
	
	
}
