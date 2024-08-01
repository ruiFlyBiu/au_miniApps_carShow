package com.au.carShow.services;

import com.au.carShow.common.entity.ResponseDto;
import com.au.carShow.common.entity.dto.BaseDto;
import com.au.carShow.common.entity.dto.VehicleMarkViewDto;
import com.au.carShow.repository.RelUserMarkRepository;
import com.au.carShow.repository.entity.RelUserMark;
import com.au.carShow.repository.mapper.RelUserMarkMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MarkService {

    private final RelUserMarkRepository relUserMarkRepository;

    public ResponseDto<BaseDto> markVehicleByUser(Long userId, List<Long> vehicleIdList){
        List<RelUserMark> relUserMarkList = new ArrayList<>();
        vehicleIdList.forEach(vehicleId -> {
            RelUserMark relUserMark = RelUserMark.trans2Pojo(userId, vehicleId);
            relUserMarkList.add(relUserMark);
        });
        relUserMarkRepository.saveBatch(relUserMarkList);
        return ResponseDto.success();
    }

    public ResponseDto<VehicleMarkViewDto> showVehicleMark(Long userId){
        List<RelUserMark> relUserMarkList = relUserMarkRepository.list(Wrappers.lambdaQuery(RelUserMark.class).eq(RelUserMark::getUserId, userId));
        List<Long> relUserMarkVehicleIdList = relUserMarkList.stream().map(RelUserMark::getVehicleId).toList();
        VehicleMarkViewDto vehicleMarkViewDto = VehicleMarkViewDto.trans2Dto(relUserMarkVehicleIdList);
        return ResponseDto.success(vehicleMarkViewDto);
    }

    public ResponseDto<BaseDto> cancelVehicleMarkByUser(Long userId, Long vehicleId){
        relUserMarkRepository.remove(Wrappers.lambdaQuery(RelUserMark.class).eq(RelUserMark::getUserId, userId).eq(RelUserMark::getVehicleId, vehicleId));
        return ResponseDto.success();
    }

}
