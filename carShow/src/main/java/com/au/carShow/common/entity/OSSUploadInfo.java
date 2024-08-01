package com.au.carShow.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OSSUploadInfo {

    /**
     * oss 服务器文件地址
     */
    private String ossUrl;

    /**
     * 文件名称
     */
    private String fileName;
}
