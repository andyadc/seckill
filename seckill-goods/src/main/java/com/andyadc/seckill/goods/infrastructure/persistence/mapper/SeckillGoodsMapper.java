package com.andyadc.seckill.goods.infrastructure.persistence.mapper;

import com.andyadc.seckill.goods.infrastructure.persistence.entity.SeckillGoods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeckillGoodsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SeckillGoods row);

    int insertSelective(SeckillGoods row);

    SeckillGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillGoods row);

    int updateByPrimaryKey(SeckillGoods row);
}
