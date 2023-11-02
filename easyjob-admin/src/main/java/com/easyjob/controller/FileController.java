package com.easyjob.controller;

import com.easyjob.annotation.GlobalInterceptor;
import com.easyjob.entity.config.AppConfig;
import com.easyjob.entity.constants.Constants;
import com.easyjob.entity.enums.DateTimePatternEnum;
import com.easyjob.entity.enums.FileUploadTypeEnum;
import com.easyjob.entity.enums.ImportTemplateTypeEnum;
import com.easyjob.entity.enums.ResponseCodeEnum;
import com.easyjob.entity.vo.ResponseVO;
import com.easyjob.exception.BusinessException;
import com.easyjob.utils.DateUtil;
import com.easyjob.utils.ScaleFilter;
import com.easyjob.utils.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.util.UriEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;


/***
 * 文件上传相关
 */
@RestController("fileController")
@RequestMapping("/file")
public class FileController extends ABaseController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Resource
    private AppConfig appConfig;

    @RequestMapping("uploadFile")
    @GlobalInterceptor
    public ResponseVO uploadFile(MultipartFile file, Integer type) {
        FileUploadTypeEnum uploadTypeEnum = FileUploadTypeEnum.getType(type);
        String month = DateUtil.format(new Date(), DateTimePatternEnum.YYYYMM.getPattern());
        String folderName = appConfig.getProjectFolder() + month; // 上传文件的放置位置
        File folder = new File(folderName);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String fileSuffix = StringTools.getFileSuffix(file.getOriginalFilename());
        String realFileName = StringTools.getRandomString(Constants.LENGTH_30) + fileSuffix;
        String realFilePath = month + "/" + realFileName;
        File localFile = new File(appConfig.getProjectFolder() + realFilePath);
        try {
            file.transferTo(localFile);
            // 裁剪图片
            if (uploadTypeEnum != null) {
                ScaleFilter.createThumbnail(localFile, uploadTypeEnum.getMaxWidth(), uploadTypeEnum.getMaxWidth(), localFile);
            }
        } catch (IOException e) {
            logger.error("文件上传失败", e);
            throw new BusinessException("文件上传失败");
        }
        return getSuccessResponseVO(realFilePath);
    }

    /***
     * 读取图片
     */
    @RequestMapping("/getImage/{imageFolder}/{imageName}")
    @GlobalInterceptor
    public void getImage(HttpServletResponse response,
                         @PathVariable("imageFolder") String imageFolder,
                         @PathVariable("imageName") String imageName) {
        readImage(response, imageFolder, imageName);
    }

    private void readImage(HttpServletResponse response, String imageFolder, String imageName) {
        if (StringTools.isEmpty(imageFolder) || StringUtils.isBlank(imageName)) {
            return;
        }
        String imageSuffix = StringTools.getFileSuffix(imageName);
        String filePath = appConfig.getProjectFolder() + imageFolder + "/" + imageName;
        imageSuffix = imageSuffix.replace(".", "");
        String contentType = "image/" + imageSuffix;
        response.setContentType(contentType);
        response.setHeader("Cache-Control", "max-age=2592000");
        readFile(response, filePath);
    }

    protected void readFile(HttpServletResponse response, String filepath) {
        if (!StringTools.pathIsOk(filepath)) {
            return;
        }
        OutputStream out = null;
        FileInputStream in = null;
        try {
            File file = new File(filepath);
            if (!file.exists()) {
                return;
            }
            in = new FileInputStream(file);
            byte[] byteData = new byte[1024];
            out = response.getOutputStream();
            int len = 0;
            while ((len = in.read(byteData)) != -1) {
                out.write(byteData, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            logger.error("文件读取异常", e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error("IO异常");
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("IO异常");
                }
            }
        }
    }

    /***
     * 下载模板
     */
    @RequestMapping("/downloadTemplate")
    public void downloadTemplate(HttpServletResponse response, HttpServletRequest request, Integer type) {
        ImportTemplateTypeEnum templateTypeEnum = ImportTemplateTypeEnum.getByType(type);
        if (null == templateTypeEnum) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }
        OutputStream out = null;
        InputStream in = null;
        try {
            String fileName = templateTypeEnum.getTemplateName();
            response.setContentType("application/x-msdownload; charset=UTF-8");
            if (request.getHeader("User-Agent").toLowerCase().indexOf("msie") > 0) { // ie浏览器
                fileName = URLEncoder.encode(fileName, "UTF-8");
            } else {
                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
            }
            response.setHeader("Content-Dispostion", "attachment;filename=\"" + fileName + "\"");
            // 读取文件
            ClassPathResource classPathResource = new ClassPathResource(templateTypeEnum.getTemplatePath());
            in = classPathResource.getInputStream();
            byte[] byteData = new byte[1024];
            out = response.getOutputStream();
            int len = 0;
            while ((len = in.read(byteData)) != -1) {
                out.write(byteData, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            logger.error("读取文件异常", e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error("IO异常");
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("IO异常");
                }
            }
        }
    }
}
