package com.cqupt.bcirs.service.Impl;

import com.cqupt.bcirs.dao.CardDao;
import com.cqupt.bcirs.domain.Card;
import com.cqupt.bcirs.domain.Picture;
import com.cqupt.bcirs.service.RecognizeService;
import com.cqupt.bcirs.service.Status;
import com.cqupt.bcirs.utils.JudgeBank;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

import static com.cqupt.bcirs.controller.UploadController.UPLOAD_DIRECTORY;

/**
 * @author ggtms
 * @ 2020-04-16 11:49
 */
@Service("recognizeService")
public class RcognizeServiceImpl implements RecognizeService {

    @Autowired
    private CardDao cardDao;

    public Card card = new Card();

    @Override
    public Card findAll() {
        System.out.println("spring、springmvc整合后的service层没问题");
        //Card all = cardDao.findAll();
        return cardDao.findAl();           //调用CardDao中的findAll
    }

    @Override
    public List<Card> findAllList() {
         return cardDao.findAllList();
    }

    @Override
    public void recognizeImage(String srcPath) {
        System.out.println("开始识别");
        //File imageFile = new File("D:\\workspace_ideal\\BirsWeb\\src\\temp\\origin\\10 .jpg");
        //File imageFile = new File(UPLOAD_DIRECTORY + File.separator+ imagePath);
        //File imageFile = new File(srcPath);
        // 识别图片的路径（修改为自己的图片路径）
        //String path = "D:\\workspace_ideal\\BirsWeb\\src\\temp\\test0.jpg";       //暂时用静态path代替上传的文件经过图像处理后的路径

        // 语言库位置（修改为跟自己语言库文件夹的路径）
        String lagnguagePath = "D:\\tessdata";

        File file = new File(srcPath);
        ITesseract instance = new Tesseract();

        //设置训练库的位置
        instance.setDatapath(lagnguagePath);

        //chi_sim ：简体中文， eng    根据需求选择语言库
        instance.setLanguage("zdyI");         //使用英文字库
        String result = null;
        try {
            long startTime = System.currentTimeMillis();
            result = instance.doOCR(file);
            long endTime = System.currentTimeMillis();
            System.out.println("Time is：" + (endTime - startTime) + " 毫秒");
        } catch (TesseractException e) {
            e.printStackTrace();
        }

//        System.out.println("result: ");
//        System.out.println(result);
        //处理识别出的字符串，去掉其中的空格
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
        System.out.println("主要识别结果：" + sb);
        //将结果传入数据库
        String issuer = JudgeBank.getName(result);             //根据卡号识别卡行
        card.setIssuer(issuer);
        card.setAccount(result);
        card.setDate("2012-04");
        card.setStatu(Status.INVALID);
        cardDao.saveBankCard(card);

        System.out.println("识别结果已存储");
        //return result;
    }
}
