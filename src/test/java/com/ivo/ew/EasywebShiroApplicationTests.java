package com.ivo.ew;

import com.ivo.ew.system.dao.UserMapper;
import com.ivo.ew.system.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasywebShiroApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {

        User user = userMapper.getByUsername("admin");
        System.out.println(user.getUsername());

    }
}
