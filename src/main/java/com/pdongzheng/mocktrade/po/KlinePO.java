package com.pdongzheng.mocktrade.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsAutoIncrement;
import com.gitee.sunchenbin.mybatis.actable.annotation.Unique;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.pdongzheng.mocktrade.entity.enums.Timeframe;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("kline")
public class KlinePO {
    @TableId(type = IdType.AUTO)
    @IsAutoIncrement
    private Long id;
    @TableField
    private String symbol;
    @Column(type = MySqlTypeConstant.VARCHAR, length = 16)
    @TableField
    private Timeframe timeframe;
    @TableField
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime openTime;

    @TableField
    private Double openPrice;

    @TableField
    private Double highPrice;

    @TableField
    private Double lowPrice;

    @TableField
    private Double closePrice;

    @TableField
    private Double volume;

    @TableField
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime closeTime;

}
