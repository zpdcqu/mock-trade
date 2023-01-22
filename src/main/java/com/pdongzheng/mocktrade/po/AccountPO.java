package com.pdongzheng.mocktrade.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlEngineConstant;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("account")
@TableCharset(MySqlCharsetConstant.UTF8)
@TableEngine(MySqlEngineConstant.InnoDB)
public class AccountPO {

    @IsKey
    @IsAutoIncrement
    private Long id;
    @Column(comment = "账户编码")
    private String accountNo;
    @Column(comment = "账户名称")
    private String account_name;
    @Column(comment = "美分")
    private Long balance;
    @Column(comment = "账户描述")
    @DefaultValue(value = "")
    private String account_desc;
    @DefaultValue(value ="CURRENT_TIMESTAMP" )
    private LocalDateTime createTime;
    @DefaultValue(value ="CURRENT_TIMESTAMP" )
    private LocalDateTime updateTime;
}
