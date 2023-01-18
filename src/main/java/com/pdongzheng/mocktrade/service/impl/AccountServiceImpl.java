package com.pdongzheng.mocktrade.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pdongzheng.mocktrade.mapper.AccountMapper;
import com.pdongzheng.mocktrade.po.AccountPO;
import com.pdongzheng.mocktrade.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountPO> implements AccountService {

}
