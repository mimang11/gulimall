package com.amm.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.amm.common.utils.PageUtils;
import com.amm.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author amm
 * @email 123@gmail.com
 * @date 2022-12-11 17:04:40
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWitchTree();

    void removeMenuByIds(List<Long> asList);
}

