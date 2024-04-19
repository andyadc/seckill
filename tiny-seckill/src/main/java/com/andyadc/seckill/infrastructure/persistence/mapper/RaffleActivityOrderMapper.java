package com.andyadc.seckill.infrastructure.persistence.mapper;

import com.andyadc.seckill.infrastructure.persistence.entity.RaffleActivityOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RaffleActivityOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RaffleActivityOrder row);

    int insertSelective(RaffleActivityOrder row);

    RaffleActivityOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RaffleActivityOrder row);

    int updateByPrimaryKey(RaffleActivityOrder row);
}