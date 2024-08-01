package com.au.carShow.common.entity;

import com.au.carShow.common.enums.EnergyTypeEnum;
import com.au.carShow.repository.entity.Vehicle;
import lombok.Builder;
import lombok.Data;

@Data
public class VehicleParam {

    private String vehicleMake;

    private String vehicleModel;

    private String vehicleLevel;

    private String color;

    private Long price;

    private EnergyTypeEnum energyType;

    private Integer seatCount;

    private String dataSource;

    private String des;

}
