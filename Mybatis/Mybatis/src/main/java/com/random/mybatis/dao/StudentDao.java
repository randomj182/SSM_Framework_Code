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
	/**
	 * 根据id删除一条学生记录
	 * @param student	: 输入学号id
	 * @throws Exception: 删除失败会抛出异常
	 */
	public void deleteStudentById(int id) throws Exception;
	/**
	 * 更新学生记录信息
	 * @param student :待更新表中的对象
	 * @throws Exception:
	 */
	public void updateStudent(Student student) throws Exception;
	/**
	 * 根据id查询一条记录
	 * @param id	: 输入学号id
	 * @throws Exception: 查询失败会抛出异常
	 */
	public Student findStudentById(int id) throws Exception;
}
