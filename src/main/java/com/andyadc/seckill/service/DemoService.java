package com.andyadc.seckill.service;

import com.andyadc.seckill.entity.Demo;
import com.andyadc.seckill.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author andy.an
 * @since 2018/8/28
 */
@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Transactional(rollbackFor = Exception.class)
    public void save() {
        Demo demo = new Demo();
        demo.setName("demo");
        demo.setAge(12);
        demo.setBirthday(new Date());
        demo.setUpdatedTime(new Date());
        demoMapper.insertSelective(demo);
        demoMapper.insertSelective(demo);
    }
}
