package com.site.blog.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description: 图片上传路径常量
 * @date: 2019/8/24 15:16
 */
@Component
public class UploadConstants {

    // TODO 这里注意路径，本地和prod的区别，只需要在配置文件中配好，linux部署的时候用prod.yml即可，不需要在改动代码
    // 用户头像默认上传路径
    public static String UPLOAD_AUTHOR_IMG = "/myblog/authorImg/";
    // 文章图片默认上传路径
    public static String FILE_UPLOAD_DIC = "/myblog/articleImg/";
    // 用户头像数据库路径
    public static String SQL_AUTHOR_IMG = "/authorImg/";
    // 文章图片数据库路径
    public static String FILE_SQL_DIC = "/articleImg/";


    @Value("${upload.uploadAuthorImg}")
    public void setUploadAuthorImg(String uploadAuthorImg) {
        UploadConstants.UPLOAD_AUTHOR_IMG = buildSuffix(uploadAuthorImg);
    }

    @Value("${upload.fileUploadDic}")
    public void setFileUploadDic(String fileUploadDic) {
        UploadConstants.FILE_UPLOAD_DIC = buildSuffix(fileUploadDic);
    }

    private String buildSuffix(String path) {
        if (!path.endsWith("/")) {
            path += "/";
        }
        return path;
    }
}
