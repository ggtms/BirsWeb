package com.cqupt.bcirs.service.Impl;

import com.cqupt.bcirs.dao.CardDao;
//import com.cqupt.bcirs.dao.PictureDao;
import com.cqupt.bcirs.domain.Card;
import com.cqupt.bcirs.domain.Picture;
import com.cqupt.bcirs.service.DealService;
import com.cqupt.bcirs.utils.DealStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

/**
 * @author ggtms
 * @ 2020-04-14 11:10
 */
@Service("dealService")
public class DealServiceImpl implements DealService {

    @Autowired            //将CardDao中的所有装配到cardDao对象中来
    private CardDao cardDao;            //在dao中要有@Repository

    /*@Autowired
    private PictureDao pictureDao;*/

    @Override
    public void outTest() {
        System.out.println("service层没问题！");
    }

    @Override
    public String getImagePath() {
        return null;
    }

   /* @Override
    public String getImagePath() {
        return pictureDao.getImagePath();
    }*/

    @Override
    public void saveCard(Card card) {
        System.out.println("Service业务层：保存card信息...");
        cardDao.saveBankCard(card);     //调用dao层中的saveCard(card)方法
    }

    @Override
    public void deleteCard() {
        System.out.println("Service业务层：删除card信息...");
        cardDao.deleteBankCard();
    }

    /**
     *  对图像集成处理
     * @param path 待处理图像路径
     * @throws Exception
     */
    @Override
    public void dealProcess(String path) throws Exception {

        File input = new File(/*Picture.getPicture().getPath()*/path);
        //System.out.println(Picture.getPicture().getPath());
        //File inputTemp = new File("D:\\workspace_ideal\\BirsWeb\\src\\temp");
        //File output = new File("D:\\workspace_ideal\\BirsWeb\\src\\temp\\test.jpg");

        //裁剪(把上传的图片作为裁剪源图)
        BufferedImage image = ImageIO.read(input);

        //绘制原图像新的大小
        BufferedImage tag = new BufferedImage(750, 500, BufferedImage.TYPE_INT_RGB);
        tag.getGraphics().drawImage(image, 0, 0, 750, 500, null);

        double wChange = tag.getWidth();
        double hChange = tag.getHeight();

        //设置传入图片的像素大小
        BufferedImage afterCutImage = DealStage.cutImage(tag, 0, (int) (0.5 * hChange), (int) ( wChange), (int) (0.15 * hChange));

        //把经过裁剪后的图片作为处理源图
        //BufferedImage srcImage = afterCutImage;

        int width = afterCutImage.getWidth();
        int height = afterCutImage.getHeight();

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);   //创建接收的图(起缓冲效果)

        DealStage.lumAdjustment(afterCutImage, 10);         //图片的亮度调整

        BufferedImage afterGrayImage = DealStage.imageGray(bi, afterCutImage);   //灰度化

        BufferedImage afterEnhanceImage = DealStage.convertImageToWhite(bi, afterGrayImage, 70);  //凸显出卡号的颜色

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
        for (int j = 0; j < 10; j++) {
            px = DealStage.medianFiltering(px, width, height);
        }
        //int newpx[] = DealStage.snnFiltering(px, width, height);
        //int againpx[] = DealStage.snnFiltering(newpx, width, height);
        //afterOptionImage.setRGB(0, 0, width, height, againpx, 0, width);
        afterOptionImage.setRGB(0, 0, width, height, px, 0, width);

        ImageIO.write(afterOptionImage, "jpg", input);

    }
}
