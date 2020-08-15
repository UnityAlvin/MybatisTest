package com.indi.dao.role;

import com.indi.dao.provider.ProviderMapper;
import com.indi.pojo.Role;
import com.indi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class RoleMapperTest {

    private SqlSession sqlSession;
    private RoleMapper mapper;

    @Before
    public void init() {
        sqlSession = MybatisUtils.getSqlSession();
        mapper = sqlSession.getMapper(RoleMapper.class);
    }

    @After
    public void destroy() {
        sqlSession.close();
    }

    @Test
    public void getRoleList() {
        mapper.getRoleList().forEach(System.out::println);
    }

    @Test
    public void add() {
        mapper.add(new Role(null, "SMBMS_EMPLOYEE", "普通员工", 1, new Date(), null, null));
    }

    @Test
    public void deleteRoleByID() {
        mapper.deleteRoleByID(4);
    }

    @Test
    public void modify() {
        mapper.modify(new Role(4, "SMBMS_EMPLOYEE", "普通员工007", 1, new Date(), null, null));
    }

    @Test
    public void getRoleByID() {
        System.out.println(mapper.getRoleByID(4));
    }

    @Test
    public void roleCodeIsExist() {
        System.out.println(mapper.roleCodeIsExist("SMBMS_EMPLOYEE"));
    }
}