package com.yifabao.service;

import java.util.List;

import com.yifabao.bean.Person;

public interface PersonService {
	/**
	 * 保存person
	 * @param person person对象
	 */
	public void save(Person person);
	
	/**
	 * 更新person
	 * @param person 人
	 */
	public void update(Person person);
	
	/**
	 * 获取指定id 的person
	 * @param personId 人的id
	 * @return Person对象
	 */
	public Person getPerson(Integer personId);
	
	/**
	 * 获取所有的Person
	 * @return 人的集合
	 */
	public List<Person> getPersons();
	
	/**
	 * 根据id 删除person
	 * @param id 人的id
	 */
	public void delete(Integer id);
	
}
