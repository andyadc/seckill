package com.andyadc.seckill.user.infrastructure.persistence.mapper;

import com.andyadc.seckill.user.infrastructure.persistence.entity.SeckillUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeckillUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SeckillUser row);

    int insertSelective(SeckillUser row);

    SeckillUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillUser row);

    int updateByPrimaryKey(SeckillUser row);
}
