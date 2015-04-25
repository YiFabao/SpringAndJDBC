package com.yifabao.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yifabao.bean.Person;

public class PersonRowMapper implements RowMapper<Object> {

	@Override
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		//对 rs 为什么不next一下,当外部调用这个方法时，已经做了if(rs.next())操作
		Person person = new Person(rs.getInt("id"),rs.getString("name"));
		return person;
	}

}
