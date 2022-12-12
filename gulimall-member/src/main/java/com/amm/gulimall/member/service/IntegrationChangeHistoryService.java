package com.amm.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.amm.common.utils.PageUtils;
import com.amm.gulimall.member.entity.IntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author amm
 * @email 123@gmail.com
 * @date 2022-12-11 20:53:47
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

