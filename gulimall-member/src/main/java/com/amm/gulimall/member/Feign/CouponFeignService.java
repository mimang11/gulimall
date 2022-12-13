package com.amm.gulimall.member.Feign;

import com.amm.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author he
 * @Date 2022/12/12 21:37
 * @Version 1.0
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    /**
     *
     * @return 查询当前会员的所有优惠劵
     * @author 陈十一
     * @description 查询当前会员的所有优惠劵
     * @date 2022/12/12 21:38
     */
    @RequestMapping("coupon/coupon/member/list")
     R memberCoupons();
}
