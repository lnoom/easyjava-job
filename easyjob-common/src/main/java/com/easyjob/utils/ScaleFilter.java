package com.easyjob.utils;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigDecimal;

public class ScaleFilter {
    private static final Logger logger = LoggerFactory.getLogger(ScaleFilter.class);

    public static Boolean createThumbnail(File file, int thumbnailWidth, int thumbnailHeight, File targetFile) {
        try {
            BufferedImage src = ImageIO.read(file);
            //thumbnailWidth 缩略图的宽度   thumbnailHeight 缩略图的高度
            int sorceW = src.getWidth();
            int sorceH = src.getHeight();
            //小于 指定高宽不压缩
            if (sorceW <= thumbnailWidth) {
                return false;
            }
            int height = sorceH; // 目标文件的高度
            if (sorceW > thumbnailWidth) { // 目标文件宽度大于指定宽度
                height = thumbnailWidth * sorceH / sorceW;
            } else {// 目标文件宽度小于指定宽度 那么缩略图大小就跟原图一样大
                thumbnailWidth = sorceW;
                height = sorceH;
            }
            // 生成宽度为150的缩略图
            BufferedImage dst = new BufferedImage(thumbnailWidth, height, BufferedImage.TYPE_INT_RGB);
            Image scaleImage = src.getScaledInstance(thumbnailWidth, height, Image.SCALE_SMOOTH);
            Graphics2D g = dst.createGraphics();
            g.drawImage(scaleImage, 0, 0, thumbnailWidth, height, null);
            g.dispose();

            int resultH = dst.getHeight();
            // 高度过大的，裁剪图片
            if (resultH > thumbnailHeight) {
                resultH = thumbnailHeight;
                dst = dst.getSubimage(0, 0, thumbnailWidth, resultH);
            }
            ImageIO.write(dst, "JPEG", targetFile);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//    public static Boolean createThumbnailWidthFFmpeg(File file, int thumbnailWidth, File targetFile, Boolean delSource) {
//        try {
//            BufferedImage src = ImageIO.read(file);
//            //thumbnailWidth 缩略图的宽度   thumbnailHeight 缩略图的高度
//            int sorceW = src.getWidth();
//            int sorceH = src.getHeight();
//            //小于 指定高宽不压缩
//            if (sorceW <= thumbnailWidth) {
//                return false;
//            }
//            compressImage(file, thumbnailWidth, targetFile, delSource);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public static void compressImageWidthPercentage(File sourceFile, BigDecimal widthPercentage, File targetFile) {
//        try {
//            BigDecimal widthResult = widthPercentage.multiply(new BigDecimal(ImageIO.read(sourceFile).getWidth()));
//            compressImage(sourceFile, widthResult.intValue(), targetFile, true);
//        } catch (Exception e) {
//            logger.error("压缩图片失败");
//        }
//    }

//    public static void compressImage(File sourceFile, Integer width, File targetFile, Boolean delSource) {
//        try {
//            String cmd = "ffmpeg -i %s -vf scale=%d:-1 %s -y";
//            ProcessUtils.executeCommand(String.format(cmd, sourceFile.getAbsoluteFile(), width, targetFile.getAbsoluteFile()), true);
//            if (delSource) {
//                FileUtils.forceDelete(sourceFile);
//            }
//        } catch (Exception e) {
//            logger.error("压缩图片失败");
//        }
//    }

    public static void main(String[] args) {
        createThumbnail(new File("C:\\Users\\Administrator\\Pictures\\微信图片_20230107141436.png"), 400, 200,
                new File("C:\\Users\\Administrator" + "\\Pictures" + "\\微信图片_202106281029182.jpg"));
    }
}