package com.cqupt.bcirs.tests;

import com.cqupt.bcirs.service.DealService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ggtms
 * @ 2020-04-19 16:53
 */
public class getPathTest {
    @Test
    public void run1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //注解扫描，执行DealServiceImpl类
        DealService ds = (DealService) ac.getBean("dealService");      //这里的"accountService"与Service实现类的的注解一致
        String path = ds.getImagePath();        ///调的是AccountServiceImpl类中的方法
        System.out.println(path);
    }

}
