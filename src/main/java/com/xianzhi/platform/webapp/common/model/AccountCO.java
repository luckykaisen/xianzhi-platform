package com.xianzhi.platform.webapp.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/5 17:57
 */
@Data
public class AccountCO implements Serializable {

    private static final String CONTEXT_KEY = "USER_DETAIL_CONTEXT_KEY";

    private Integer id;

    private String mobile;

    public static String getContextKey() {
        return CONTEXT_KEY;
    }
}
