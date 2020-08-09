package com.cqupt.bcirs.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ggtms
 * @ 2020-05-14 14:41
 */
public class HelpTest {
    /**
     * 可参考逆序对问题
     * 分析：最多会罚款count-1个车主
     * @param args
     */
    public static void main(String[] args) {
        //标记车辆总数
        int count;
        //标记罚款车辆总数
        int payCount = 0;
        //车辆输入隧道的顺序
        Scanner scan = new Scanner(System.in);

        Map<Integer,Integer> map = new HashMap<>();
        //处理
        count = scan.nextInt();
        //进隧道车队
        StringBuilder[] input = new StringBuilder[count];
        while(scan.hasNext()){
            int num = 0;
            for (int i = 1; i <= count; i++) {

                map.put(i,i);
            }
        }
    }
}
