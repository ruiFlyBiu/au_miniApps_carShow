package com.au.carShow.services;

import com.au.carShow.common.entity.ResponseDto;
import com.au.carShow.common.entity.VehicleParam;
import com.au.carShow.common.entity.dto.BaseDto;
import com.au.carShow.common.entity.request.ImageUploadRequest;
import com.au.carShow.repository.PictureRepository;
import com.au.carShow.repository.RelVehiclePicRepository;
import com.au.carShow.repository.entity.Picture;
import com.au.carShow.repository.entity.RelVehiclePic;
import com.au.carShow.repository.entity.Vehicle;
import com.au.carShow.repository.mapper.PictureMapper;
import com.au.carShow.repository.mapper.RelVehiclePicMapper;
import com.au.carShow.repository.mapper.VehicleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UploadService {

    private final VehicleMapper vehicleMapper;

    private final PictureMapper pictureMapper;

    private final PictureRepository pictureRepository;

    private final RelVehiclePicMapper relVehiclePicMapper;

    private final RelVehiclePicRepository relVehiclePicRepository;

    public ResponseDto<BaseDto> uploadImage(ImageUploadRequest request){
        try{
            switch (request.getUploadType()){
                case IMAGE_VEHICLE_MAKE :
                    // 新增品牌记录
                    Vehicle vehicleMake = new Vehicle();
                    vehicleMake.setVehicleMake(request.getVehicleMakeName());
                    vehicleMake.setTag(1); // 车牌
                    Long vehicleMakeId = (long) vehicleMapper.insert(vehicleMake);
                    // 存放图片记录
                    Picture vehicleMakePic = Picture.add4VehicleMakePic(request.getImageUrlList());
                    Long picId = (long) pictureMapper.insert(vehicleMakePic);
                    // 存放品牌图片关联
                    RelVehiclePic relVehicleMakePic = RelVehiclePic.trans2RelVehiclePic(vehicleMakeId, picId);
                    relVehiclePicMapper.insert(relVehicleMakePic);
                    break;
                case IMAGE_VEHICLE_MODEL:
                    // 新增车型记录
                    Vehicle vehicleModel = new Vehicle();
                    vehicleModel.setVehicleModel(request.getVehicleModelName());
                    vehicleModel.setTag(2); // 车牌
                    Long vehicleModelId = (long) vehicleMapper.insert(vehicleModel);
                    // 存放图片记录
                    Picture vehicleModelPic = Picture.add4VehicleMakePic(request.getImageUrlList());
                    Long vehicleModelPicId = (long) pictureMapper.insert(vehicleModelPic);
                    // 存放品牌图片关联
                    RelVehiclePic relVehicleModelPic = RelVehiclePic.trans2RelVehiclePic(vehicleModelId, vehicleModelPicId);
                    relVehiclePicMapper.insert(relVehicleModelPic);
                    break;
                case IMAGE_VEHICLE:
                    // 新增车辆记录
                    VehicleParam vehicleParam = request.getVehicleParam();
                    Vehicle vehicle = Vehicle.trans2Vehicle(vehicleParam);
                    Long vehicleId = (long) vehicleMapper.insert(vehicle);
                    // 存放图片记录
                    List<Picture> vehiclePicList = Picture.add4VehiclePic(request.getImageUrlList());
                    pictureRepository.saveBatch(vehiclePicList);
                    // 存放车辆图片关联
                    List<RelVehiclePic> relVehiclePicList = new ArrayList<>();
                    vehiclePicList.forEach(picture -> {
                        relVehiclePicList.add(RelVehiclePic.trans2RelVehiclePic(vehicleId, picture.getId()));
                    });
                    relVehiclePicRepository.saveBatch(relVehiclePicList);

            }
        }catch (Exception e){
            log.error("上传图片失败:", e);
            return ResponseDto.fail();
        }
        return ResponseDto.success();
    }
}
