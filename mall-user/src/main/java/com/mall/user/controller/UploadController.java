package com.mall.user.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.mall.common.config.OssConfig;
import com.mall.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/**
 * @author 李青龙
 * @date 2025/04/05 14:49
 * 功能描述:
 */
@Slf4j
@RequestMapping("/users/image")
@RestController
public class UploadController {

    private final OSS ossClient;
    private final String bucketName;
    private final String endpoint;

    public UploadController(OssConfig ossConfig) {
        this.ossClient = ossConfig.ossClient();
        this.bucketName = ossConfig.getBucketName();
        this.endpoint = ossConfig.getEndpoint();
    }

    @PostMapping("/uploadUserImg")
    public Result<String> uploadUserImg(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "oldimg", required = false) String oldimg) {

        try {
            if (file.isEmpty()) {
                return Result.error("上传文件不能为空");
            }

            String originalFilename = file.getOriginalFilename();
            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = new Date().getTime() + fileExtension;

            // 删除旧图片
            if (oldimg != null && !oldimg.isEmpty()) {
                String objectKey = oldimg.substring(oldimg.lastIndexOf("/") + 1);
                if (!objectKey.isEmpty() && !objectKey.startsWith("/") && !objectKey.startsWith("\\")) {
                    ossClient.deleteObject(bucketName, objectKey);
                }
            }

            // 上传新文件
            ossClient.putObject(bucketName, newFileName, file.getInputStream());

            // 修正URL生成方式 - 使用endpoint直接拼接
            String url = "https://" + bucketName + "." + endpoint + "/" + newFileName;

            return Result.success(url);
        } catch (IOException e) {
            log.error("文件上传失败", e);
            return Result.error("上传失败: " + e.getMessage());
        } catch (Exception e) {
            log.error("系统异常", e);
            return Result.error("系统异常: " + e.getMessage());
        }
    }
}