package com.indi.dao.user;

import com.indi.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    public User getLoginUser(@Param("userCode") String userCode);

    public int add(User user);

    public List<User> getUserList(Map map);

    public int getUserCount(Map map);

    public int deleteUserByID(@Param("id") Integer id);

    public User getUserByID(@Param("id") Integer id);

    public int modify(User user);

    public int updatePwd(@Param("id") Integer id, @Param("userPassword") String pwd);
}
