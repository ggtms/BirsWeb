package com.cqupt.bcirs.tests;

import com.cqupt.bcirs.service.DealService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author ggtms
 * @ 2020-04-14 11:49
 */
public class TestSpring {
    @Test
    public void run1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        DealService ds = (DealService) ac.getBean("dealService");           //获得DealService中的ds服务的对象
        ds.outTest();

    }

}
