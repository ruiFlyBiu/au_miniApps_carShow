package com.au.carShow.common.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UploadTypeEnum {

    /**
     * 品牌图片
     */
    IMAGE_VEHICLE_MAKE("IMAGE_VEHICLE_MAKE"),

    /**
     * 车系图片
     */
    IMAGE_VEHICLE_MODEL("IMAGE_VEHICLE_MODEL"),

    /**
     * 车辆图片
     */
    IMAGE_VEHICLE("IMAGE_VEHICLE"),

    /**
     * 头像图片
     */
    IMAGE_AVATAR("AVATAR");



    private final String type;
}
