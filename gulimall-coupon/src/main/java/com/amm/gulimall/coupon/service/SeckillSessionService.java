package com.amm.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.amm.common.utils.PageUtils;
import com.amm.gulimall.coupon.entity.SeckillSessionEntity;

import java.util.Map;

/**
 * 秒杀活动场次
 *
 * @author amm
 * @email 123@gmail.com
 * @date 2022-12-11 20:45:14
 */
public interface SeckillSessionService extends IService<SeckillSessionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

