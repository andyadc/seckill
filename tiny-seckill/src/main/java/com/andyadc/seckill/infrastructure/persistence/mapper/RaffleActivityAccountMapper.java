package com.andyadc.seckill.infrastructure.persistence.mapper;

import com.andyadc.seckill.infrastructure.persistence.entity.RaffleActivityAccount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RaffleActivityAccountMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RaffleActivityAccount row);

    int insertSelective(RaffleActivityAccount row);

    RaffleActivityAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RaffleActivityAccount row);

    int updateByPrimaryKey(RaffleActivityAccount row);
}