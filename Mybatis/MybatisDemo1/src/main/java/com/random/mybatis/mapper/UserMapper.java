package com.random.mybatis.mapper;

import com.random.mybatis.po.User;
import com.random.mybatis.po.UserQueryVo;

import java.util.List;

public interface UserMapper {

    /**
     * 不管查询记录是单条还是多条,在statement中resultType定义一致,都是单记录映射的pojo类型.
     * mapper接口方法返回值,如果返回的单个对象,返回值类型是pojo类型,生成的代理对象内部通过
     * selectOne获取记录,如果返回值类型是集合对象,生成的代理对象内部通过selectList获取对象
     * @param id
     * @return
     * @throws Exception
     */
    // 根据id查询用户信息
    public User findUserById(int id) throws  Exception;
    // 根据用户名称查询用户列表
    public List<User> findUserByName(String username) throws  Exception;
    //自定义查询条件查询用户信息
    public List<User> findUserList(UserQueryVo userQueryVo) throws Exception;
    // 查询用户,返回记录个数
    public int findUserCount(UserQueryVo userQueryVo) throws Exception;
    //查询用户，使用resultMap进行映射
    public List<User> findUserListResultMap(UserQueryVo userQueryVo)throws Exception;
    // 插入用户
    public void insertUser(User user) throws  Exception;
    // 删除用户
    public void deleteUser(int id) throws  Exception;
    // 修改用户
    public void updateUser(User user) throws  Exception;
}
