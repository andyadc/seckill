package com.andyadc.seckill.infrastructure.persistence.mapper;

import com.andyadc.seckill.infrastructure.persistence.entity.RaffleActivity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RaffleActivityMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RaffleActivity row);

    int insertSelective(RaffleActivity row);

    RaffleActivity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RaffleActivity row);

    int updateByPrimaryKey(RaffleActivity row);
}