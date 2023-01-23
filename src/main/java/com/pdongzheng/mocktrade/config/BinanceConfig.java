package com.pdongzheng.mocktrade.config;

import com.binance.connector.futures.client.impl.CMFuturesClientImpl;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BinanceConfig {

    @Bean
    public CMFuturesClientImpl cmFuturesClient() {
        return new CMFuturesClientImpl();
    }


    @Bean
    public UMFuturesClientImpl umFuturesClient(){
        return new UMFuturesClientImpl();
    }
}


