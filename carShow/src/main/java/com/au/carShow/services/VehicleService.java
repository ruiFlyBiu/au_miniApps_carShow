package com.au.carShow.services;

import com.au.carShow.common.entity.ResponseDto;
import com.au.carShow.common.entity.dto.VehicleDetailDto;
import com.au.carShow.common.entity.dto.VehicleDto;
import com.au.carShow.common.entity.dto.VehicleMakeDto;
import com.au.carShow.common.entity.dto.VehicleModelDto;
import com.au.carShow.repository.entity.Picture;
import com.au.carShow.repository.entity.RelVehiclePic;
import com.au.carShow.repository.entity.Vehicle;
import com.au.carShow.repository.mapper.PictureMapper;
import com.au.carShow.repository.mapper.RelVehiclePicMapper;
import com.au.carShow.repository.mapper.VehicleMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class VehicleService {

    private final VehicleMapper vehicleMapper;

    private final RelVehiclePicMapper relVehiclePicMapper;

    private final PictureMapper pictureMapper;

    public ResponseDto<List<VehicleMakeDto>> vehicleMakeShow() {
        List<Vehicle> vehicleMakeList = vehicleMapper.selectList(Wrappers.lambdaQuery(Vehicle.class).eq(Vehicle::getTag, 1));
        List<VehicleMakeDto> vehicleMakeDtoList = new ArrayList<>();
        vehicleMakeList.forEach(vehicleMake -> {
            List<RelVehiclePic> relVehiclePicList = relVehiclePicMapper.selectList(Wrappers.lambdaQuery(RelVehiclePic.class).eq(RelVehiclePic::getVehicleId, vehicleMake.getId()));
            RelVehiclePic relVehiclePic = relVehiclePicList.get(0);
            String vehicleMakePicUrl = pictureMapper.selectById(relVehiclePic.getPicId()).getPic_url();
            VehicleMakeDto vehicleMakeDto = VehicleMakeDto.trans2Dto(vehicleMake.getVehicleMake(), vehicleMakePicUrl);
            vehicleMakeDtoList.add(vehicleMakeDto);
        });
        return ResponseDto.success(vehicleMakeDtoList);

    }


    public ResponseDto<List<VehicleModelDto>> vehicleModelShow(String vehicleMakeName) {
        List<Vehicle> vehicleModelList = vehicleMapper.selectList(Wrappers.lambdaQuery(Vehicle.class).eq(Vehicle::getTag, 2).eq(Vehicle::getVehicleModel, vehicleMakeName));
        List<VehicleModelDto> vehicleModelDtoList = new ArrayList<>();
        vehicleModelList.forEach(vehicleModel -> {
            List<RelVehiclePic> relVehiclePicList = relVehiclePicMapper.selectList(Wrappers.lambdaQuery(RelVehiclePic.class).eq(RelVehiclePic::getVehicleId, vehicleModel.getId()));
            RelVehiclePic relVehiclePic = relVehiclePicList.get(0);
            String vehicleModelPicUrl = pictureMapper.selectById(relVehiclePic.getPicId()).getPic_url();
            VehicleModelDto vehicleModelDto = VehicleModelDto.trans2dto(vehicleModel.getVehicleModel(), vehicleModelPicUrl);
            vehicleModelDtoList.add(vehicleModelDto);
        });
        return ResponseDto.success(vehicleModelDtoList);

    }

    public ResponseDto<List<VehicleDto>> vehicleShow(String vehicleMakeName, String vehicleModeName) {
        List<Vehicle> vehicleList = vehicleMapper.selectList(Wrappers.lambdaQuery(Vehicle.class)
                .eq(Vehicle::getTag, 3).eq(Vehicle::getVehicleMake, vehicleMakeName).eq(Vehicle::getVehicleModel, vehicleModeName));
        List<VehicleDto> vehicleDtoList = new ArrayList<>();
        vehicleList.forEach(vehicle -> {
            List<RelVehiclePic> relVehiclePicList = relVehiclePicMapper.selectList(Wrappers.lambdaQuery(RelVehiclePic.class).eq(RelVehiclePic::getVehicleId, vehicle.getId()));
            List<Long> relVehiclePicIdList = relVehiclePicList.stream().map(RelVehiclePic::getPicId).toList();
            List<String> vehiclePicUrlList = pictureMapper.selectList(Wrappers.lambdaQuery(Picture.class).in(Picture::getId, relVehiclePicIdList))
                    .stream().map(Picture::getPic_url).toList();
            VehicleDto vehicleDto = VehicleDto.trans2Dto(vehicle.getId(), vehiclePicUrlList);
            vehicleDtoList.add(vehicleDto);
        });
        return ResponseDto.success(vehicleDtoList);

    }

    public ResponseDto<VehicleDetailDto> vehicleDetailShow(Long vehicleId){
        Vehicle vehicle = vehicleMapper.selectById(vehicleId);
        VehicleDetailDto vehicleDetailDto = VehicleDetailDto.trans2Dto(vehicle);
        return ResponseDto.success(vehicleDetailDto);
    }
}
