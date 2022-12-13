package com.amm.gulimall.coupon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallCouponApplicationTests {

    @Test
    public void contextLoads() {
        int num = this.demo(5, 10);
        System.out.println("最大值为:" + num);

    }

    /**
     *
     * @return
     * @author 陈十一
     * @description x*y不大于z， 求y最大值
     * @date 2022/12/13 17:01
     */
    public int demo(int num1, int num2) {
        int value = 0;
        for (int i = 0; i < num2; i++) {
            if (num1 * i == num2 - 1) {

                return value = i;
            }
        }
        return value;
    }

}
