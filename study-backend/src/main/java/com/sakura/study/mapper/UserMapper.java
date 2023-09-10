package com.sakura.study.mapper;

import com.sakura.study.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user_info where username = #{text} or email = #{text}")
    UserInfo findUsrByNameOrEmail(String text);

}
