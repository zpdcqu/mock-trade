package com.pdongzheng.mocktrade.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("account")
public class AccountPO {

    @TableId
    private Long id;

    private String name;

    private Long balance;

    private String desc;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
