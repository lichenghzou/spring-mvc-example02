package com.smart.web.mapper;

import com.smart.web.entity.Member;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
    Member selectByName(@Param("username") String username);
}
