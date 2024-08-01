package com.au.carShow.repository.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "rel_vehicle_picture", autoResultMap = true)
public class RelVehiclePic {

    @TableId
    private Long id;

    private Long vehicleId;

    private Long picId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public static RelVehiclePic trans2RelVehiclePic(Long vehicleId, Long picId){
        return RelVehiclePic.builder()
                .vehicleId(vehicleId).picId(picId).build();
    }


}
