package com.cqupt.bcirs.tests;

import java.util.*;

/**
 * @author ggtms
 * @ 2020-04-21 18:56
 */
public class Test {
    public static void main(String[] args) {
    int a =1;
        System.out.println(3+2/5);
         int $test = 1;
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[2*n];
        int [] Max = new int[2*n - 1];
        int max ,k =022
                ;
        //用两个数组存储压缩前和压缩后的数据
        for(int i = 0; i < n; i++){
            //for(int j = 0; j < n; j++){
            arr[i] = sc.nextInt();
            arr[i + 1] = sc.nextInt();

            //}

        }
        for (int j = 0; j < n/2 + 2; j = j + 2) {
            if(arr[j] + arr[j+3] > arr[j + 1] + arr[j + 2]){
                max =arr[j + 1] + arr[j + 2];
            } else{
                max = arr[j ] + arr[j + 3];
            }
            Max[k] = max;
            k++;
        }
        Arrays.sort(Max);
        System.out.println(Max.length);

*/






        /*int count = 1;
        int time;
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        if(month <= 4){
            System.out.println(count);;
        }
        //先考虑增长的整数倍
        if(month > 5 && month % 4 == 1){
            time = (month % 4)- 1;
            for (int i = time; i > 0; time--) {
                count = 4 * time;
            }
            count = count + 3;
            System.out.println(count);

        }
        if(month % 3 != 0){
            time = (month / 3);
            for (int i = 0; i < time; i++) {
                count = count * 2;

            }
        }
        System.out.println(count);
*/

        }


    public static int repeat(int time){
        if(time == 1){
            return 1 * 4;
        }
        return repeat(time)*4  + repeat(time-1);

    }
    public void test(){

        int count = 1;
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        if(month <= 4){
            System.out.println(count);
        }
        if(month % 3 == 0){
            int time = month % 3;
            for (int i = 0; i < time; i++) {
                count = count * 2;
            }
        }
        if(month % 3 != 0){
            int time = (month / 3) -1;
            for (int i = 0; i < time; i++) {
                count = count * 2;
            }
        }


    }

    @org.junit.Test
    public void testMeituan(){

        //用节点类存储坐标(x,y)

        /*List<Node> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        //while(sc != null){
            int n = sc.nextInt();
            while (n-- != 0){
                int x = sc.nextInt();
                int y = sc.nextInt();
                Node node = new Node(x,y);
                arr.add(node);
            }
            Iterator<Node> iterator = arr.iterator();
            while (iterator.hasNext()){

                System.out.println(iterator.next());
            }

        //}*/


    }
    class Node{
        private int x;
        private int y;

        public Node() {
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}

