package com.qc.controller;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qc.dto.AnswerDto;
import com.qc.dto.QuestionDto;
import com.qc.service.ManageQuickCodeService;
import com.qc.user.PostQuestion;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	private ManageQuickCodeService  manageQuickCodeService;
	
	

	public void setManageQuickCodeService(ManageQuickCodeService manageQuickCodeService) {
		this.manageQuickCodeService = manageQuickCodeService;
	}
	@GetMapping
	public String getDashboard(Model model)
	{
		System.out.println("hello m");
		PostQuestion postQuestion = new PostQuestion();
		model.addAttribute("postQuestion", postQuestion);
        List<QuestionDto> questionDtos=manageQuickCodeService.getQuestions();
		
		model.addAttribute("questionDtos", questionDtos);
		return "dashboard";
		
		
	}
/*	@RequestMapping("/allQuestions")
	public Object getQuestions(ModelMap modelMap)
	{
		List<QuestionDto> questionDtos=manageQuickCodeService.getQuestions();
		
		modelMap.addAttribute("questionDtos", questionDtos);
		return "dashboard";
	}
*/

	
	@RequestMapping(value = "/question", method = RequestMethod.POST)
	public String addDashboardData(@RequestParam("question") String question,@RequestParam("email") String email, ModelMap modelMap) {
		
	     QuestionDto questionDto =new QuestionDto();
	     questionDto.setEmail(email);
         questionDto.setQuestion(question);		
	     System.out.println(email+"hghjvvh  "+question);

 		manageQuickCodeService.saveQuestion(questionDto);
 		/*List<AnswerDto> answerDtos=manageQuickCodeService.getAnswers();
 		for(AnswerDto answerDto :answerDtos)
 		{
 			System.out.println(answerDto.getAnswerText()+"    "+answerDto.getQuestion()+"    "+answerDto.getEmail());
 		}*/
 		List<QuestionDto> questionDtos=manageQuickCodeService.getQuestions();
 		for(QuestionDto questionDto2 :questionDtos)
 		{
 			System.out.println(questionDto2.getEmail()+" all Questions      "+questionDto2.getQuestion());
 		}
		return "dashboard";
	}
}
