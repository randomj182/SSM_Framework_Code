package com.random.mybatis.first;

import com.random.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
/* *
 * @author	Radish
 * @Description 测试类
 * @date	18:03 2018/6/18
 **/
public class MybatisFirst {
    //会话工厂
    private SqlSessionFactory sqlSessionFactory;
    //创建工厂
    @Before
    public void init() throws IOException {

        //配置文件(SqlMapConfig.xml)
        String resource = "SqlMapConfig.xml";

        //加载配置文件到输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    // 测试根据id查询用户(得到单条记录)
    public void testFindUserById(){
        // 通过sqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 通过sqlSession操作数据库
        // 第一个参数:statement的位置,等于namespace+statement的id
        // 第二个参数:传入的参数
        User user = null;
        try {
            user = sqlSession.selectOne("test.findUserById",2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭sqlSession
            sqlSession.close();
        }

        System.out.println(user);
    }

    @Test
    // 测试根据用户名称查询用户(得到单条记录)
    public void testFindUserByName(){
        // 通过sqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 通过sqlSession操作数据库
        // 第一个参数:statement的位置,等于namespace+statement的id
        // 第二个参数:传入的参数
        List<User> userList = null;
        try {
            userList = sqlSession.selectList("test.findUserByName","%小明%");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭sqlSession
            sqlSession.close();
        }
        System.out.println(userList.get(0).getUsername());
    }

    @Test
    // 插入一条数据
    public void testInsertUser(){
        // 通过sqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 通过sqlSession操作数据库

        // 创建插入数据对象
        User user = new User();
        user.setUsername("random");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("浙江宁波");

        // 第一个参数:statement的位置,等于namespace+statement的id
        // 第二个参数:传入的参数
        try {
            sqlSession.insert("test.insertUser",user);
            // 需要提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭sqlSession
            sqlSession.close();
        }
        // 此时获得的id= 0;
        //User{id=0, username='random', sex='1', birthday=Sun Jun 17 15:28:33 CST 2018, address='浙江宁波'}
        System.out.println(user);
        //需求：user对象插入到数据库后，新记录的主键要通过user对象返回，通过user获取主键值。
        /*解决思路：在User.xml中
            通过LAST_INSERT_ID()获取刚插入记录的自增主键值，在insert语句执行后，
            执行select LAST_INSERT_ID()就可以获取自增主键
            <selectKey keyProperty="id" order="AFTER" resultType="int">
                SELECT LAST_INSERT_ID()
            </selectKey>
        */
    }

    @Test
    // 测试根据id更新用户(得到单条记录)
    public void testUpdateUser(){
        // 通过sqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 通过sqlSession操作数据库
        // 创建插入数据对象
        User user = new User();
        user.setId(28);
        user.setUsername("random");
       // user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("浙江宁波");

        // 第一个参数:statement的位置,等于namespace+statement的id
        // 第二个参数:传入的参数

        try {
            sqlSession.update("test.updateUser",user);
            // 需要提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭sqlSession
            sqlSession.close();
        }

        System.out.println("用户的id=" + user.getId());
    }

    @Test
    // 测试根据id删除用户(得到单条记录)
    public void testDeleteUser(){
        // 通过sqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 通过sqlSession操作数据库
        // 第一个参数:statement的位置,等于namespace+statement的id
        // 第二个参数:传入的参数
        try {
            sqlSession.delete("test.deleteUser",28);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭sqlSession
            sqlSession.close();
        }

    }
}
