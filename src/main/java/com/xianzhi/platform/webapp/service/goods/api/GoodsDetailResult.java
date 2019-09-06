package com.xianzhi.platform.webapp.service.goods.api;

import com.xianzhi.platform.webapp.model.Goods;
import com.xianzhi.platform.webapp.model.GoodsComment;
import lombok.Data;

import java.util.List;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/5 17:56
 */
@Data
public class GoodsDetailResult {

    private Goods goods;

    private List<GoodsComment> comments;

}
