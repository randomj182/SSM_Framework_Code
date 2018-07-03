package com.random.dao;

import com.random.vo.Student;
/**
 * student操作类
 * @author random
 *
 */
public interface StudentDao {
	/**
	 * 向Student表中插入一条学生记录
	 * @param student 学生对象
	 * @throws Exception
	 */
	public void insertStudent(Student student) throws Exception;
	
}
