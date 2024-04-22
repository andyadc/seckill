package com.andyadc.seckill.activity.infrastructure.persistence.mapper;

import com.andyadc.seckill.activity.infrastructure.persistence.entity.SeckillActivity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeckillActivityMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SeckillActivity row);

    int insertSelective(SeckillActivity row);

    SeckillActivity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillActivity row);

    int updateByPrimaryKey(SeckillActivity row);
}