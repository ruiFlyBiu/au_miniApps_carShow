package com.au.carShow.common.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleModelDto {

    private String vehicleModelName;

    private String vehicleModelUrl;

    public static VehicleModelDto trans2dto(String vehicleModelName, String vehicleModelUrl){
        return VehicleModelDto.builder().vehicleModelName(vehicleModelName)
                .vehicleModelUrl(vehicleModelUrl).build();
    }
}
