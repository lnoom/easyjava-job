package com.easyjob.entity.enums;

public enum PostStatusEnum {
    NO_POST(0, "待发布"),
    POST(1, "已发布");


    private Integer status;
    private String description;

    PostStatusEnum(Integer status, String description) {
        this.status = status;
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public static PostStatusEnum getByStatus(Integer status) {
        for (PostStatusEnum at : PostStatusEnum.values()) {
            if (at.status.equals(status)) {
                return at;
            }
        }
        return null;
    }
}
