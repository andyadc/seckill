package com.andyadc.seckill.starter.test;

import com.andyadc.seckill.application.service.SeckillUserService;
import com.andyadc.seckill.domain.dto.SeckillUserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.NONE
)
public class SeckillUserServiceTests {

    @Autowired
    private SeckillUserService seckillUserService;

    @Test
    public void testInsert() {
        SeckillUserDTO dto = new SeckillUserDTO();
        dto.setUsername("admin");
        dto.setPassword("123456");
        seckillUserService.signup(dto);
    }
}
