package com.indi.dao.user;

import com.indi.dao.provider.ProviderMapper;
import com.indi.pojo.User;
import com.indi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserMapperTest {


    private SqlSession sqlSession;
    private UserMapper mapper;

    @Before
    public void init() {
        sqlSession = MybatisUtils.getSqlSession();
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void destroy() {
        sqlSession.close();
    }

    @Test
    public void getLoginUser() {
        System.out.println(mapper.getLoginUser("liming"));
    }

    @Test
    public void add() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("1990-01-05");
        mapper.add(new User(null, "zhangjing", "张婧", "0000000", date, 1, "18099897657", "北京市昌平区天通苑3区12号楼", 2, 1, new Date(), null, null, null, null, null, null));
    }

    @Test
    public void getUserList() {
        Map map = new HashMap<>();
        map.put("userName", "系统管理员");
        map.put("userRole", null);
        System.out.println(mapper.getUserList(map));
    }

    @Test
    public void getUserCount() {
        Map map = new HashMap<>();
        map.put("userName", null);
        map.put("userRole", null);
        System.out.println(mapper.getUserCount(map));
    }

    @Test
    public void deleteUserByID() {
        mapper.deleteUserByID(17);
    }

    @Test
    public void getUserByID() {
        System.out.println(mapper.getUserByID(16));
    }

    @Test
    public void modify() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("1990-01-09");
        mapper.modify(new User(16, "zhangjing", "张婧", "0000000", date, 1, "18099897657", "北京市昌平区天通苑3区12号楼", 2, 1, new Date(), null, null, null, null, null, null));

    }

    @Test
    public void updatePwd() {
        mapper.updatePwd(16,"1234567");
    }
}