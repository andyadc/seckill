package com.andyadc.seckill.goods.test.mapper;

import com.andyadc.seckill.goods.infrastructure.persistence.entity.SeckillGoods;
import com.andyadc.seckill.goods.infrastructure.persistence.mapper.SeckillGoodsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SeckillGoodsMapperTests {

    @Autowired
    private SeckillGoodsMapper goodsMapper;

    @Test
    public void test_selectByPrimaryKey() {
        SeckillGoods goods = goodsMapper.selectByPrimaryKey(1L);
        System.out.println(goods.getGoodsName());
    }
}
