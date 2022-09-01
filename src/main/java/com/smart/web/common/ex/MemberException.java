package com.smart.web.common.ex;

import com.smart.web.common.result.ResponseCode;
import lombok.Getter;

@Getter
public class MemberException extends BaseException{

    public MemberException(ResponseCode responseCode) {
        super(responseCode);
    }
}
