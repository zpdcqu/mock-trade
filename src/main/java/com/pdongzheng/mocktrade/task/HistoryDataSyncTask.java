package com.pdongzheng.mocktrade.task;


import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import com.pdongzheng.mocktrade.entity.enums.Timeframe;
import com.pdongzheng.mocktrade.po.KlinePO;
import com.pdongzheng.mocktrade.po.SymbolPO;
import com.pdongzheng.mocktrade.service.MarkPriceKlineService;
import com.pdongzheng.mocktrade.service.SymbolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Component
@Slf4j
public class HistoryDataSyncTask {

    @Autowired
    SymbolService symbolService;
    @Autowired
    UMFuturesClientImpl umFuturesClient;
    @Autowired
    MarkPriceKlineService markPriceKlineService;

    @Scheduled(fixedRate = 300000)
    public void doExecTask() {
//        ThreadUtil.sleep(RandomUtil.randomInt(0, 60000));
        List<SymbolPO> symbolList = symbolService.list();
        log.info("开始同步：一共{}条", symbolList.size());
        symbolList.forEach(this::saveMarkPriceKline);
    }

    private void saveMarkPriceKline(SymbolPO symbolPO) {
        KlinePO lastKline = markPriceKlineService.lastKline(symbolPO.getSymbol(), symbolPO.getTimeframe());
        LocalDateTime startTime = symbolPO.getSinceTime();
        if (ObjectUtil.isNotNull(lastKline)) {
            startTime = lastKline.getCloseTime();
        }
        int limit = 500;
        // limit * timeframe.period+startTime<LocalDateTime.now()
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", symbolPO.getSymbol());
        parameters.put("limit", limit);
        parameters.put("interval", symbolPO.getTimeframe().getCode());
        while (startTime.isBefore(LocalDateTime.now())) {
            parameters.put("startTime",startTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
            parameters.put("endTime", startTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli()+ limit * symbolPO.getTimeframe().getSecond() * 1000);
            String result = umFuturesClient.market().klines(parameters);
            List<KlinePO> klinePOS = parseData(result, symbolPO.getSymbol(), symbolPO.getTimeframe());
            markPriceKlineService.saveBatch(klinePOS);
            startTime = startTime.plusNanos(limit * symbolPO.getTimeframe().getSecond() * 1000L);
        }
    }

    private List<KlinePO> parseData(String res, String symbol, Timeframe timeframe) {
        JSONArray array = JSONUtil.parseArray(res);
        List<KlinePO> list = new ArrayList<>();
        for (Object o : array) {
            JSONArray item = JSONUtil.parseArray(o);
            KlinePO po = new KlinePO();
            po.setSymbol(symbol);
            po.setTimeframe(timeframe);
            po.setOpenTime(LocalDateTimeUtil.of(new Date(Long.parseLong(item.get(0).toString()))));
            po.setOpenPrice(Double.parseDouble(item.get(1).toString()));
            po.setHighPrice(Double.parseDouble(item.get(2).toString()));
            po.setLowPrice(Double.parseDouble(item.get(3).toString()));
            po.setClosePrice(Double.parseDouble(item.get(4).toString()));
            po.setVolume(Double.parseDouble(item.get(5).toString()));
            po.setCloseTime(LocalDateTimeUtil.of(new Date(Long.parseLong(item.get(6).toString()))));
            list.add(po);
        }
        return list;
    }
}
