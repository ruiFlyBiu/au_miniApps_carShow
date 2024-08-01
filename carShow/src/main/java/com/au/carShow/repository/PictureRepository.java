package com.au.carShow.repository;

import com.au.carShow.repository.entity.Picture;
import com.au.carShow.repository.mapper.PictureMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PictureRepository extends ServiceImpl<PictureMapper, Picture> {


}
