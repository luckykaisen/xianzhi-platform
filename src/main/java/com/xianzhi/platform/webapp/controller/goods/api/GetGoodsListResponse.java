package com.xianzhi.platform.webapp.controller.goods.api;

import com.xianzhi.platform.webapp.common.rs.api.PagingResponse;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Generated;
import java.util.List;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/4 17:43
 */
@Getter
@Setter
public class GetGoodsListResponse extends PagingResponse {

    private List<GoodsVO> goods;

}
