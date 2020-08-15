package com.indi.dao.bill;

import com.indi.pojo.Bill;
import com.indi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BillMapperTest {

    private SqlSession sqlSession;
    private BillMapper mapper;

    @Before
    public void init() {
        sqlSession = MybatisUtils.getSqlSession();
        mapper = sqlSession.getMapper(BillMapper.class);
    }

    @After
    public void destroy() {
        sqlSession.close();
    }


    @Test
    public void getBillCountByProviderID() {
        System.out.println(mapper.getBillCountByProviderID(13));
    }

    @Test
    public void add() {
        mapper.add(new Bill(null, "BILL2020_20", "种子", "未见过", "个", BigDecimal.valueOf(1000), BigDecimal.valueOf(2000), 2, 1, 1, new Date(), null, null, null));
    }

    @Test
    public void getBillList() {
        Map map = new HashMap<>();
        map.put("productName","洗发水、护发素");
        mapper.getBillList(map).forEach(System.out::println);
    }

    @Test
    public void getBillCount() {
        Map map = new HashMap<>();
        System.out.println(mapper.getBillCount(map));
    }

    @Test
    public void deleteBillByID() {
        mapper.deleteBillByID(21);
    }

    @Test
    public void getBillByID() {
        System.out.println(mapper.getBillByID(20));
    }

    @Test
    public void modify() {
        mapper.modify(new Bill(20, "BILL2020_20", "种子", "未见过", "个", BigDecimal.valueOf(1000), BigDecimal.valueOf(2000), 2, 1, 1, new Date(), null, null, null));
    }

    @Test
    public void deleteByBillByProviderID() {
        mapper.deleteByBillByProviderID(6);
    }
}