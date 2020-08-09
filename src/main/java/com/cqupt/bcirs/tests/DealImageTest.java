package com.cqupt.bcirs.tests;

import com.cqupt.bcirs.domain.Picture;
import com.cqupt.bcirs.utils.DealStage;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author ggtms
 * @ 2020-04-19 19:39
 */
public class DealImageTest {
    @Test
    public void dealTestOne() throws IOException {
        for(int i = 20 ; i < 36; i++) {

            String path = "D:\\workspace_ideal\\BirsWeb\\src\\temp\\false\\" + i + ".jpg";
            //System.out.println(Picture.getPicture().getPath());

            //改变图片大小后存储的路径
            File ChangePath = new File("D:\\RecognizeImage\\birsImage\\truePlanA\\onlyCut\\change" + i + ".jpg");

            File CutPath = new File("D:\\RecognizeImage\\birsImage\\truePlanA\\onlyCut\\Cut" + i + ".jpg");
            File LumPath = new File("D:\\RecognizeImage\\birsImage\\truePlanA\\afterLuminance\\Lum" + i + ".jpg");
            File GrayPath = new File("D:\\RecognizeImage\\birsImage\\truePlanA\\afterGray\\Gray" + i + ".jpg");
            File EnhancePath = new File("D:\\RecognizeImage\\birsImage\\truePlanA\\afterEnhance\\enhanceAfterGray" + i + ".jpg");
            File BinaryPath = new File("D:\\RecognizeImage\\birsImage\\truePlanA\\afterBinary\\Binary" + i + ".jpg");
            File DilatePath = new File("D:\\RecognizeImage\\birsImage\\truePlanA\\afterDilate\\Dilate" + i + ".jpg");
            File DenoisePath = new File("D:\\RecognizeImage\\birsImage\\truePlanA\\afterDenoise\\DilateAfterDenoise" + i + ".jpg");


            File output = new File("D:\\RecognizeImage\\birsImage\\falsePlanA\\finalA\\a" + i + ".jpg");

            //裁剪(把上传的图片作为裁剪源图)
            BufferedImage image = ImageIO.read(new File(path));
            //原图的宽高信息
            /*
            //此部分原想图像消影（技术不够，免去）
            double w = image.getWidth();
            double h = image.getHeight();
            if (w < h) {
                double temp = w;
                w = h;
                h = temp;

            }*/

            //绘制原图像新的大小
            BufferedImage tag = new BufferedImage(750, 500, BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(image, 0, 0, 750, 500, null);

            double wChange = tag.getWidth();
            double hChange = tag.getHeight();

            //设置传入图片的像素大小

            //plan  A
            BufferedImage afterCutImage = DealStage.cutImage(tag, 0, (int) (0.5 * hChange), (int) ( wChange), (int) (0.15 * hChange));
            //BufferedImage afterCutImage = DealStage.cutImage(image, (int) (0.05*w), (int) (0.48*h), (int) (0.8*w),(int) (0.15*h));

            //把经过裁剪后的图片作为处理源图
            //BufferedImage srcImage = afterCutImage;

            int width = afterCutImage.getWidth();
            int height = afterCutImage.getHeight();

            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);   //创建接收的图(起缓冲效果)

            DealStage.lumAdjustment(afterCutImage, 10);         //图片的亮度调整

            BufferedImage afterGrayImage = DealStage.imageGray(bi, afterCutImage);   //灰度化

            BufferedImage afterEnhanceImage = DealStage.convertImageToWhite(bi, afterGrayImage, 70);  //凸显出卡号的颜色
            //DealStage.lumAdjustment(afterGrayImage, 20);

            BufferedImage afterBinaryImage = DealStage.imageBinary(bi, afterEnhanceImage, 210);    //二值化

            //图像膨胀(前提为图像最好是二值化的图像，灰度化的也行)
            //先将图像转为二维数组存储
            int[][] arrayImage = DealStage.imageToArray(afterBinaryImage,width,height);
            //操作图像的二维数组进行膨胀
            int[][] imageDilate = DealStage.corrode(arrayImage, 1);
            //将膨胀后的数组转为bufferedImae形式存储
            BufferedImage afterOptionImage = DealStage.arrayToGreyImage(imageDilate);

            //BufferedImage afterSharpenImage = DealStage.lapLaceSharpen(bi, afterOptionImage);   //梯度锐化

            //离散降噪部分
            int[] px = new int[width * height];
            px = afterOptionImage.getRGB(0, 0, width, height, px, 0, width);
            //循环滤波
            for (int j = 0; j < 100; j++) {
                px = DealStage.medianFiltering(px, width, height);
            }
            //int newpx[] = DealStage.snnFiltering(px, width, height);
            //int againpx[] = DealStage.snnFiltering(newpx, width, height);
            //afterOptionImage.setRGB(0, 0, width, height, againpx, 0, width);
            afterOptionImage.setRGB(0, 0, width, height, px, 0, width);
            //bi.setRGB(0, 0, width, height, againpx, 0, width);
            //bi.setRGB(0, 0, width, height, px, 0, width);
            ImageIO.write(afterOptionImage, "jpg", output);
        }
    }
}
