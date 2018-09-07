package com.andyadc.seckill.mapper;

import com.andyadc.seckill.entity.SeckillOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeckillOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(SeckillOrder record);

    SeckillOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillOrder record);
}