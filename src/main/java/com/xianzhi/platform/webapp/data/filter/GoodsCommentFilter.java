package com.xianzhi.platform.webapp.data.filter;

import com.xianzhi.platform.webapp.common.filter.SearchFilter;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/4 17:48
 */
@Setter
@Getter
public class GoodsCommentFilter extends SearchFilter {

    private Integer goodsId;

    private Integer fromUserId;

}
