package com.au.carShow.repository.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@TableName(autoResultMap = true, value = "rel_user_mark")
public class RelUserMark {

    @TableId
    private Long id;

    private Long userId;

    private Long vehicleId;

    private LocalDateTime createTime;

    public static RelUserMark trans2Pojo(Long userId, Long vehicleId){
        return RelUserMark.builder().userId(userId)
                .vehicleId(vehicleId).createTime(LocalDateTime.now()).build();
    }



}
