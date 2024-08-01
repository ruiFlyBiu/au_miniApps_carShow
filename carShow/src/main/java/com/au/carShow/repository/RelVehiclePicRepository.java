package com.au.carShow.repository;

import com.au.carShow.repository.entity.RelVehiclePic;
import com.au.carShow.repository.mapper.RelVehiclePicMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RelVehiclePicRepository extends ServiceImpl<RelVehiclePicMapper, RelVehiclePic> {
}
