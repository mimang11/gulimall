package com.amm.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.amm.common.utils.PageUtils;
import com.amm.gulimall.product.entity.AttrAttrgroupRelationEntity;

import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author amm
 * @email 123@gmail.com
 * @date 2022-12-11 19:19:30
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

