package com.xianzhi.platform.webapp.service.goods.api;

import com.xianzhi.platform.webapp.common.filter.SearchResult;
import com.xianzhi.platform.webapp.data.filter.GoodsFilter;
import com.xianzhi.platform.webapp.model.Goods;
import com.xianzhi.platform.webapp.model.GoodsComment;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/4 18:01
 */
public interface IGoodsService {

    SearchResult<Goods> searchGoodsByFilter(GoodsFilter fromGoodsFilter);

    GoodsDetailResult getGoodsDetailById(Integer id);

    void likeGoods(Integer id, Integer id1);

    void addGoodsComment(GoodsComment fromComment);

    void addGoods(Goods fromGoods);
}
