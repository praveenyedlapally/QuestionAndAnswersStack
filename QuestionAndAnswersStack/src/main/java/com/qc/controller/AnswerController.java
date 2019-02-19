package com.qc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qc.dto.AnswerDto;
import com.qc.service.ManageQuickCodeService;

@Controller
public class AnswerController {

	private ManageQuickCodeService  manageQuickCodeService;
	
	

	public void setManageQuickCodeService(ManageQuickCodeService manageQuickCodeService) {
		this.manageQuickCodeService = manageQuickCodeService;
	}
	
	@GetMapping
	public String getAnswer(Model model)
	{
		System.out.println("hello m");
		return "dashboard";	
		
	}
	

	@RequestMapping(value = "/answer", method = RequestMethod.POST)
	public String addDashboardData(@RequestParam("answerText") String answerText,@RequestParam("email") String email, ModelMap modelMap) {
		
	     AnswerDto answerDto =new AnswerDto();
	     answerDto.setEmail(email);
	     answerDto.setAnswerText(answerText);	
	     System.out.println(email+"hghjvvh  "+answerText);

 		manageQuickCodeService.saveAnswer(answerDto);
		return "dashboard";
	}
}
