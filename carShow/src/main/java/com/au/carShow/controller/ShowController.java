package com.au.carShow.controller;

import com.au.carShow.common.entity.ResponseDto;
import com.au.carShow.common.entity.dto.VehicleDetailDto;
import com.au.carShow.common.entity.dto.VehicleDto;
import com.au.carShow.common.entity.dto.VehicleMakeDto;
import com.au.carShow.common.entity.dto.VehicleModelDto;
import com.au.carShow.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("show/")
public class ShowController {


    private final VehicleService vehicleService;
    /**
     * 展示品牌
     */
    @GetMapping("vehicleMakeShow")
    public ResponseDto<List<VehicleMakeDto>> vehicleMakeShow(){
        return vehicleService.vehicleMakeShow();
    }

    @GetMapping("vehicleModelShow")
    public ResponseDto<List<VehicleModelDto>> vehicleModelShow(@PathVariable String vehicleMakeName){
        return vehicleService.vehicleModelShow(vehicleMakeName);
    }

    @GetMapping("VehicleShow")
    public ResponseDto<List<VehicleDto>> vehicleShow(@PathVariable String vehicleMakeName, @PathVariable String vehicleModelName){
        return vehicleService.vehicleShow(vehicleMakeName, vehicleModelName);
    }

    @GetMapping("vehicleDetailShow")
    public ResponseDto<VehicleDetailDto> vehicleDetailShow(@PathVariable Long vehicleId){
        return vehicleService.vehicleDetailShow(vehicleId);
    }
}
