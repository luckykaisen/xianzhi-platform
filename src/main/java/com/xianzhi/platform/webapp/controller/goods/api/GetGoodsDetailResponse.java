package com.xianzhi.platform.webapp.controller.goods.api;

import com.xianzhi.platform.webapp.common.rs.api.ServiceResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/5 17:49
 */
@Setter
@Getter
@AllArgsConstructor
public class GetGoodsDetailResponse extends ServiceResponse {

    private GoodsDetailVO detail;

}
