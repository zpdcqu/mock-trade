package com.pdongzheng.mocktrade.controller;

import cn.hutool.core.util.StrUtil;
import com.pdongzheng.mocktrade.entity.BizResult;
import com.pdongzheng.mocktrade.po.AccountPO;
import com.pdongzheng.mocktrade.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/list")
    @ResponseBody
    public BizResult<List<AccountPO>> listAccount() {
        return BizResult.ofSuccess(accountService.list());
    }

    @PostMapping("/save")
    @ResponseBody
    public BizResult<AccountPO> save(@RequestBody AccountPO req) {
        if (StrUtil.isBlank(req.getAccountNo())) {
            req.setAccountNo(System.currentTimeMillis() + "");
        }
        try {
            boolean save = accountService.save(req);
            if (save) {
                AccountPO accountPO = accountService.getById(req.getId());
                return BizResult.ofSuccess(accountPO);
            }
        } catch (DuplicateKeyException e) {
            return BizResult.ofFailure(e.getMessage());
        }

        return BizResult.ofFailure("未知错误");
    }
}
