package com.mapper;

import com.po.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询所有用户
    @Select("select * from tb_user")
    List<User> getAllUsers();

    //删除用户
    @Delete("DELETE FROM tb_user WHERE id = #{id}")
    void delete(Integer id);

}
