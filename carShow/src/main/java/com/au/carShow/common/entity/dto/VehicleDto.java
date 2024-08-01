package com.au.carShow.common.entity.dto;

import com.au.carShow.repository.entity.Vehicle;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VehicleDto implements BaseDto{

    private Long vehicleId;

    private List<String> vehiclePicList;

    public static VehicleDto trans2Dto(Long vehicleId, List<String> vehiclePicList){
        return VehicleDto.builder()
                .vehicleId(vehicleId).vehiclePicList(vehiclePicList).build();
    }

}
