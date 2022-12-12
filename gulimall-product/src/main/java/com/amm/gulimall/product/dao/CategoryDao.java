package com.amm.gulimall.product.dao;

import com.amm.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author amm
 * @email 123@gmail.com
 * @date 2022-12-11 17:04:40
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
