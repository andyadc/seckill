package com.andyadc.seckill.infrastructure.mapper;

import com.andyadc.seckill.domain.model.SeckillUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SeckillUserMapper {

    SeckillUser getSeckillUserByUserName(@Param("username") String username);

    int insert(SeckillUser record);

    int insertOrUpdate(SeckillUser record);
}
