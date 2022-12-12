package com.amm.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.amm.common.utils.PageUtils;
import com.amm.gulimall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author amm
 * @email 123@gmail.com
 * @date 2022-12-11 21:10:26
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

