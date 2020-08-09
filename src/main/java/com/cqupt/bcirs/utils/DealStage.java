package com.cqupt.bcirs.utils;


import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ggtms
 * @ 2020-04-15 21:21
 */
public class DealStage {

//    private static final long serialVersionUID = 1140236462766935667L;
//    private MediaTracker mediaTracker;
//    private Image[][] images;    //配合多个分割图的
//    private Image image;      //配合只分割一个的
    //

    /**
     *
     * @param srcImage 待裁剪图像
     * @param x 裁剪的起点x
     * @param y 裁剪的起点y
     * @param width 裁剪后的宽
     * @param height 裁剪后的高
     * @return 裁剪后的图像
     */
    public static BufferedImage cutImage(BufferedImage srcImage,int x,int y,int width,int height) {
    BufferedImage bi = srcImage.getSubimage(x, y, width, height);
    return bi;
}
    //将image转bufferedImage的方法
    /*public static BufferedImage toBufferedImage(Image image) {
        image = new ImageIcon(image).getImage();
        boolean hasAlpha = false;
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        try {
            int transparency = Transparency.OPAQUE;
            if (hasAlpha) {
                transparency = Transparency.BITMASK;
            }
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage = gc.createCompatibleImage(image.getWidth(null), image
                    .getHeight(null), transparency);
        } catch (HeadlessException e) {
        }
        if (bimage == null) {
            int type = BufferedImage.TYPE_INT_RGB;
            if (hasAlpha) {
                type = BufferedImage.TYPE_INT_ARGB;
            }
            bimage = new BufferedImage(image.getWidth(null), image
                    .getHeight(null), type);
        }
        //下面代码是在画板上去画，必须要要
        Graphics g = bimage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return bimage;
    }*/
   /* *//**
     *
     * @param image 表示待分割的目标图像
     * @param x 开始裁剪位置的X坐标
     * @param y 开始裁剪位置的Y坐标
     * @param width 每次裁剪的图片宽度
     * @param height 每次裁剪的图片高度
     * @param changeX 每次需要改变的X坐标数量
     * @param changeY 每次需要改变的Y坐标数量
     * @param component 容器对象，目的是用来创建裁剪后的每个图片对象
     * @return 裁剪完后的Image图片
     *//*
    public static Image cutImage(Image image, int x,
                                 int y, int width, int height, int changeX, int changeY,
                                 Component component) {
        //public CropImageFilter(int x, int y, int w, int h)
        //按指定 x、y、w 和 h 参数从源 Image 提取绝对矩形区域来构造 CropImageFilter
        //x - 要提取的矩形顶部的 x 位置
        //y - 要提取的矩形顶部的 y 位置
        //w - 要提取的矩形宽度
        //h - 要提取的矩形高度
        Image afterCut ;
        ImageFilter filter = new CropImageFilter(x +changeX , y + changeY, width, height);
        afterCut = component.createImage(new FilteredImageSource(
                image.getSource(), filter));
        return afterCut;
    }*/
    //结构元素，图像膨胀腐蚀所用
    private static int sData[]={
            0,0,0,
            0,1,0,
            0,1,1
    };

    /**
     * 将二维数组转成灰度图像
     * @param srcArray  图像数组
     * @return  buffereImage图像
     */
    public static BufferedImage arrayToGreyImage(int[][] srcArray){
        int width = srcArray[0].length;
        int height = srcArray.length;
        BufferedImage targetImage=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int j = 0;j < height;j++){
            for(int i = 0;i < width;i++){
                int grayRGB = srcArray[j][i];         //取出来的值
                int rgb = (grayRGB << 16) | (grayRGB << 8) | grayRGB; //00000000 00000000 00000000 的值
                targetImage.setRGB(i, j, rgb);
            }
        }
        return targetImage;
    }

    /**
     *将图像转成二维数组形式存储
     * @param srcImage 传入的原图
     * @return 返回二维数组化了的图像
     */
    public static int[][] imageToArray(BufferedImage srcImage,int w,int h){
        int[][] result = new int[h][w];
        for(int j = 0;j < h;j++){
            for(int i = 0;i < w;i++){
                int pixel = srcImage.getRGB(i, j);
                int gray = (pixel >> 16) & 0xFF;     //灰度图象值都一样，取哪一个没关系
                result[j][i] = gray;
            }
        }
        return result;
    }

    /**
     * 腐蚀运算（原二值图像是白底黑字的话就是进行的图像膨胀）
     * @param source 二维数组形式存储的图像
     * @param threshold 当灰度值大于阈值（小于阈值）时并且结构元素为1（0）时，才认为对应位置匹配上；
     * @return
     */
    public static int[][] corrode(int[][] source,int threshold){
        int width = source[0].length;
        int height = source.length;

        int[][] result=new int[height][width];

        for(int i = 0;i < height;i++){
            for(int j = 0;j < width;j++){
                ///边缘不进行操作，边缘内才操作
                if(i > 0 && j > 0 && i < height-1 && j < width-1){
                    int max = 0;
                    ///对结构元素进行遍历
                    for(int k = 0;k < sData.length;k++){
                        int x = k / 3;//商表示x偏移量
                        int y = k % 3;//余数表示y偏移量

                        if(sData[k] != 0){
                            //不为0时，必须全部大于阈值，否则就设置为0并结束遍历
                            if(source[i-1+x][j-1+y]>=threshold){
                                if(source[i-1+x][j-1+y]>max){
                                    max=source[i-1+x][j-1+y];
                                }
                            }else{
                                //与结构元素不匹配,赋值0,结束遍历
                                max = 0;
                                break;
                            }
                        }
                    }
                    ////此处可以设置阈值，当max小于阈值的时候就赋为0
                    result[i][j] = max;
                }else{
                    ///直接赋值
                    result[i][j]=source[i][j];
                }
            }
        }
        return result;
    }

    /**
     *  膨胀运算(原二值图像是白底黑字的话就是进行的图像腐蚀)
     * @param source  二维数组形式存储的图像
     * @param threshold  阈值阈值————当膨胀结果小于阈值时，仍然设置图像
     * 位置的值为0；而进行腐蚀操作时，当灰度值大于等于阈值（小于阈值）时
     * 并且结构元素为1（0）时，才认为对应位置匹配上；
     * 如果为二值图像，则应该传入1。
     * @return
     */
    public static int[][] dilate(int[][] source,int threshold){
        int width=source[0].length;               //图像的长
        int height=source.length;                 //图像的宽

        int[][] result=new int[height][width];

        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                ///边缘不进行操作
                if(i>0&&j>0&&i<height-1&&j<width-1){
                    int max = 0;
                    ///对结构元素进行遍历
                    for(int k=0;k<sData.length;k++){
                        int x=k/3;       //商表示x偏移量
                        int y=k%3;       //余数表示y偏移量
                        if(sData[k]!=0){
                            //当结构元素中不为0时,取出图像中对应各项的最大值赋给图像当前位置作为灰度值
                            if(source[i-1+x][j-1+y]>max){
                                max=source[i-1+x][j-1+y];
                            }
                        }
                    }
                    //此处可以设置阈值，当max小于阈值的时候就赋为0
                    if(max < threshold){
                        result[i][j]=0;
                    }else{
                        result[i][j]=max;
                    }
                }else{
                    ///直接赋值
                    result[i][j]=source[i][j];
                }

            }
        }
        return result;
    }
    /**
     * 对图像进行降噪(中值滤波)
     * @param pix 像素矩阵数组
     * @param w 矩阵的宽
     * @param h 矩阵的高
     * @return 处理后的数组
     */
    public static int[] medianFiltering(int pix[], int w, int h) {
        int newpix[] = new int[w*h];
        int[] temp = new int[9];
        ColorModel cm = ColorModel.getRGBdefault();
        int r;
        for(int y=0; y<h; y++) {
            for(int x=0; x<w; x++) {
                if(x!=0 && x!=w-1 && y!=0 && y!=h-1) {
                    //g = median[(x-1,y-1) + f(x,y-1)+ f(x+1,y-1)
                    //  + f(x-1,y) + f(x,y) + f(x+1,y)
                    //  + f(x-1,y+1) + f(x,y+1) + f(x+1,y+1)]
                    temp[0] = cm.getRed(pix[x-1+(y-1)*w]);
                    temp[1] = cm.getRed(pix[x+(y-1)*w]);
                    temp[2] = cm.getRed(pix[x+1+(y-1)*w]);
                    temp[3] = cm.getRed(pix[x-1+(y)*w]);
                    temp[4] = cm.getRed(pix[x+(y)*w]);
                    temp[5] = cm.getRed(pix[x+1+(y)*w]);
                    temp[6] = cm.getRed(pix[x-1+(y+1)*w]);
                    temp[7] = cm.getRed(pix[x+(y+1)*w]);
                    temp[8] = cm.getRed(pix[x+1+(y+1)*w]);
                    Arrays.sort(temp);
                    r = temp[4];
                    newpix[ y * w + x] = 255 << 24 | r<<16 | r<<8 |r;   //产生新的像素
                } else {
                    newpix[y*w+x] = pix[y*w+x];
                }
            }
        }
        return newpix;
    }

    /**
     *对图像进行降噪（均值滤波法)
     * @param pix 像素矩阵数组
     * @param w 矩阵的宽
     * @param h 矩阵的高
     * @return 处理后的数组
     */
    public static int[] snnFiltering(int pix[], int w, int h) {
        int newpix[] = new int[w*h];
        int n = 9;
        int i1,i2, sum;
        int[] temp1 = new int[n];
        int[] temp2 = new int[n/2];
        ColorModel cm = ColorModel.getRGBdefault();
        int r;
        for(int y=0; y<h; y++) {
            for(int x=0; x<w; x++) {
                if(x!=0 && x!=w-1 && y!=0 && y!=h-1) {
                    sum = 0;
                    temp1[0] = cm.getRed(pix[x-1+(y-1)*w]);
                    temp1[1] = cm.getRed(pix[x+(y-1)*w]);
                    temp1[2] = cm.getRed(pix[x+1+(y-1)*w]);
                    temp1[3] = cm.getRed(pix[x-1+(y)*w]);
                    temp1[4] = cm.getRed(pix[x+(y)*w]);
                    temp1[5] = cm.getRed(pix[x+1+(y)*w]);
                    temp1[6] = cm.getRed(pix[x-1+(y+1)*w]);
                    temp1[7] = cm.getRed(pix[x+(y+1)*w]);
                    temp1[8] = cm.getRed(pix[x+1+(y+1)*w]);
                    for(int k=0; k < n/2; k++) {
                        i1 = Math.abs(temp1[n/2] - temp1[k]);
                        i2 = Math.abs(temp1[n/2] - temp1[n-k-1]);
                        temp2[k] = i1<i2 ? temp1[k] : temp1[n-k-1];  //选择最接近原像素值的一个邻近像素
                        sum = sum + temp2[k];
                    }
                    r = sum/(n>>2);
                    newpix[y * w + x] = 255 << 24 | r << 16 | r << 8 | r;
                } else {
                    newpix[y*w+x] = pix[y*w+x];
                }
            }
        }
        return newpix;
    }


    /**
     * //图像锐化操作(拉普拉斯算法)
     *①二阶微分锐化，拉普拉斯算子 定义一个3*3滤波器，计算中心像素与上下左右四个像素差值
     * @param bi
     * @param srcImage
     * @return
     */
    public static BufferedImage lapLaceSharpen(BufferedImage bi,BufferedImage srcImage){
        //BufferedImage fianlImage = new BufferedImage(bi.getWidth(), bi.getHeight(), bi.getType());
        for (int i = 1; i < srcImage.getWidth() - 1; i++) {
            for(int j = 1;j < srcImage.getHeight() - 1; j++){
                int rgb = srcImage.getRGB(i,j);       //原像素
                //计算周围像素
                int rgb1 = srcImage.getRGB(i - 1,j);
                int rgb2 = srcImage.getRGB(i + 1,j);
                int rgb3 = srcImage.getRGB(i,j - 1);
                int rgb4 = srcImage.getRGB(i,j + 1);
                //分别取出rgb周围的像素值放在临时的数组中，用一个数组表示Red，下同
                int[] R = new int[] { (rgb1 >> 16) & 0xff, (rgb2 >> 16) & 0xff, (rgb3 >> 16) & 0xff,
                        (rgb4 >> 16) & 0xff, (rgb >> 16) & 0xff };
                int[] G = new int[] { (rgb1 >> 8) & 0xff, (rgb2 >> 8) & 0xff, (rgb3 >> 8) & 0xff, (rgb4 >> 8) & 0xff,
                        (rgb >> 8) & 0xff };
                int[] B = new int[] { rgb1 & 0xff, rgb2 & 0xff, rgb3 & 0xff, rgb4 & 0xff, rgb & 0xff };

                //拉普拉斯公式
                double dR = R[0] + R[1] + R[2] + R[3] - 4 * R[4];
                double dG = G[0] + G[1] + G[2] + G[3] - 4 * G[4];
                double dB = B[0] + B[1] + B[2] + B[3] - 4 * B[4];

                double r = R[4] - dR;
                double g = G[4] - dG;
                double b = B[4] - dB;

                //赋值计算之后的像素值
                rgb = (255 & 0xff) << 24 | (clamp((int) r) & 0xff) << 16 | (clamp((int) g) & 0xff) << 8
                        | (clamp((int) b) & 0xff);
                bi.setRGB(i,j,rgb);
            }
        }
        //梯度锐化后的image
        return bi;
    }
    /**
     * 对图像进行梯度锐化（一阶微分梯度锐化)
     * @param bi 输出的图像
     * @param srcImage 待传入图像
     * @return 返回锐化后的图
     */
    public static BufferedImage degreeSharpenDeal(BufferedImage bi,BufferedImage srcImage){
        for (int i = 1; i < srcImage.getWidth() - 1; i++) {
            for(int j = 1; j < srcImage.getHeight() - 1; j++){
                java.util.List<Integer> rList = new ArrayList<>();
                java.util.List<Integer> gList = new ArrayList<>();
                java.util.List<Integer> bList = new ArrayList<>();
                for(int x = -1; x < 2; x++){
                    for(int y = -1; y < 2; y++){
                        int rgb = srcImage.getRGB(i + x,j+y);
                        int R = (rgb >> 16) & 0xff;
                        int G = (rgb >> 8) & 0xff;
                        int B = rgb & 0xff;
                        rList.add(R);
                        gList.add(G);
                        bList.add(B);
                    }
                }
                int r = getResult(rList);
                int g = getResult(gList);
                int b = getResult(bList);

                r = rList.get(4) + r / 4;
                g = gList.get(4) + g / 4;
                b = bList.get(4) + b / 4;

                int rgb = (255 & 0xff) << 24 |(clamp(r) & 0xff) << 16 |(clamp(g) & 0xff) << 8 |(clamp(b) & 0xff);
                bi.setRGB(i,j,rgb);
            }
        }
        return bi;
    }

    /**
     * **********************************************************
     * 提升凸显卡号部分的识别度（过滤）
     * @param bi 待输出图像
     * @param srcImage 待传入图像
     * @param rgb 设置滤去的rgb阈值(70左右)
     * @return 返回去除复杂背景的图
     */
    public static BufferedImage convertImageToWhite(BufferedImage bi,BufferedImage srcImage,int rgb) {
        //int black = new Color(0, 0, 0).getRGB();
        //int white = new Color(255, 255, 255).getRGB();
        for (int j = 0; j < srcImage.getHeight(); j++) {
            for (int i = 0; i < srcImage.getWidth(); i++) {
                int p = srcImage.getRGB(i, j);    //获取图片在i,j位置的像素点信息(有32位)

                // 先将25-32位的数据右移到末8位，
                // 再与11111111做与运算过滤掉高位，仍然保留末8位数据，
                // 这是为了获取int p的25-32位的byte值
                int a = (p >> 24) & 0xff;//alpha通道(透明度)
            /*if(a != 0){
                a = 255;
            }*/
                //表示右移16位，然后和0xff也就是（11111111）进行与运算
                //获取的是17-24位的值  R
                int r = (p >> 16) & 0xff;
                if(r > rgb){
                    r = 255;
                }
                //获取的是9-16位的值  G
                int g = (p >> 8) & 0xff;
                if(g > rgb){
                    g = 255;
                }
                //接收int末8位数据(1-8)  B
                int b = p & 0xff;
                if(b > rgb){
                    b = 255;
                }
                //让每一个像素点与avg一 一比较，
                // 小于等于avg的像素点就为0（黑色），大于avg的像素点为255（白色）
                //上述算法没考虑，下面直接用的avg替换原来的RGB值
                p = (a << 24) | (r << 16) | (g << 8) | b;
                //System.out.println("p为：" + p);
                //表示的a部分   表示的r部分  表示的g部分  表示的b部分
                bi.setRGB(i, j, p);
            }
        }
        return bi;
    }

    /**
     * 对图像进行灰度化
     * @param bi 待输出图像
     * @param srcImage 待传入图像
     * @return 经过灰度化后的bi
     * @throws IOException
     */
    public static BufferedImage imageGray(BufferedImage bi,BufferedImage srcImage) throws IOException {
        //③灰度算法：加权平均法
        //根据重要性及其它指标，将三个分量以不同的权值进行加权平均。由于人眼对绿色的敏感最高，
        // 对蓝色敏感最低，因此，按下式对RGB三分量进行加权平均能得到较合理的灰度图像
        int w = srcImage.getWidth();
        int h = srcImage.getHeight();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                final int color = srcImage.getRGB(i, j);
                final int r = (color >> 16) & 0xff;
                final int g = (color >> 8) & 0xff;
                final int b = color & 0xff;
                int gray = (int) (0.3 * r + 0.59 * g + 0.11 * b);
                int newPixel = colorToRGB(255, gray, gray, gray);
                bi.setRGB(i, j, newPixel);        //将灰度化后的颜色写入bi中
            }
        }
        //返回灰度化后的image
        return bi;
    }

    /**
     *  对图像进行二值化
     * @param bi 输出图像
     * @param srcImage 待传入图像
     * @param sw 二值化的阈值(设置为192，产生白底黑字)
     * @return 经过二值化后的bi
     * @throws IOException
     */
    public static BufferedImage imageBinary(BufferedImage bi,BufferedImage srcImage,double sw) throws IOException {
        int w = srcImage.getWidth();
        int h = srcImage.getHeight();
        float[] rgb = new float[3];
        double[][] coordinate = new double[w][h];
        int black = new Color(0, 0, 0).getRGB();
        int white = new Color(255, 255, 255).getRGB();
        for (int  i= 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                int pixel = srcImage.getRGB(i, j);
                rgb[0] = (pixel & 0xff0000) >> 16;
                rgb[1] = (pixel & 0xff00) >> 8;
                rgb[2] = (pixel & 0xff);
                float avg = (rgb[0]+rgb[1]+rgb[2])/3;
                coordinate[i][j] = avg;
            }
        }
        //这里是阈值，白底黑字还是黑底白字，大多数情况下建议白底黑字，后面都以白底黑字为例
        //double sw = 192;   //值越大，黑点越多
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (coordinate[i][j] < sw) {
                    bi.setRGB(i, j, black);
                }else{
                    bi.setRGB(i, j, white);
                }
            }
        }
        //返回二值化后的图
        return bi;
    }

    /**
     * 图片亮度调整
     * @param srcImage  传入要调整亮度的图片
     * @param param  预计提升的亮度值（值为30比较好）
     * @throws IOException
     */
    public static void lumAdjustment(BufferedImage srcImage, int param) throws IOException {
        if (srcImage == null) {
            return;
        } else {
            int rgb, R, G, B;
            for (int i = 0; i < srcImage.getWidth(); i++) {
                for (int j = 0; j < srcImage.getHeight(); j++) {
                    rgb = srcImage.getRGB(i, j);
                    R = ((rgb >> 16) & 0xff) + param;
                    G = ((rgb >> 8) & 0xff) + param;
                    B = (rgb & 0xff) + param;
                    rgb = ((clamp(255) & 0xff) << 24) | ((clamp(R) & 0xff) << 16) | ((clamp(G) & 0xff) << 8)
                            | ((clamp(B) & 0xff));
                    srcImage.setRGB(i, j, rgb);
                }
            }
        }
    }

    /**
     *  图像一阶梯度锐化所需
     * @param list
     * @return
     */
    private static int getResult(List<Integer> list){
        int result = Math.abs(list.get(0) + list.get(3) + list.get(6) - list.get(2) - list.get(5) - list.get(8))
                + Math.abs(list.get(0) + list.get(1) + list.get(2) - list.get(6) - list.get(7) - list.get(8));
        return result;
    }
    /**
     * 颜色分量转换为RGB值,灰度化用加权平均值时所用
     * @param alpha alpha通道，透明度
     * @param red R
     * @param green G
     * @param blue B
     * @return
     */
    private static int colorToRGB(int alpha, int red, int green, int blue) {
        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red;
        newPixel = newPixel << 8;
        newPixel += green;
        newPixel = newPixel << 8;
        newPixel += blue;

        return newPixel;
    }
    // 判断a,r,g,b值，大于256返回256，小于0则返回0,0到256之间则直接返回原始值

    /**
     * 判断a,r,g,b值，大于255返回255，小于0则返回0,0到255之间则直接返回原始值
     * 在调亮度，
     * @param rgb
     * @return
     */
    private static int clamp(int rgb) {
        if (rgb > 255)
            return 255;
        if (rgb < 0)
            return 0;
        return rgb;
    }
}