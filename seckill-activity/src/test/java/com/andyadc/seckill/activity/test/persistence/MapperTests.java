package com.andyadc.seckill.activity.test.persistence;

import com.andyadc.seckill.activity.infrastructure.persistence.entity.SeckillActivity;
import com.andyadc.seckill.activity.infrastructure.persistence.mapper.SeckillActivityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperTests {

    @Autowired
    private SeckillActivityMapper activityMapper;

    @Test
    public void test_selectByPrimaryKey() {
        SeckillActivity activity = activityMapper.selectByPrimaryKey(1L);
        System.out.println(activity.getActivityName());
    }
}
