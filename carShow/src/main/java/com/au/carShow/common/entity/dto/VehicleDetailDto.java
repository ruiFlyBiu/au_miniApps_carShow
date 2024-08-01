package com.au.carShow.common.entity.dto;

import com.au.carShow.common.enums.EnergyTypeEnum;
import com.au.carShow.repository.entity.Vehicle;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class VehicleDetailDto implements BaseDto{

    private String vehicleMake;

    private String vehicleModel;

    private String vehicleLevel;

    private String color;

    private Long price;

    private EnergyTypeEnum energyType;

    private Integer seatCount;

    private String dataSource;

    private String des;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public static VehicleDetailDto trans2Dto(Vehicle vehicle){
        return VehicleDetailDto.builder().vehicleMake(vehicle.getVehicleMake()).vehicleModel(vehicle.getVehicleModel())
                .vehicleLevel(vehicle.getVehicleLevel()).color(vehicle.getColor()).price(vehicle.getPrice())
                .energyType(vehicle.getEnergyType()).seatCount(vehicle.getSeatCount())
                .dataSource(vehicle.getDataSource()).des(vehicle.getDes())
                .createTime(vehicle.getCreateTime()).updateTime(vehicle.getUpdateTime())
                .build();
    }
}
