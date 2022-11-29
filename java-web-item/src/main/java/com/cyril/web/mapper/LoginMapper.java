package com.cyril.web.mapper;

import com.cyril.web.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface LoginMapper {

    User login(@Param("username") String username,@Param("password") String password);
}
