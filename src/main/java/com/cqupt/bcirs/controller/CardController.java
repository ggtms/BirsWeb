package com.cqupt.bcirs.controller;

import com.alibaba.fastjson.JSONObject;
import com.cqupt.bcirs.domain.Card;
import com.cqupt.bcirs.service.DealService;
import com.cqupt.bcirs.service.RecognizeService;
import com.cqupt.bcirs.utils.ReadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ggtms
 * @ 2020-04-14 14:08
 */
@Controller
public class CardController {

   // int p = Picture.getPicture().getId();
    public void outTest(){           //与service接口中的方法无关
        System.out.println("Controller层没问题！");
    }

    @Autowired         //按类型注入，将DealService层的操作装配到dealService里
    private DealService dealService;

    @Autowired
    private RecognizeService recognizeService;


    @RequestMapping("/getRecognizeResult")
    @ResponseBody
    public String recognizeResult(){

        List<File> files = ReadFile.readFile("D:\\workspace_ideal\\BirsWeb\\src\\temp");
        //遍历
        for (int i = 0; i < files.size(); i++) {

            try {
                dealService.dealProcess(files.get(i).toString());     //处理
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                recognizeService.recognizeImage(files.get(i).toString());   //识别
            } catch (Exception e) {
                e.printStackTrace();
            }
            //files.get(i).delete();         //虽然删掉了图像地址，但识别结果已经存储到数据库中
        }

        //创建准备数据传输的Json对象
        JSONObject json = new JSONObject();
        List<JSONObject> newList= new ArrayList<>();
        List<Card> list = recognizeService.findAllList();               //从数据库里获取信息
        for (int i = 0; i < list.size(); i++) {

            //获取表中的第一个识别对象
            Card card = list.get(i);
            System.out.println(card.toString());
            //将取得的card转成JSON格式的数据并放入JSON对象中
            json.put("card" + i,JSONObject.toJSON(card));                 //JSON的存储格式是键值对（Map）
            System.out.println(json.get("card" + i));
            System.out.println(json.get("card" + i).toString());
            System.out.println();
            //返回前端页面所要显示的数据
            //从数据库中删除card对象
            newList.add(json);
        }
        //System.out.println(json.toJSONString());

        return json.toJSONString();

        /*JSONObject json = new JSONObject();

        List<Card> list = recognizeService.findAllList();
        for (int i = 0; i < list.size(); i++) {

            //获取表中的第一个识别对象
            Card card = list.get(i);
            System.out.println(card.toString());
            //将取得的card转成JSON格式的数据并放入JSON对象中
            json.put("card" + i,JSONObject.toJSON(card));                 //JSON的存储格式是键值对（Map）
            System.out.println(json.toJSONString());
            //返回前端页面所要显示的数据
            //从数据库中删除card对象
            dealService.deleteCard(card.getNumber());
        }
        System.out.println("从表中清除成功！");
        return json.toJSONString();*/
    }


    @RequestMapping("/card/save")
    public void save(Card card, HttpServletRequest request, HttpServletResponse response) throws IOException {
        dealService.saveCard(card);
        response.sendRedirect(request.getContextPath()+"/card/outDisplayTest");
        return;
    }

    @RequestMapping("/delete")
    public void delete(){
        //从数据库中删除card对象
        dealService.deleteCard();
        System.out.println("从表中清除成功！");
        //从磁盘中删除图像
        List<File> files = ReadFile.readFile("D:\\workspace_ideal\\BirsWeb\\src\\temp");
        //遍历
        for (int i = 0; i < files.size(); i++) {
            files.get(i).delete();         //从物理存储上删出处理后的图像
        }
    }


}
