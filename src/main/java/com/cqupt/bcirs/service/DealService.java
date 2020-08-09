package com.cqupt.bcirs.service;

import com.cqupt.bcirs.domain.Card;
import com.cqupt.bcirs.domain.Picture;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * @author ggtms
 * @ 2020-04-14 11:10
 */

public interface DealService {

    //测试
    void outTest();

    //返回图像路径
    String getImagePath();

    //存储已识别的银行卡信息
    void saveCard(Card card);

    //去除已识别的图像信息
    //void deleteCard(int number);
    void deleteCard();

    //图像处理细节
    void dealProcess(String path) throws Exception;

}
