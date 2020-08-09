package com.cqupt.bcirs.tests;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author ggtms
 * @ 2020-04-23 19:32
 */
public class Origion {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();     //a的长度
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            int a = sc.nextInt();
            //将输入的坐标存入二维数组
            arr[i] = a;
        }

        int flag = 0;
        //判断相似
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if((arr[i] & arr[j]) != 0){

                }
            }
        }
    }
        /*Scanner sc = new Scanner(System.in);
        //while(sc != null){
        int n = sc.nextInt();
        int[][] arr = new int[n][];
        int len = n;
            for (int i = 0; i < len ; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                //将输入的坐标存入二维数组
               arr[i] = new int[]{a, b};
            }
        for (int i = 0; i < len; i++) {
            System.out.println("x:"+arr[i][0]+ "y:"+arr[i][1]);
        }
        //计数
        int count = 0;
        for (int i = 0; i < len  ; i++) {            //表示当前所在坐标
            int countX = 0;        //因为下面在比较时重复了与自身的比较所以判断的阈值为3
            int countY = 0;
            for (int j = 0; j < len ; j++) {         //每次与另一个坐标比较

                //检查当前点是否有x相同的
                if(arr[i][0] == arr[j][0]){
                    countX ++;
                }
                //检查当前点是否有y相同的
                if(arr[i][1] == arr[j][1]){
                    countY++;
                }
                if(countX >= 3 && countY >= 3){
                    count++;
                    j=8;              //该点为幸运星跳出当前循环
                }
            }
        }
        System.out.println(count);
    }*/
}
