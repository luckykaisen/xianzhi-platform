package com.xianzhi.platform.webapp.exception;

import com.xianzhi.platform.webapp.common.exception.api.IException;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/6 14:25
 */
public class AddGoodsLimitTodayException extends RuntimeException implements IException  {

    public AddGoodsLimitTodayException() {
        super();
    }

    public AddGoodsLimitTodayException(String message) {
        super(message);
    }

    @Override
    public String message() {
        return "今天发布宝贝已达上限！";
    }

    @Override
    public String code() {
        return "11002";
    }
}
