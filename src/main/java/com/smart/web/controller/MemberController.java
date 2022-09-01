package com.smart.web.controller;

import com.smart.web.common.result.ResponseResult;
import com.smart.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  全局异常处理
 *      会员登录
 *      会员注册
 *      修改密码
 *      查询订单信息
 *      查询收货地址信息
 *      会员的详细信息
 */

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/login")
    public ResponseResult<Integer> login(String username, String password){
        return ResponseResult.success(memberService.login(username,password));
    }
}
