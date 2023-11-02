package com.easyjob.entity.enums;

import com.easyjob.entity.constants.Constants;

public enum FileUploadTypeEnum {
    CATEGORY(0, 150, "分类图片"),
    Carousel(1, 400, "轮播图"),
    SHARE_LARGE(2, 400, "分享大图"),
    SHARE_SMALL(2, 400, "分享小图");


    private Integer type;
    private Integer maxWidth;
    private String descripton;

    FileUploadTypeEnum(Integer type, Integer maxWidth, String descripton) {
        this.type = type;
        this.maxWidth = maxWidth;
        this.descripton = descripton;
    }

    public Integer getType() {
        return type;
    }

    public Integer getMaxWidth() {
        return maxWidth;
    }

    public String getDescripton() {
        return descripton;
    }

    public static FileUploadTypeEnum getType(Integer type) {
        for (FileUploadTypeEnum at : FileUploadTypeEnum.values()) {
            if (at.type.equals(type)) {
                return at;
            }
        }
        return null;
    }
}
