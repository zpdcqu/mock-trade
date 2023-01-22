package com.pdongzheng.mocktrade.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Timeframe {

    ONE_MIN("1m","1分钟"),
    FIVE_MIN("5m","5分钟"),
    FIFTEEN_MIN("15m","15分钟"),
    THIRTY_MIN("30m","30分钟"),
    ONE_HOUOR("1h","1小时"),
    FOUR_HOUOR("4h","4小时"),
    ONE_DAY("1d","1天");

    @EnumValue
    private final String code;
    @JsonValue
    private final String desc;

}
