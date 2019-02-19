package com.qc.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.qc.bo.AnswerBo;

public class AnswerDao {
	
	private JdbcTemplate jdbcTemplate;  
    final String INSERT_QUERY = "insert into answer(answerText, email,question,questionId,createdDate) values (?,?,?,?,?)";
    private final String SQL_ANSWER="SELECT \r\n" + 
    		"*\r\n" + 
    		"FROM quickcode.question as que \r\n" + 
    		"left outer join quickcode.answer as ans on que.questionId=ans.questionId\r\n" + 
    		"and ans.answerid=(select max(an.answerid) from quickcode.answer as an \r\n" + 
    		"where an.questionid=que.questionId)\r\n" + 
    		"order by que.questionid   ";
    public AnswerDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    
    public List<AnswerBo> getAnswers()
	{
		return jdbcTemplate.query(SQL_ANSWER,new LoginRowMapper());
		
	}
	
	private final class LoginRowMapper implements RowMapper<AnswerBo>
	{

		public AnswerBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			AnswerBo answerBo =new AnswerBo();
		  
			System.out.println(rs.getString("email")+" data "+rs.getString("answerText"));
			answerBo.setAnswerText(rs.getString("answerText"));
			answerBo.setEmail(rs.getString("email"));
			answerBo.setQuestion(rs.getString("question"));
			answerBo.setQuestionId(rs.getInt("questionId"));
			answerBo.setCreatedDate(rs.getTimestamp("createdDate"));
			return answerBo;
		}

	}
	public int save(AnswerBo answerBo) {
		Date date =new Date(new java.util.Date().getTime());
		LocalDateTime now = LocalDateTime.now();
		Timestamp sqlNow = Timestamp.valueOf(now);
        return jdbcTemplate.update(INSERT_QUERY, answerBo.getAnswerText(),answerBo.getEmail(),answerBo.getQuestion(),answerBo.getQuestionId(),sqlNow); 
	}


 

}
