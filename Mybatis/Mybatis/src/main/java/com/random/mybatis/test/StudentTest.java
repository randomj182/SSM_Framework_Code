package com.random.mybatis.test;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.random.mybatis.dao.StudentDao;
import com.random.mybatis.po.Student;

/**
 * student测试类
 * @author admin
 *
 */
public class StudentTest {
	// 会话工厂
	private SqlSessionFactory sqlSessionFactory;
	@Before
	/**
	 * 根据classpath下的bigConfig.xml初始化会话工厂
	 * @throws IOException 加载bigConfig.xml文件异常时抛出
	 */
	public void init() throws IOException{
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("bigConfig.xml"));
	}
	@Test
	/**
	 * 测试mapper代理的方式,插入一个学生
	 * @throws Exception
	 */
	public void testInsertStudent() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		Student student = new Student();
		student.setName("dddd");
		studentDao.insertStudent(student);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(student.getId());
	}
	
	@Test
	/**
	 * 测试mapper代理的方式,删除一个学生
	 * @throws Exception
	 */
	public void testDeleteStudentById() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		studentDao.deleteStudentById(4);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	/**
	 * 测试mapper代理的方式,更新一条学生数据信息
	 * @throws Exception
	 */
	public void testUpdateStudent() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		Student student = new Student();
		student.setId(1);
		student.setName("dddd");
		studentDao.updateStudent(student);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	/**
	 * 测试mapper代理的方式,更新一条学生数据信息
	 * @throws Exception
	 */
	public void testFindStudentById() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		Student student = studentDao.findStudentById(1);
		System.out.println(student);
	}
}
