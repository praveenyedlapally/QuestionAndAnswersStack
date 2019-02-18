package com.qc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qc.dao.SignUpDao;
import com.qc.dto.SignUpDto;
import com.qc.service.ManageQuickCodeService;
import com.qc.user.SignUp;




@Controller
@RequestMapping("signup.htm")
public class SignupController{
	
	private ManageQuickCodeService  manageQuickCodeService;
	
	
     
	


	public void setManageQuickCodeService(ManageQuickCodeService manageQuickCodeService) {
		this.manageQuickCodeService = manageQuickCodeService;
	}


	/*public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView =new ModelAndView();
		
		modelAndView.setViewName("signup");
		return modelAndView;
	}
*/
	@GetMapping
	public String getSignup(Model model)
	{
		
		SignUp signUp = new SignUp();
		model.addAttribute("signUp", signUp);
		return "signup";
	
		
	}
	@PostMapping
	public String addSignup(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("psw") String psw, ModelMap modelMap) {
		SignUpDto signUpDto =new SignUpDto();
		
		signUpDto.setName(name);
		signUpDto.setEmail(email);
		signUpDto.setPsw(psw);
		
		manageQuickCodeService.saveSignUp(signUpDto);
		

		return "dashboard";
	}
}