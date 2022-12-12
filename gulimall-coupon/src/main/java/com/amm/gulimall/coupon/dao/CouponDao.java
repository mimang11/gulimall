package com.amm.gulimall.coupon.dao;

import com.amm.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author amm
 * @email 123@gmail.com
 * @date 2022-12-11 20:45:14
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
