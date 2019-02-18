package com.qc.service;

import java.util.ArrayList;
import java.util.List;

import com.qc.bo.LoginBo;
import com.qc.bo.SignUpBo;
import com.qc.dao.LoginDao;
import com.qc.dao.SignUpDao;
import com.qc.dto.LoginDto;
import com.qc.dto.SignUpDto;

public class ManageQuickCodeService {
	
	private SignUpDao signUpDao;
	
	private LoginDao loginDao;

	
	
	public ManageQuickCodeService(SignUpDao signUpDao, LoginDao loginDao) {
		this.signUpDao = signUpDao;
		this.loginDao = loginDao;
	}

	public List<LoginDto> getLogins()
	{
		List<LoginDto> loginDtos= new ArrayList<LoginDto>();
		List<LoginBo> loginBos=null;
		loginBos =loginDao.getLogins();
		
		for(LoginBo bo:loginBos)
		{
			LoginDto lDto =new LoginDto();
			lDto.setEmail(bo.getEmail());
			System.out.println(bo.getEmail()+"hello    "+bo.getPassword());
			lDto.setPassword(bo.getPassword());
			
			loginDtos.add(lDto);
	   }
		return loginDtos;
		
	}

	public void saveSignUp(SignUpDto signUpDto)
	{
		SignUpBo signUpBo =new SignUpBo();
		signUpBo.setName(signUpDto.getName());
		signUpBo.setEmail(signUpDto.getEmail());
		signUpBo.setPsw(signUpDto.getPsw());
		
		signUpDao.save(signUpBo);
	}

}
