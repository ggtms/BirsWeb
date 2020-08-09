package com.cqupt.bcirs.tests;

/**
 * @author ggtms
 * @ 2020-04-19 19:51
 */

import com.cqupt.bcirs.utils.DealStage;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 实现图片的裁剪测试，输入起点x、y，宽度width、高度height
 */
public class CutTest {
    @Test
    public void cutTest(){
        BufferedImage bi=readImg("D:\\workspace_ideal\\BirsWeb\\src\\temp\\10.jpg");  //读取图片
        double w = bi.getWidth();
        double h = bi.getHeight();
        //BufferedImage bii=img_tailor(bi, (int) (0.05*w), (int) (0.48*h), (int) (0.8*w),(int) (0.15*h));
        BufferedImage bii=img_tailor(bi, 0, (int) (0.5*h), (int) w,(int) (0.15*h));
        imgSave(bii,"jpg","D:\\workspace_ideal\\BirsWeb\\src\\temp\\test.jpg");  //生成图片
    }

    @Test
    public void convertTest() throws IOException {
        BufferedImage afterCutImage = readImg("D:\\workspace_ideal\\BirsWeb\\src\\temp\\test.jpg");
        //DealStage.lumAdjustment(afterCutImage, 30);         //图片的亮度调整

        BufferedImage afterGrayImage = DealStage.imageGray(afterCutImage, afterCutImage);   //灰度化
        convertImageToWhite(afterGrayImage,70);
        //BufferedImage afterBinaryImage = DealStage.imageBinary(afterGrayImage, afterGrayImage, 210);
        imgSave(afterCutImage,"jpg","D:\\workspace_ideal\\BirsWeb\\src\\temp\\ConvertTest.jpg");
    }

    /**
     * @param srcImage  输入的原图
     * @param rgb   输入判断像素为255的阈值
     */
    public static void convertImageToWhite(BufferedImage srcImage,int rgb) {
        for (int j = 0; j < srcImage.getHeight(); j++) {                 //遍历像数值
            for (int i = 0; i < srcImage.getWidth(); i++) {
                int p = srcImage.getRGB(i, j);

                int a = (p >> 24) & 0XFF;
                int r = (p >> 16) & 0XFF;    //取出r分量并与阈值判断
                if(r > rgb){
                    r = 255;
                }
                int g = (p >> 8) & 0XFF;     //取出g分量并与阈值判断
                if(g > rgb){
                    g = 255;
                }
                int b = p & 0XFF;     //取出b分量并与阈值判断
                if(b > rgb){
                    b = 255;
                }
                p = (a << 24) | (r << 16) | (g << 8) | b;
                srcImage.setRGB(i, j, p);      //将更改后的像素存入原图中
            }
        }
    }
    public static BufferedImage img_tailor(BufferedImage src,int x,int y,int width,int height) {
        BufferedImage back=src.getSubimage(x,y,width,height);
        return back;
    }
    /*public static BufferedImage img_tailor(BufferedImage src,int x,int y,int width,int height) {
        BufferedImage back=src.getSubimage(x,y,width,height);
        return back;
    }*/
    //读取图片
    public static BufferedImage readImg(String input) {
        try {
            BufferedImage bufferedImage= ImageIO.read(new File(input));
            return bufferedImage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //保存图片,extent为格式，"jpg"、"png"等
    public static void imgSave(BufferedImage img,String extent,String output) {
        try {
            ImageIO.write(img, extent, new File(output));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
