package com.pdongzheng.mocktrade.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pdongzheng.mocktrade.entity.enums.Timeframe;
import com.pdongzheng.mocktrade.po.KlinePO;

public interface MarkPriceKlineService extends IService<KlinePO> {

    public KlinePO lastKline(String symbol, Timeframe timeframe);
}
