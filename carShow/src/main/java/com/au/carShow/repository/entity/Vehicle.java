package com.au.carShow.repository.entity;

import com.au.carShow.common.entity.VehicleParam;
import com.au.carShow.common.enums.EnergyTypeEnum;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_vehicle", autoResultMap = true)
public class Vehicle {

    @TableId
    private Long id;

    private String vehicleMake;

    private String vehicleModel;

    private String vehicleLevel;

    private String color;

    private Long price;

    private Integer old;

    private EnergyTypeEnum energyType;

    private Integer seatCount;

    private String dataSource;

    private String des;

    private Long hot;

    /**
     * 1：品牌，2：车系，3：车辆
     */
    private Integer tag;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public static Vehicle trans2Vehicle(VehicleParam vehicleParam){
        return Vehicle.builder().vehicleMake(vehicleParam.getVehicleMake())
                .vehicleModel(vehicleParam.getVehicleModel()).vehicleLevel(vehicleParam.getVehicleLevel())
                .color(vehicleParam.getColor()).price(vehicleParam.getPrice())
                .energyType(vehicleParam.getEnergyType()).seatCount(vehicleParam.getSeatCount())
                .dataSource(vehicleParam.getDataSource()).des(vehicleParam.getDes()).tag(3)
                .build();
    }
}
