package com.cqupt.bcirs.tests;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author ggtms
 * @ 2020-04-15 8:49
 */
public class RecognizeTest {
    @Test
    public void test1() {

        for (int i = 1; i < 16 ; i++) {

            //识别图片的路径（修改为自己的图片路径）
            String path = "D:\\RecognizeImage\\birsImage\\truePlanA\\finalA\\normal\\A" + i + ".jpg";
            //String path = "D:\\workspace_ideal\\BirsWeb\\src\\temp\\OriginalTest.jpg";

            // 语言库位置（修改为跟自己语言库文件夹的路径）
            String lagnguagePath = "D:\\tessdata";

            File file = new File(path);
            ITesseract instance = new Tesseract();

            //设置训练库的位置
            instance.setDatapath(lagnguagePath);

            //chi_sim ：简体中文， eng    根据需求选择语言库
            instance.setLanguage("zdyI");         //使用简体中文字库
            String result = null;
            try {
                long startTime = System.currentTimeMillis();
                result = instance.doOCR(file);
                long endTime = System.currentTimeMillis();
                System.out.println("Time is：" + (endTime - startTime) + " 毫秒");
            } catch (TesseractException e) {
                e.printStackTrace();
            }

            System.out.println("RecognizeResult: " + result);
            //result.replaceAll("\\s* ","");   //不可行
           char[] charsResult = result.toCharArray();
            StringBuilder sb = new StringBuilder();

            //使用StringBuilder滤去空格重新存储

            for (int k = 0; k < result.length(); k++) {
                if(charsResult[k] == '0' || charsResult[k] == '1' || charsResult[k] == '2'
                        || charsResult[k] == '3' || charsResult[k] == '4' || charsResult[k] == '5'
                        || charsResult[k] == '6' || charsResult[k] == '7' || charsResult[k] == '8'
                        || charsResult[k] == '9'){
                    sb.append(charsResult[k]);
                }
            }
            result = String.valueOf(sb);
            System.out.println(i + "newresult :" + result);
        }
    }
    @Test
    public void test2() throws Exception {
        File imageFile = new File("D:\\workspace_ideal\\BirsWeb\\src\\temp\\nulltest\\10(02).jpg");
        BufferedImage image = ImageIO.read(imageFile);
        //对图片进行处理
        image = convertImage(image);
        // 语言库位置（修改为跟自己语言库文件夹的路径）
        String lagnguagePath = "D:\\tessdata";
        //设置训练库的位置

        ITesseract instance = new Tesseract();//JNA Interface Mapping
        instance.setDatapath(lagnguagePath);
        instance.setLanguage("chi_sim");//使用中文字库
        long startTime = System.currentTimeMillis();

        String result = instance.doOCR(image); //识别
        long endTime = System.currentTimeMillis();
        System.out.println("Time is：" + (endTime - startTime) + " 毫秒");
        System.out.println(result);
    }
    public static BufferedImage convertImage(BufferedImage image) throws Exception {
        //按指定宽高创建一个图像副本
        //image = ImageHelper.getSubImage(image, 0, 0, image.getWidth(), image.getHeight());
        //图像转换成灰度的简单方法 - 黑白处理
        image = ImageHelper.convertImageToGrayscale(image);
        //图像缩放 - 放大n倍图像
        //image = ImageHelper.getScaledInstance(image, image.getWidth() * 3, image.getHeight() * 3);
        image = ImageHelper.getScaledInstance(image, image.getWidth() * 2, image.getHeight() * 2);
        return image;
    }
}