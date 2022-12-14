package com.amm.gulimall.order.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amm.gulimall.order.entity.OrderEntity;
import com.amm.gulimall.order.service.OrderService;
import com.amm.common.utils.PageUtils;
import com.amm.common.utils.R;



/**
 * 订单
 *
 * @author amm
 * @email 123@gmail.com
 * @date 2022-12-11 21:10:26
 */
@RestController
@RequestMapping("order/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/member/list")
    public R memberOrders(){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setMemberUsername("李斯");
        orderEntity.setCouponAmount(new BigDecimal(100));
        orderEntity.setCouponId(1L);
        orderEntity.setOrderSn("订单号:25440");
        return R.ok().put("order",orderEntity);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:order:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:order:info")
    public R info(@PathVariable("id") Long id){
		OrderEntity order = orderService.getById(id);

        return R.ok().put("order", order);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:order:save")
    public R save(@RequestBody OrderEntity order){
		orderService.save(order);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:order:update")
    public R update(@RequestBody OrderEntity order){
		orderService.updateById(order);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:order:delete")
    public R delete(@RequestBody Long[] ids){
		orderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
