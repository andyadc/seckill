package com.andyadc.seckill.reservation.test.mapper;

import com.andyadc.seckill.reservation.infrastructure.persistence.entity.SeckillReservationGoods;
import com.andyadc.seckill.reservation.infrastructure.persistence.mapper.SeckillReservationGoodsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperTests {

    @Autowired
    private SeckillReservationGoodsMapper reservationGoodsMapper;

    @Test
    public void test_selectByPrimaryKey() {
        SeckillReservationGoods reservationGoods = reservationGoodsMapper.selectByPrimaryKey(1L);
        System.out.println(reservationGoods.getGoodsName());
    }
}
