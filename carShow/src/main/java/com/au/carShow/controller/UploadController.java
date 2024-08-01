package com.au.carShow.controller;

import com.au.carShow.common.entity.ResponseDto;
import com.au.carShow.common.entity.dto.BaseDto;
import com.au.carShow.common.entity.request.ImageUploadRequest;
import com.au.carShow.services.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("upload/")
public class UploadController {

    private final UploadService uploadService;

    @PostMapping("image")
    public ResponseDto<BaseDto> uploadImage(@RequestBody ImageUploadRequest request){
        return uploadService.uploadImage(request);
    }



}
