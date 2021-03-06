package com.yjxxt.springSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder pw;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //1.查询数据库判断用户名是否存在，如果不存在抛出异常
        if(userName==null || !"admin".equals(userName)){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //2.把查询出来的密码（注册时已经经过加密）进行解析，或直接把密码放入构造方法中
        String password = pw.encode("123");
        return new User(userName,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));

    }
}
