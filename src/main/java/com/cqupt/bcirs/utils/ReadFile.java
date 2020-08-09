package com.cqupt.bcirs.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ggtms
 * @ 2020-04-29 17:59
 */
public class ReadFile {

    public static List<File> readFile(String fileDir) {
        //创建文件存放的List
        List<File> fileList = new ArrayList<File>();
        //传入目标文件目录
        File file = new File(fileDir);
        //获取目录下的所有文件或文件夹
        File[] files = file.listFiles();
        //如果目录为空，直接退出
        if (files == null) {
            return null;
        }
        //遍历
        for (File f : files) {        //获取目录下的非文件夹的所有文件
            if (f.isFile()) {
                //将fileDir中的文件夹存到fileList中
                fileList.add(f);
            } /*else if (f.isDirectory()) {         //当前文件仍然是文件夹时继续获取
                //获取每个文件的绝对路径
                System.out.println(f.getAbsolutePath());
                readFile(f.getAbsolutePath());
            }*/
        }
        for (File f1 : fileList) {
            //获取文件名
            System.out.println(f1.getName());
        }
        return fileList;
    }
}
