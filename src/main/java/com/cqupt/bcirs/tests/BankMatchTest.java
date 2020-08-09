package com.cqupt.bcirs.tests;

import com.cqupt.bcirs.utils.JudgeBank;
import org.junit.Test;

/**
 * @author ggtms
 * @ 2020-04-19 23:17
 */
public class BankMatchTest {
    @Test
    public void test(){
        String str = "6222030210010631815";
        String name = JudgeBank.getName(str);
        System.out.println("发卡行:"+ name);
    }
}
