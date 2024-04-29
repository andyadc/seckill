package com.andyadc.seckill.user.test.mapper;

import com.andyadc.seckill.user.infrastructure.persistence.entity.SeckillUser;
import com.andyadc.seckill.user.infrastructure.persistence.mapper.SeckillUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SeckillUserMapperTests {

    @Autowired
    private SeckillUserMapper userMapper;

    @Test
    public void test_selectByPrimaryKey() {
        SeckillUser user = userMapper.selectByPrimaryKey(1L);
        System.out.println(user.getUsername());
    }
}
