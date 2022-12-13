package com.amm.gulimall.member.Feign;

import com.amm.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author he
 * @Date 2022/12/13 9:50
 * @Version 1.0
 */
@FeignClient("gulimall-order")
public interface OrderFeignService {
    @RequestMapping("order/order/member/list")
     R memberOrders();
}
