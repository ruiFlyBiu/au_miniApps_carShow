package com.au.carShow.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CodeEnum {

    COMMON_SUCCESS(200, "成功"),

    COMMON_FAIL(500, "失败");

    private final int code;

    private final String message;
}
