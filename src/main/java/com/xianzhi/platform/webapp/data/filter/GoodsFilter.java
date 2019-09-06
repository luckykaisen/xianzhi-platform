package com.xianzhi.platform.webapp.data.filter;

import com.xianzhi.platform.webapp.common.filter.SearchFilter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/4 17:48
 */
public class GoodsFilter extends SearchFilter {

    private String keywords;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        if (StringUtils.isNotBlank(keywords)) {
            this.keywords = "%" + keywords + "%";
        }
    }
}
