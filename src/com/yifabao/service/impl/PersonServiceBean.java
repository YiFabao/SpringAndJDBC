package com.yifabao.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yifabao.bean.Person;
import com.yifabao.service.PersonService;

public class PersonServiceBean implements PersonService {
	
	/**
	 * 不要直接对这个类直接操作, 而是要用JdbcTemplate 来jdbc操作
	 */
	private DataSource dataSource;
	
	/**
	 * 关于JdbcTemplate 应用的更多详细讲解,看传智播客的李勇老师讲的JDBC视频教程
	 */
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(Person person) {
		jdbcTemplate.update("insert into person(name) value(?)",
							new Object[]{person.getName()},
							new int[]{java.sql.Types.VARCHAR});
	}

	@Override
	public void update(Person person) {
		jdbcTemplate.update("update person set name= ? where id = ?",
				new Object[]{person.getName(),person.getId()},
				new int[]{java.sql.Types.VARCHAR,java.sql.Types.INTEGER});
	}

	@Override
	public Person getPerson(Integer personId) {
		Object obj = jdbcTemplate.queryForObject("select * from person where id = ?", 
				new Object[]{personId},
				new int[]{java.sql.Types.INTEGER},
				new PersonRowMapper());
		return (Person)obj;
	}

	@Override
	public List<Person> getPersons() {
		List<Object> listObject = jdbcTemplate.query("select * from person",new PersonRowMapper());
		List<Person> personList = new ArrayList<Person>();
		for(Object obj:listObject){
			personList.add((Person)obj);
		}
		return personList;
	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("delete person where id = ?",
				new Object[]{id},
				new int[]{java.sql.Types.INTEGER});
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
