package com.au.carShow.controller;

import com.au.carShow.common.entity.ResponseDto;
import com.au.carShow.common.entity.dto.BaseDto;
import com.au.carShow.common.entity.dto.VehicleMarkViewDto;
import com.au.carShow.services.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("mark")
public class MarkController {

    private final MarkService markService;

    @PostMapping("vehicleByUser")
    public ResponseDto<BaseDto> markVehicleByUser(@PathVariable Long userId, @RequestBody List<Long> vehicleIdList){
        return markService.markVehicleByUser(userId, vehicleIdList);
    }

    @GetMapping("vehicleByUser")
    public ResponseDto<VehicleMarkViewDto> showVehicleMark(@PathVariable Long userId){
        return markService.showVehicleMark(userId);
    }

    @DeleteMapping("vehicleByUser")
    public ResponseDto<BaseDto> cancelVehicleMarkByUser(@PathVariable Long userId, @PathVariable Long vehicleId){
        return markService.cancelVehicleMarkByUser(userId, vehicleId);
    }
}
