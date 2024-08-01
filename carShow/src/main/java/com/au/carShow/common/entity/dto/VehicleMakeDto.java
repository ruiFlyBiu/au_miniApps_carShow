package com.au.carShow.common.entity.dto;

import com.au.carShow.repository.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleMakeDto implements BaseDto{

//    private Long id;

    private String vehicleMakeName;

    private String picUrl;

    public static VehicleMakeDto trans2Dto(String vehicleMakeName, String picUrl){
        return VehicleMakeDto.builder().vehicleMakeName(vehicleMakeName)
                .picUrl(picUrl).build();
    }

}
