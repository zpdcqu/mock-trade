package com.pdongzheng.mocktrade.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.binance.connector.futures.client.exceptions.BinanceClientException;
import com.binance.connector.futures.client.exceptions.BinanceConnectorException;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;

@Configuration
@MapperScan({"com.gitee.sunchenbin.mybatis.actable.dao.*"})
@ComponentScan("com.gitee.sunchenbin.mybatis.actable.manager.*")
@Slf4j
public class TableConfig implements MetaObjectHandler {

    //设置数据新增时候的，字段自动赋值规则
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

    }

    //设置数据修改update时候的，字段自动赋值规则
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }

    @PostConstruct
    public void trs() {

        /**
         *  public static Boolean checkOpenProxy() {
         * //        String hkIp = "101.32.214.135";
         * //        String phoneIp = "240e:332:1135:8000:30d1:252b:67e4:7289";
         *         String bigComputer = "00-50-56-c0-00-01";
         *         String localMacAddress = NetUtil.getLocalMacAddress();
         *         log.info("本机MAC地址：{}",localMacAddress);
         *         if (localMacAddress.equals(bigComputer)){
         *             return true;
         *         }
         *         return false;
         *     }
         *
         *
         *     public static OkHttpClient getHttpClient() {
         *         if (httpClient == null) {
         *             OkHttpClient.Builder builder = new OkHttpClient.Builder();
         *             Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", port));
         *             if (checkOpenProxy()) {
         *                 builder.proxy(proxy);
         *             }
         *             httpClient = builder.build();
         *         }
         *         return httpClient;
         *     }
         */

        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

        UMFuturesClientImpl client = new UMFuturesClientImpl();

        parameters.put("symbol", "BTCUSDT");
        parameters.put("interval", "1m");

        try {
            String result = client.market().historicalBlvt(parameters);
            log.info(result);
        } catch (BinanceConnectorException e) {
            log.error("fullErrMessage: {}", e.getMessage(), e);
        } catch (BinanceClientException e) {
            log.error("fullErrMessage: {} \nerrMessage: {} \nerrCode: {} \nHTTPStatusCode: {}",
                    e.getMessage(), e.getErrMsg(), e.getErrorCode(), e.getHttpStatusCode(), e);
        }

    }
}