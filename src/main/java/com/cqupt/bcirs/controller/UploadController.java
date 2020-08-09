package com.cqupt.bcirs.controller;

import com.cqupt.bcirs.domain.Picture;
import com.cqupt.bcirs.service.DealService;
import com.cqupt.bcirs.service.RecognizeService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author ggtms
 * @ 2020-04-14 22:55
 */
@Controller
public class UploadController{
    private static final long SerialVersionUID = 1L;

    //上传文件目录
    public static final String UPLOAD_DIRECTORY = "D:\\workspace_ideal\\BirsWeb\\src\\temp";
    //private static final String UPLOAD_DIRECTORY = "D:\\workspace_ideal\\BirsWeb\\src\\temp";

    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB


    @RequestMapping("/Upload")                       //当点击图片上传时会执行此函数
    public void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws  IOException {

        String filePath = "";


        //为此次上传的文件创建一个对象(单例对象)
        //Picture picture = new Picture();           //声明对象
        //picture = Picture.getPicture();   //取得实例化对象

        // 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止

            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }

        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文处理
        upload.setHeaderEncoding("UTF-8");

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        //String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
        String uploadPath =  UPLOAD_DIRECTORY;


        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();      //所上传文件的文件名
                        filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        //picture.setPath(filePath);
                        //System.out.println("picture对象中的地址为:"+picture.getPath());
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        request.setAttribute("message",
                                "文件上传成功!");
                        System.out.println("文件上传成功!");
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "错误信息: " + ex.getMessage());
        }
        //处理
        /*try {
            dealService.dealProcess(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //识别
        try {
            recognizeService.recognizeImage(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        // 跳转到 message.jsp
        /*request.getServletContext().getRequestDispatcher("/message.jsp").forward(
                request, response);*/
    }
}
