package com.sodse.trade.qiniuyun;

import com.qiniu.http.Response;
import com.sodse.trade.common.lang.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/qiniu")
public class QiniuController {

    @Autowired
    private QiniuService qiniuService;



    /**
     * 以流的形式上传图片
     *
     * @param file
     * @return 返回访问路径
     * @throws IOException
     */
    @PostMapping("/upload")
    public Result uploadFile(@Validated @RequestBody MultipartFile file) throws IOException {
//        System.out.println("执行");
         String[] urls=qiniuService.uploadFile(file.getInputStream()).split("/");
         String url="http://images.sodse.com/"+urls[1];
        return Result.succ(url);
    }

    /**
     * 删除文件
     *
     * @param key
     * @return
     * @throws IOException
     */
    @GetMapping("delete/{key}")
    public Response deleteFile(@PathVariable String key) throws IOException {
        return qiniuService.delete(key);
    }
}
