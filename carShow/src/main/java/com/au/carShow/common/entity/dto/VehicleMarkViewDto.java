package com.au.carShow.common.entity.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VehicleMarkViewDto implements BaseDto{

    private List<Long> vehicleIdList;

    public static VehicleMarkViewDto trans2Dto(List<Long> vehicleIdList){
        return VehicleMarkViewDto.builder().vehicleIdList(vehicleIdList).build();
    }


}
