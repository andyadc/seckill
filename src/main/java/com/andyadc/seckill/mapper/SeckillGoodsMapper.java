package com.andyadc.seckill.mapper;

import com.andyadc.seckill.entity.SeckillGoods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeckillGoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(SeckillGoods record);

    SeckillGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillGoods record);
}