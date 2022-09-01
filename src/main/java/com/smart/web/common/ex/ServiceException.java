package com.smart.web.common.ex;

import com.smart.web.common.result.ResponseCode;
import lombok.Getter;

@Getter
public class ServiceException extends BaseException{

    public ServiceException(ResponseCode responseCode) {
        super(responseCode);
    }
}
