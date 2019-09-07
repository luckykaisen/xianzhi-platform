package com.xianzhi.platform.webapp.exception;

import com.xianzhi.platform.webapp.common.exception.api.IException;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/6 14:25
 */
public class CommentsOverLimitException extends RuntimeException implements IException  {

    public CommentsOverLimitException() {
        super();
    }

    public CommentsOverLimitException(String message) {
        super(message);
    }

    @Override
    public String message() {
        return "您对该商品的评论已到上限！";
    }

    @Override
    public String code() {
        return "11001";
    }
}
