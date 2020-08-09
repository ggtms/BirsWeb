package com.cqupt.bcirs.service;

import com.cqupt.bcirs.domain.Card;
import com.cqupt.bcirs.domain.Picture;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * @author ggtms
 * @ 2020-04-16 11:49
 */

@Service("recognizeService")                 //关系到在Controller层中的自动导包的错误问题，即将此Service放到容器中
public interface RecognizeService {

    //图像识别
    //String recognizeImage(String iamgePath) throws Exception;
    void recognizeImage(String path) throws Exception;

      //查询数据库中所有银行卡的信息
    Card findAll();

    List<Card> findAllList();
}
