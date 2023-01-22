package com.pdongzheng.mocktrade.po;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsAutoIncrement;
import com.gitee.sunchenbin.mybatis.actable.annotation.Unique;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.pdongzheng.mocktrade.entity.enums.Timeframe;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("symbol")
public class SymbolPO {
    @TableId(type = IdType.AUTO)
    @IsAutoIncrement
    private Long id;
    @TableField
    @Unique
    private String symbol;
    @Column(type = MySqlTypeConstant.VARCHAR, length = 16)
    @TableField
    private Timeframe timeframe;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField
    private LocalDateTime sinceTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
