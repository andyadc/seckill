package com.andyadc.seckill.mapper;

import com.andyadc.seckill.entity.Demo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(Demo record);

    Demo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Demo record);
}