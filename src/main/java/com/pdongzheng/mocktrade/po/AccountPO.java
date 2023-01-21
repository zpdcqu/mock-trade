package com.pdongzheng.mocktrade.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlEngineConstant;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(value = "account", comment = "账户",isSimple = true)
@TableCharset(MySqlCharsetConstant.UTF8)
@TableEngine(MySqlEngineConstant.InnoDB)
public class AccountPO {

    @IsKey
    @IsAutoIncrement
    private Long id;
    @Column
    private String name;
    @Column
    private Long balance;
    @Column
    private String desc;
    @Column
    private LocalDateTime createTime;
    @Column
    private LocalDateTime updateTime;
}
