package com.indi.dao.provider;

import com.indi.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProviderMapper {
    public int add(Provider provider);

    public List<Provider> getProviderList(Map map);

    public List<Provider> getProList();

    public int getProviderCount(@Param("proName") String proName,@Param("proCode") String proCode);

    public int deleteProviderByID(@Param("id") Integer delID);

    public Provider getProviderByID(@Param("id") Integer id);

    public int modify(Provider provider);
}
