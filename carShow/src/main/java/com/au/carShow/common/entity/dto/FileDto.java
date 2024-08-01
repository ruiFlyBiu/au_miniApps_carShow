package com.au.carShow.common.entity.dto;

import com.au.carShow.common.enums.FileTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Deprecated
@AllArgsConstructor
public class FileDto {

    private FileTypeEnum fileTypeEnum;

    private String relativeAddress;

}
