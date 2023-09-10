package com.sakura.study.service;

import com.sakura.study.entity.UserInfo;
import com.sakura.study.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.isEmpty()) {
            throw new UsernameNotFoundException("用户名不能为空");
        }

        UserInfo userInfo = userMapper.findUsrByNameOrEmail(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }

        return User
                .withUsername(userInfo.getUsername())
                .password(userInfo.getPassword())
                .roles("user")
                .build();
    }
}
