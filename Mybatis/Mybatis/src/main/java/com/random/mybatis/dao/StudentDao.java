package com.random.mybatis.dao;

import com.random.mybatis.po.Student;

/**
 * student表的操作类
 * @author admin
 *
 */
public interface StudentDao {
	/**
	 * 向表中插入一条数据
	 * @param student 待插入表中的对象
	 * @throws Exception 插入失败会抛出异常
	 */
	public void insertStudent(Student student)throws Exception;
}
