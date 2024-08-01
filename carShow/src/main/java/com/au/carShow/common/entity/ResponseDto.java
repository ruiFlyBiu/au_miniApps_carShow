package com.au.carShow.common.entity;

import com.au.carShow.common.enums.CodeEnum;
import com.au.carShow.common.util.CodeUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseDto<T> {

    private int code;

    private String message;

    private T data;

    private ResponseDto(int code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseDto<T> success(){
        return new ResponseDto<>(CodeEnum.COMMON_SUCCESS.getCode(), CodeEnum.COMMON_SUCCESS.getMessage(), null);
    }

    public static <T> ResponseDto<T> success(T data){
        return new ResponseDto<>(CodeEnum.COMMON_SUCCESS.getCode(), CodeEnum.COMMON_SUCCESS.getMessage(), data);
    }

    public static <T> ResponseDto<T> fail(){
        return new ResponseDto<>(CodeEnum.COMMON_FAIL.getCode(), CodeEnum.COMMON_FAIL.getMessage(), null);
    }

}
