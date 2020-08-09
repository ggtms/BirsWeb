package com.cqupt.bcirs.tests;

import com.cqupt.bcirs.utils.ReadFile;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @author ggtms
 * @ 2020-04-29 18:03
 */
public class FileReceptTest {
    public static void main(String[] args) {
        List<File> files = ReadFile.readFile("D:\\workspace_ideal\\BirsWeb\\src\\temp");
        //遍历
        Iterator<File> iterator = files.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next()+File.separator);
        }
    }
}
