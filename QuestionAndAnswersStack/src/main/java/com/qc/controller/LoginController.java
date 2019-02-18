package com.qc.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qc.bo.LoginBo;
import com.qc.dto.LoginDto;
import com.qc.dto.SignUpDto;
import com.qc.service.ManageQuickCodeService;
import com.qc.user.Login;
import com.qc.user.SignUp;

@Controller
@RequestMapping("login.htm")
public class LoginController{
	
	private ManageQuickCodeService  manageQuickCodeService;

	public void setManageQuickCodeService(ManageQuickCodeService manageQuickCodeService) {
		this.manageQuickCodeService = manageQuickCodeService;
	}
	
	@GetMapping
	public String getLogin(Model model)
	{
		
		Login login =new Login();
		model.addAttribute("login", login);
		return "login";
	}
	@PostMapping
	public String verifyLogin(@RequestParam("email") String email,@RequestParam("password") String psw, ModelMap modelMap) {
		
		
	 String Email =email;
	 String Password =psw;
	
		List<LoginDto> logins= manageQuickCodeService.getLogins();
		
		 System.out.println(Email+" "+Password);
		for(LoginDto bo:logins)
		{ 
			
				System.out.println(bo.getEmail()+" 1 "+bo.getPassword());
				if(Email.equals(bo.getEmail()) && Password.equals(bo.getPassword()))
				{
					
					return "dashboard";
				}
				/*else
				{
					Login login =new Login();
					modelMap.addAttribute("login", login);
					return "login";
				}*/
				
			
			
			

	   }
		Login login =new Login();
		modelMap.addAttribute("login", login);

		return "login";
	}

/*	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}*/

}
