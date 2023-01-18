package com.pdongzheng.mocktrade.controller;

import com.pdongzheng.mocktrade.po.AccountPO;
import com.pdongzheng.mocktrade.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("list")
    public List<AccountPO> listAccount() {
        return accountService.list();
    }

    @RequestMapping("save")
    public boolean save(@RequestBody AccountPO req) {
        return accountService.save(req);
    }
}
