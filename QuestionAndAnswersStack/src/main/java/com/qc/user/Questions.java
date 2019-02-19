package com.qc.user;

public class Questions {
	
	private String question;

	public Questions() {
		
	}

	public Questions(String question) {
	
		this.question = question;
	}

	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	

	@Override
	public String toString() {
		return "Questions [question=" + question + "]";
	}
	
	

}
