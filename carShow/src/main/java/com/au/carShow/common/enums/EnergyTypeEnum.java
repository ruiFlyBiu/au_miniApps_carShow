package com.au.carShow.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnergyTypeEnum {

    OIL("OIL", "油"),

    ELECTRIC("ELECTRIC", "电"),

    HYBRID("HYBRID", "混动")
    ;


    private final String energyType;

    private final String des;


}
