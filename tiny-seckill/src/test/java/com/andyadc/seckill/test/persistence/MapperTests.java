package com.andyadc.seckill.test.persistence;

import com.andyadc.seckill.infrastructure.persistence.entity.Award;
import com.andyadc.seckill.infrastructure.persistence.mapper.AwardMapper;
import com.andyadc.seckill.test.AbstractTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperTests extends AbstractTest {

    @Autowired
    private AwardMapper awardMapper;

    @Test
    public void awardMapper_selectByAwardId() {
        Award award = awardMapper.selectByAwardId(1);
        System.out.println(award);
    }
}
