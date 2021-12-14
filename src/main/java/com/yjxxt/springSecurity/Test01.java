package com.yjxxt.springSecurity;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class Test01 {

    @Test
    public void test(){
        //创建解析器
        PasswordEncoder pw = new BCryptPasswordEncoder();
        //对密码加密
        String encode = pw.encode("123456");
        System.out.println(encode);
        //判断原字符与加密后的内容是否匹配
        boolean matches = pw.matches("123456",encode);
        System.out.println(matches);
    }
}
