package com.au.carShow.repository.entity;

import com.au.carShow.common.entity.OSSUploadInfo;
import com.au.carShow.common.enums.UploadTypeEnum;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "tb_picture", autoResultMap = true)
public class Picture {

    @TableId
    private Long id;

    private String pic_name;

    private String pic_url;

    private String base64_data;

    private UploadTypeEnum type;

    private LocalDateTime create_time;

    private LocalDateTime update_time;

    private Integer is_delete;

    public static Picture add4VehicleMakePic(List<OSSUploadInfo> ossUploadInfoList){
        OSSUploadInfo info = ossUploadInfoList.get(0);
        return Picture.builder().pic_name(info.getFileName())
                .pic_url(info.getOssUrl()).type(UploadTypeEnum.IMAGE_VEHICLE_MAKE)
                .create_time(LocalDateTime.now()).update_time(LocalDateTime.now())
                .is_delete(0).build();
    }

    public static Picture add4VehicleModelPic(List<OSSUploadInfo> ossUploadInfoList){
        OSSUploadInfo info = ossUploadInfoList.get(0);
        return Picture.builder().pic_name(info.getFileName())
                .pic_url(info.getOssUrl()).type(UploadTypeEnum.IMAGE_VEHICLE_MODEL)
                .create_time(LocalDateTime.now()).update_time(LocalDateTime.now())
                .is_delete(0).build();
    }


    public static List<Picture> add4VehiclePic(List<OSSUploadInfo> ossUploadInfoList){
        List<Picture> picList = new ArrayList<>();
        ossUploadInfoList.forEach(info -> {
            picList.add(Picture.builder().pic_name(info.getFileName())
                    .pic_url(info.getOssUrl()).type(UploadTypeEnum.IMAGE_VEHICLE)
                    .create_time(LocalDateTime.now()).update_time(LocalDateTime.now())
                    .is_delete(0).build());
        });
        return picList;
    }
}
