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
		student.setName("aaaa");
		studentDao.insertStudent(student);
		sqlSession.commit();
		sqlSession.close();
	}
}
