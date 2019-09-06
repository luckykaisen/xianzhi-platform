package com.xianzhi.platform.webapp.controller.goods.api;

import com.xianzhi.platform.webapp.common.rs.api.PagingRequest;
import com.xianzhi.platform.webapp.data.filter.GoodsFilter;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/4 17:47
 */
@Getter
@Setter
public class GetGoodsListRequest extends PagingRequest {

    private String keywords;

    public GoodsFilter fromGoodsFilter() {

        GoodsFilter filter = new GoodsFilter();
        filter.setKeywords(keywords);
        filter.initPagingAndOrdering(this);

        return filter;
    }
}
