package com.andyadc.seckill.test;

import com.andyadc.seckill.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author andy.an
 * @since 2018/8/28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoServiceTest {

    @Autowired
    private DemoService demoService;

    @Test
    public void testInsert() {
        demoService.save();
    }
}
