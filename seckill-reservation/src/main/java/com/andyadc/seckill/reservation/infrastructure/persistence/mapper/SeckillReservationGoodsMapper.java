package com.andyadc.seckill.reservation.infrastructure.persistence.mapper;

import com.andyadc.seckill.reservation.infrastructure.persistence.entity.SeckillReservationGoods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeckillReservationGoodsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SeckillReservationGoods row);

    int insertSelective(SeckillReservationGoods row);

    SeckillReservationGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillReservationGoods row);

    int updateByPrimaryKey(SeckillReservationGoods row);
}