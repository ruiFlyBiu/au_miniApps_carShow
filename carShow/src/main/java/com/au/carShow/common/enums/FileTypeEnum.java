package com.au.carShow.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 上传文件类型以及对应存储服务器前缀地址
 */
@Getter
@AllArgsConstructor
public enum FileTypeEnum {

    IMAGE_STORAGE("IMAGE", "/image")
    ;

    /**
     * 存储文件类型
     */
    private final String type;

    /**
     * 该类型文件对应存储服务器前缀地址
     */
    private final String prefixAddress;
}
