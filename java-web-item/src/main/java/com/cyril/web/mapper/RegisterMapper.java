package com.cyril.web.mapper;

import com.cyril.web.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface RegisterMapper {

    int register(@Param("username") String username, @Param("password") String password);
}
