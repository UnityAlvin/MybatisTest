package com.indi.dao.bill;

import com.indi.pojo.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BillMapper {
    public int getBillCountByProviderID(@Param("providerID") Integer providerID);

    public int add(Bill bill);

    public List<Bill> getBillList(Map map);

    public int getBillCount(Map map);

    public int deleteBillByID(@Param("id") Integer delID);

    public Bill getBillByID(@Param("id") Integer id);

    public int modify(Bill bill);

    public int deleteByBillByProviderID(@Param("providerID") Integer providerID);
}
