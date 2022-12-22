package com.amm.gulimall.product;

import com.amm.gulimall.product.entity.BrandEntity;
import com.amm.gulimall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    public void addBrandentity() {
        BrandEntity brandEntity = new BrandEntity();
        // brandEntity.setName("苹果");
        //brandService.save(brandEntity);
     /*   brandEntity.setBrandId(1L);
        brandEntity.setDescript("美国有苹果 , 中国有菠萝 菠萝手机");
        brandService.updateById(brandEntity);*/
        List<BrandEntity> brand_id = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1));
/*        for (BrandEntity entity : brand_id) {
            System.out.println(entity);
        }*/
        brand_id.forEach((entity) -> {
            System.out.println(entity);
        });
    }

    @Test
    public void testSteam(){
        //测试steam流的filter过滤器结果为null时还能走下去吗

        ArrayList<String> strings = new ArrayList<>();
        strings.add("喜羊羊");
        strings.add("灰太狼");
        strings.add("沸羊羊");
        strings.add("暖洋洋");
        strings.add("村长");

        List<String> stringList = strings.stream().filter((item) -> {
            return item.equals("懒洋洋");
        }).map((item)->{
            System.out.println(item);
            return item;
        }).sorted((n1,n2)->{
            System.out.println("1111");
            return 1;
        }).collect(Collectors.toList());
        System.out.println(stringList.toString());
    }


}
