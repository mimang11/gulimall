package com.amm.gulimall.product;

import com.amm.gulimall.product.entity.BrandEntity;
import com.amm.gulimall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
        brand_id.forEach((entity)->{
            System.out.println(entity);
        });
    }


}
