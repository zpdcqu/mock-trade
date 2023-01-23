package com.pdongzheng.mocktrade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pdongzheng.mocktrade.po.KlinePO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MarkPriceKlineMapper extends BaseMapper<KlinePO> {
}
