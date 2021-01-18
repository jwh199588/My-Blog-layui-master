package com.site.blog.controller.file;

import com.site.blog.constants.HttpStatusEnum;
import com.site.blog.constants.SysConfigConstants;
import com.site.blog.constants.UploadConstants;
import com.site.blog.entity.BlogConfig;
import com.site.blog.pojo.dto.Result;
import com.site.blog.service.BlogConfigService;
import com.site.blog.util.ResultGenerator;
import com.site.blog.util.UploadFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class ImageFile {

    @Autowired
    private BlogConfigService blogConfigService;


    /**
     * @Description: 用户头像上传
     * @Param: [httpServletRequest, file]
     * @return: com.zhulin.blog.util.Result
     * @date: 2019/8/24 15:15
     */
    @PostMapping({"/upload/authorImg"})
    @ResponseBody
    public Result<String> upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws URISyntaxException {
        String suffixName = UploadFileUtils.getSuffixName(file);

        String filePath = UploadConstants.UPLOAD_AUTHOR_IMG + convertTime();
        String sqlFilePath = UploadConstants.SQL_AUTHOR_IMG + convertTime();

        //生成文件名称通用方法
        String newFileName = UploadFileUtils.getNewFileName(suffixName);
        File fileDirectory = new File(filePath);
        //创建文件
        File destFile = new File(filePath + newFileName);
        try {
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdirs()) {
                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                }
            }
            file.transferTo(destFile);
            String sysAuthorImg = sqlFilePath + newFileName;
            BlogConfig blogConfig = new BlogConfig()
                    .setConfigField(SysConfigConstants.SYS_AUTHOR_IMG.getConfigField())
                    .setConfigValue(sysAuthorImg);
            blogConfigService.updateById(blogConfig);
            return ResultGenerator.getResultByHttp(HttpStatusEnum.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.getResultByHttp(HttpStatusEnum.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 保存文章图片
     *
     * @param request
     * @param file
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @date 2019/8/26 13:57
     */
    @ResponseBody
    @PostMapping("/v1/blog/uploadFile")
    public Map<String, Object> uploadFileByEditormd(HttpServletRequest request,
                                                    @RequestParam(name = "editormd-image-file") MultipartFile file) throws URISyntaxException {
        String suffixName = UploadFileUtils.getSuffixName(file);

        String filePath = UploadConstants.FILE_UPLOAD_DIC + convertTime();
        String sqlFilePath = UploadConstants.FILE_SQL_DIC + convertTime();


        //生成文件名称通用方法
        String newFileName = UploadFileUtils.getNewFileName(suffixName);
        File fileDirectory = new File(filePath);
        //创建文件
        File destFile = new File(filePath + newFileName);
        Map<String, Object> result = new HashMap<>();
        try {
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdirs()) {
                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                }
            }
            file.transferTo(destFile);
            String fileUrl = sqlFilePath + newFileName;
            result.put("success", 1);
            result.put("message", "上传成功");
            result.put("url", fileUrl);
        } catch (IOException e) {
            result.put("success", 0);
        }
        return result;
    }

    private String convertTime() {
        Date time = new Date();
        return new SimpleDateFormat("yyyyMMdd").format(time) + "/";
    }
}
