package com.qc.bo;

public class QuestionBo {
    private int questionId;
	private String email;
	private String question;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
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
	@Override
	public String toString() {
		return "QuestionBo [questionId=" + questionId + ", email=" + email + ", question=" + question + "]";
	}
	
}
