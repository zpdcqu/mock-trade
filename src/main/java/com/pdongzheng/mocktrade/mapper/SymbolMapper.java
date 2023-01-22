package com.pdongzheng.mocktrade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pdongzheng.mocktrade.po.AccountPO;
import com.pdongzheng.mocktrade.po.SymbolPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SymbolMapper extends BaseMapper<SymbolPO> {
}
