package com.indi.dao.provider;

import com.indi.pojo.Provider;
import com.indi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ProviderMapperTest {

    private SqlSession sqlSession;
    private ProviderMapper mapper;

    @Before
    public void init() {
        sqlSession = MybatisUtils.getSqlSession();
        mapper = sqlSession.getMapper(ProviderMapper.class);
    }

    @After
    public void destroy() {
        sqlSession.close();
    }

    @Test
    public void add() {
        mapper.add(new Provider(16, "ZJ_GYS002", "乐摆日用品厂", "	长期合作伙伴，主营产品：各种中、高档塑料杯塑料乐扣水杯（密封杯）、保鲜杯（保鲜盒）、广告杯、礼品杯",
                "王世杰", "13212331567","浙江省金华市义乌市义东路", "0579 - 34452321", 1, new Date(), null, null, null, null));
    }

    @Test
    public void getProviderList() {
        Map map = new HashMap<>();
        map.put("proName","乐摆日用品厂");
        map.put("proCode","ZJ_GYS002");
        mapper.getProviderList(map).forEach(System.out::println);
    }

    @Test
    public void getProList() {
        mapper.getProList().forEach(System.out::println);
    }

    @Test
    public void getProviderCount() {
        System.out.println(mapper.getProviderCount("乐摆日用品厂", "ZJ_GYS002"));
    }

    @Test
    public void deleteProviderByID() {
        mapper.deleteProviderByID(16);
    }

    @Test
    public void getProviderByID() {
        System.out.println(mapper.getProviderByID(15));
    }

    @Test
    public void modify() {
        mapper.modify(new Provider(16, "ZJ_GYS003", "乐摆日用品厂", "	长期合作伙伴，主营产品：各种中、高档塑料杯塑料乐扣水杯（密封杯）、保鲜杯（保鲜盒）、广告杯、礼品杯",
                "王世杰", "13212331567","浙江省金华市义乌市义东路", "0579 - 34452321", 1, new Date(), null, null, null, null));
    }
}