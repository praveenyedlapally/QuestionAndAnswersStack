package com.qc.dto;

import java.sql.Timestamp;

public class AnswerDto {
	
	
	private int answerId;
	private String answerText;
	private String email;
	private String question;
	private int questionId;
	private Timestamp createdDate;
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "AnswerBo [answerId=" + answerId + ", answerText=" + answerText + ", email=" + email + ", question="
				+ question + ", questionId=" + questionId + ", createdDate=" + createdDate + "]";
	}

	

}
