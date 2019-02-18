package com.qc.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.JdbcTemplate;

import com.qc.bo.SignUpBo;


public class SignUpDao{

	
	
	 private JdbcTemplate jdbcTemplate;  
	    final String INSERT_QUERY = "insert into user(name, email,password,createdDate) values (?,?,?,?)";
	    
	 
	  
	    
	 

		public SignUpDao(JdbcTemplate jdbcTemplate) {
			
			this.jdbcTemplate = jdbcTemplate;
		}






		public int save(SignUpBo signUpBo) {
			Date date =new Date(new java.util.Date().getTime());
			LocalDateTime now = LocalDateTime.now();
			Timestamp sqlNow = Timestamp.valueOf(now);
	        return jdbcTemplate.update(INSERT_QUERY, signUpBo.getName(),signUpBo.getEmail(),signUpBo.getPsw(),sqlNow); 
		}

}
