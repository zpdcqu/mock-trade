package com.pdongzheng.mocktrade.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pdongzheng.mocktrade.mapper.AccountMapper;
import com.pdongzheng.mocktrade.mapper.SymbolMapper;
import com.pdongzheng.mocktrade.po.AccountPO;
import com.pdongzheng.mocktrade.po.SymbolPO;
import com.pdongzheng.mocktrade.service.AccountService;
import com.pdongzheng.mocktrade.service.SymbolService;
import org.springframework.stereotype.Service;

@Service
public class SymbolServiceImpl extends ServiceImpl<SymbolMapper, SymbolPO> implements SymbolService {

}
