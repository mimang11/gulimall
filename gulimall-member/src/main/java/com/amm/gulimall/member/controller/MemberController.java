package com.amm.gulimall.member.controller;

import java.util.Arrays;
import java.util.Map;

import com.amm.gulimall.member.Feign.CouponFeignService;
import com.amm.gulimall.member.Feign.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amm.gulimall.member.entity.MemberEntity;
import com.amm.gulimall.member.service.MemberService;
import com.amm.common.utils.PageUtils;
import com.amm.common.utils.R;



/**
 * 会员
 *
 * @author amm
 * @email 123@gmail.com
 * @date 2022-12-11 20:53:47
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private CouponFeignService couponFeignService;
    @Autowired
    private OrderFeignService orderFeignService;


    @RequestMapping("/coupons")
    public R coupons(){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUsername("我是张张三");
        R coupons = couponFeignService.memberCoupons();
        return R.ok().put("会员名:",memberEntity.getUsername()).put("coupons:",coupons.get("coupons"));

    }
    @RequestMapping("/order/list")
    public R orders(){
        MemberEntity member = new MemberEntity();
        member.setUsername("李斯");
        R orders = orderFeignService.memberOrders();

        return  R.ok().put("会员名字: ",member).put("订单详情: ",orders);

    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:member:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:member:info")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:member:save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:member:update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:member:delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
