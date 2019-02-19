package com.qc.service;

import java.util.ArrayList;
import java.util.List;

import com.qc.bo.AnswerBo;
import com.qc.bo.LoginBo;
import com.qc.bo.QuestionBo;
import com.qc.bo.SignUpBo;
import com.qc.dao.AnswerDao;
import com.qc.dao.LoginDao;
import com.qc.dao.QuestionDao;
import com.qc.dao.SignUpDao;
import com.qc.dto.AnswerDto;
import com.qc.dto.LoginDto;
import com.qc.dto.QuestionDto;
import com.qc.dto.SignUpDto;

public class ManageQuickCodeService {
	
	private SignUpDao signUpDao;
	
	private LoginDao loginDao;
    
	private QuestionDao questionDao;
	
	private AnswerDao answerDao;
	
	public ManageQuickCodeService(SignUpDao signUpDao, LoginDao loginDao, QuestionDao questionDao,
			AnswerDao answerDao) {
		this.signUpDao = signUpDao;
		this.loginDao = loginDao;
		this.questionDao = questionDao;
		this.answerDao = answerDao;
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
	public void saveQuestion(QuestionDto questionDto)
	{
		System.out.println("msd");
		QuestionBo questionBo =new QuestionBo();
		questionBo.setQuestionId(questionDto.getQuestionId());
		questionBo.setEmail(questionDto.getEmail());
		questionBo.setQuestion(questionDto.getQuestion());
		
		questionDao.save(questionBo);
	}
	public void saveAnswer(AnswerDto answerDto)
	{
		
		AnswerBo answerBo =new AnswerBo();
		answerBo.setAnswerText(answerDto.getAnswerText());
		answerBo.setEmail(answerDto.getEmail());
		answerBo.setQuestion(answerDto.getQuestion());
		answerBo.setQuestionId(answerDto.getQuestionId());
		answerBo.setCreatedDate(answerDto.getCreatedDate());
		
		answerDao.save(answerBo);
	}
	public List<AnswerDto> getAnswers()
	{
		List<AnswerDto> answerDtos= new ArrayList<AnswerDto>();
		List<AnswerBo> answerBos=null;
		answerBos	 =answerDao.getAnswers();
		
		for(AnswerBo bo:answerBos)
		{
			AnswerDto aDto =new AnswerDto();
			aDto.setAnswerText(bo.getAnswerText());
			aDto.setEmail(bo.getEmail());
			aDto.setQuestion(bo.getQuestion());
			aDto.setQuestionId(bo.getQuestionId());
			aDto.setCreatedDate(bo.getCreatedDate());
			
		
			
			answerDtos.add(aDto);
	   }
		return answerDtos;
		
	}
	public List<QuestionDto> getQuestions()
	{
		List<QuestionDto> questionDtos= new ArrayList<QuestionDto>();
		List<QuestionBo> questionBos=null;
		questionBos	 =questionDao.getQuestions();
		
		for(QuestionBo bo:questionBos)
		{
			QuestionDto qDto =new QuestionDto();
			qDto.setQuestionId(bo.getQuestionId());
			qDto.setEmail(bo.getEmail());
			qDto.setQuestion(bo.getQuestion());
			
			
		
			
			questionDtos.add(qDto);
	   }
		return questionDtos;
		
	}
}
