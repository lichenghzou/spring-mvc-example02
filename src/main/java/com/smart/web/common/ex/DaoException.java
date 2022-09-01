package com.smart.web.common.ex;

import com.smart.web.common.result.ResponseCode;
import lombok.Getter;

@Getter
public class DaoException extends BaseException{

    public DaoException(ResponseCode responseCode) {
        super(responseCode);
    }
}
