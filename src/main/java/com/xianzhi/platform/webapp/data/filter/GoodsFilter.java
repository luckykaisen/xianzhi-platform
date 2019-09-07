package com.xianzhi.platform.webapp.data.filter;

import com.xianzhi.platform.webapp.common.filter.SearchFilter;
import com.xianzhi.platform.webapp.common.filter.TimeRange;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/4 17:48
 */
@Getter
@Setter
public class GoodsFilter extends SearchFilter {

    private String keywords;

    private Integer userId;

    private TimeRange createTimeRange;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        if (StringUtils.isNotBlank(keywords)) {
            this.keywords = "%" + keywords + "%";
        }
    }


}
