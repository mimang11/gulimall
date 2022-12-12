package com.amm.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.amm.common.utils.PageUtils;
import com.amm.gulimall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author amm
 * @email 123@gmail.com
 * @date 2022-12-11 20:53:47
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

