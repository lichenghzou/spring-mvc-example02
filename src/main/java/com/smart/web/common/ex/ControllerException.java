package com.smart.web.common.ex;

import com.smart.web.common.result.ResponseCode;
import lombok.Getter;

@Getter
public class ControllerException extends BaseException{

    public ControllerException(ResponseCode responseCode) {
        super(responseCode);
    }
}
