package com.qc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.qc.bo.LoginBo;

public class LoginDao {
	
	private JdbcTemplate jdbcTemplate;
	private final String SQL_LOGIN="SELECT email,password FROM USER";
	
	
	public LoginDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<LoginBo> getLogins()
	{
		return jdbcTemplate.query(SQL_LOGIN,new LoginRowMapper());
		
	}
	
	private final class LoginRowMapper implements RowMapper<LoginBo>
	{

		public LoginBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			LoginBo bo =new LoginBo();
		  
			System.out.println(rs.getString("email")+" data "+rs.getString("password"));
			bo.setEmail(rs.getString("email"));
			bo.setPassword(rs.getString("password"));
			return bo;
		}

	}

}
