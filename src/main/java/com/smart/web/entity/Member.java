package com.smart.web.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Member {
    /**
     * 主键
     */
    private Long memberId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 1表示启用 0表示删除
     */
    private Integer status;
}

