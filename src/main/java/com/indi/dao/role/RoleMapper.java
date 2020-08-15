package com.indi.dao.role;

import com.indi.pojo.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMapper {


    @Select("select * from smbms_role")
    public List<Role> getRoleList();

    @Insert("insert into smbms_role(roleCode, roleName, createdBy, creationDate, modifyBy, modifyDate) " +
            "values(#{roleCode}, #{roleName}, #{createdBy}, #{creationDate}, #{modifyBy}, #{modifyDate})")
    public int add(Role role);

    @Delete("delete from smbms_role where id = #{id}")
    public int deleteRoleByID(@Param("id") Integer id);

    @Update("update smbms_role set roleCode=#{roleCode}, roleName=#{roleName}, createdBy=#{createdBy}, " +
            "creationDate=#{creationDate}, modifyBy=#{modifyBy}," +
            " modifyDate=#{modifyDate} where id=#{id}")
    public int modify(Role role);

    @Select("select * from smbms_role where id = #{id}")
    public Role getRoleByID(@Param("id") Integer id);

    @Select("select count(*) from smbms_role where roleCode = #{roleCode}")
    public int roleCodeIsExist(@Param("roleCode") String roleCode);
 }
