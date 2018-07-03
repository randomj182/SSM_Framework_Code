package com.random.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;

import com.random.dao.StudentDao;
import com.random.vo.Student;

@Controller
public class HelloController {
	private StudentDao studentDao;
	@RequestMapping("/insert")
	@ResponseBody
	public String insertStudent(@Param("id") Integer id,@Param("name")String name) throws Exception{
		studentDao=(StudentDao)ContextLoader.getCurrentWebApplicationContext().getBean("studentDao");
		Student student = new Student(id, name);
		studentDao.insertStudent(student);
		return "插入成功";
	}

}
