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
import com.qc.bo.QuestionBo;


public class QuestionDao {
	
	 private JdbcTemplate jdbcTemplate;  
	    final String INSERT_QUERY = "insert into question(email,question,createdDate) values (?,?,?)";
	    
	    private final String SQL_QUESTION="SELECT email,questionId,question,createdDate FROM question";

		public QuestionDao(JdbcTemplate jdbcTemplate) {
	
			this.jdbcTemplate = jdbcTemplate;
		}
		  public List<QuestionBo> getQuestions()
			{
				return jdbcTemplate.query(SQL_QUESTION,new LoginRowMapper());
				
			}
	    
		public int save(QuestionBo questionBo) {
			Date date =new Date(new java.util.Date().getTime());
			LocalDateTime now = LocalDateTime.now();
			Timestamp sqlNow = Timestamp.valueOf(now);
	        return jdbcTemplate.update(INSERT_QUERY, questionBo.getEmail(),questionBo.getQuestion(),sqlNow); 
		}
		private final class LoginRowMapper implements RowMapper<QuestionBo>
		{

			public QuestionBo mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				QuestionBo questionBo =new QuestionBo();
			    
				questionBo.setQuestionId(rs.getInt("questionId"));
				questionBo.setEmail(rs.getString("email"));
				questionBo.setQuestion(rs.getString("question"));
		
				return questionBo;
			}

		}


}
