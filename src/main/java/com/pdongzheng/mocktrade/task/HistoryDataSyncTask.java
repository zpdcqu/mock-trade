package com.pdongzheng.mocktrade.task;


import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.pdongzheng.mocktrade.po.SymbolPO;
import com.pdongzheng.mocktrade.service.SymbolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class HistoryDataSyncTask {

    @Autowired
    SymbolService symbolService;

    @Scheduled(fixedRate = 300000)
    public void doExecTask() {
        ThreadUtil.sleep(RandomUtil.randomInt(0, 60000));
        List<SymbolPO> symbolList = symbolService.list();
        log.info("开始同步：一共{}条", symbolList.size());
        for (SymbolPO symbolPO : symbolList) {
            log.info("正在同步：{}", JSONUtil.toJsonStr(symbolPO));
        }
    }
}
