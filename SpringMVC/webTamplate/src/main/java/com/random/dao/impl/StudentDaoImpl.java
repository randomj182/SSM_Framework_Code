package com.random.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.random.dao.StudentDao;
import com.random.vo.Student;
/**
 * StudentDao的实现类
 * @author random
 *
 */
public class StudentDaoImpl extends SqlSessionDaoSupport implements StudentDao {
	/**
	 * 向Student表中插入一条学生记录
	 */
	@Override
	public void insertStudent(Student student) throws Exception {
		this.getSqlSession().insert("test.insertStudent", student);
	}

}
