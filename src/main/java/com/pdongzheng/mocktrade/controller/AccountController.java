package com.pdongzheng.mocktrade.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.lang.generator.UUIDGenerator;
import com.pdongzheng.mocktrade.po.AccountPO;
import com.pdongzheng.mocktrade.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("list")
    public List<AccountPO> listAccount() {
        return accountService.list();
    }

    @PostMapping("/save")
    @ResponseBody
    public AccountPO save(@RequestBody AccountPO req) {
        req.setAccountNo(System.currentTimeMillis()+"");
        boolean save = accountService.save(req);
        return req;
    }
}
