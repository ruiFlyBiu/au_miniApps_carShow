package com.au.carShow.common.entity.request;

import com.au.carShow.common.entity.OSSUploadInfo;
import com.au.carShow.common.entity.VehicleParam;
import com.au.carShow.common.enums.UploadTypeEnum;
import lombok.Data;

import java.util.List;

@Data
public class ImageUploadRequest implements BaseRequest {

    /**
     * 上传图片类型
     */
    private UploadTypeEnum uploadType;

    /**
     * 上传的品牌名
     */
    private String vehicleMakeName;

    /**
     * 上传的车型名
     */
    private String vehicleModelName;

    /**
     * 上传图片列表
     */
    private List<OSSUploadInfo> imageUrlList;

    /**
     * uploadType = "IMAGE_VEHICLE" 时必传
     */
    private VehicleParam vehicleParam;


}
