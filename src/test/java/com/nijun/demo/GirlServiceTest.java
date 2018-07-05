package com.nijun.demo;

import com.nijun.demo.domain.Girl;
import com.nijun.demo.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/5
 * Time: 8:56 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest() {
        Girl girl = girlService.FindById(19);
        Assert.assertEquals(new Integer(22), girl.getAge());
    }
}
