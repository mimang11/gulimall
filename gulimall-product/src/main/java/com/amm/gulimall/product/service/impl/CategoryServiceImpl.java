package com.amm.gulimall.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amm.common.utils.PageUtils;
import com.amm.common.utils.Query;

import com.amm.gulimall.product.dao.CategoryDao;
import com.amm.gulimall.product.entity.CategoryEntity;
import com.amm.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    /*  @Autowired
      private  CategoryDao categoryDao;*/
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * @return
     * @author 陈十一
     * @description 查出所有的分类以及子分类, 以树形结构组装起来
     * @date 2022/12/14 13:59
     */
    @Override
    public List<CategoryEntity> listWitchTree() {
        // 第一步 查出所有分类
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        // 组成父子树形结构
        List<CategoryEntity> leve1Menus = categoryEntities.stream().filter(categoryEntity ->
                //查出一级菜单
                categoryEntity.getParentCid() == 0
        ).map((menu) -> {
            menu.setChildren(getChildren(menu, categoryEntities));
            return menu;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        return leve1Menus;
    }

    /**
     *
     * @return
     * @author 陈十一
     * @description 根据id批量删除
     * @date 2022/12/14 21:54
     */
    @Override
    public void removeMenuByIds(List<Long> asList) {
        baseMapper.deleteBatchIds(asList);

    }

    /**
     * @return
     * @author 陈十一
     * @description 递归找出所有的子集菜单
     * @date 2022/12/14 14:30
     */
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {

        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return  categoryEntity.getParentCid().equals(root.getCatId());
        }).map(categoryEntity -> {
            //找子菜单
            categoryEntity.setChildren(getChildren(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            //排序
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        return children;
    }

}