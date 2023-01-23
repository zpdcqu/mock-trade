package com.pdongzheng.mocktrade.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pdongzheng.mocktrade.entity.enums.Timeframe;
import com.pdongzheng.mocktrade.mapper.MarkPriceKlineMapper;
import com.pdongzheng.mocktrade.po.KlinePO;
import com.pdongzheng.mocktrade.service.MarkPriceKlineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkPriceKlineServiceImpl extends ServiceImpl<MarkPriceKlineMapper, KlinePO> implements MarkPriceKlineService {

    @Override
    public KlinePO lastKline(String symbol, Timeframe timeframe) {
        List<KlinePO> list = this.lambdaQuery()
                .eq(KlinePO::getSymbol, symbol)
                .eq(KlinePO::getTimeframe, timeframe)
                .orderByDesc(KlinePO::getCloseTime)
                .last("limit 1")
                .list();
        if (CollUtil.isNotEmpty(list)){
            return list.get(0);
        }
        return null;
    }
}
