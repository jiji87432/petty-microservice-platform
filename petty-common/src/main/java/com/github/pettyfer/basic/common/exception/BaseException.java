package com.github.pettyfer.basic.common.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 自定义Exception
 *
 * @author Petty
 * @date 2018年2月24日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseException extends Exception implements Serializable {
    private static final long serialVersionUID = -8390390631837103313L;
    private int status = 200;

    public BaseException(String message, int status) {
        super(message);
        this.status = status;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
