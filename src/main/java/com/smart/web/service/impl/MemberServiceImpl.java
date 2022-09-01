package com.smart.web.service.impl;

import com.smart.web.common.ex.ServiceException;
import com.smart.web.common.result.ResponseCode;
import com.smart.web.entity.Member;
import com.smart.web.mapper.MemberMapper;
import com.smart.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;
    @Override
    public int login(String username, String password) {
        //判断用户名是否存在
        Member member = memberMapper.selectByName(username);
        if (member==null){
            throw new ServiceException(ResponseCode.MEMBER_NO_EXIST_ERROR);
        }
        //判断密码是否正确
        if (!member.getPassword().equals(password)){
            throw new ServiceException(ResponseCode.MEMBER_PASSWORD_ERROR);
        }
        //登录成功的业务逻辑
        return 1;
    }
}
