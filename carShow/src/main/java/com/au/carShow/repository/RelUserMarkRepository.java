package com.au.carShow.repository;

import com.au.carShow.repository.entity.RelUserMark;
import com.au.carShow.repository.mapper.RelUserMarkMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

@Repository
public class RelUserMarkRepository extends ServiceImpl<RelUserMarkMapper, RelUserMark> {
}
