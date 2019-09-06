package com.xianzhi.platform.webapp.controller.goods;

import com.xianzhi.platform.webapp.common.filter.SearchResult;
import com.xianzhi.platform.webapp.common.rs.api.ServiceResponse;
import com.xianzhi.platform.webapp.controller.goods.api.GetGoodsDetailResponse;
import com.xianzhi.platform.webapp.controller.goods.api.GetGoodsListRequest;
import com.xianzhi.platform.webapp.controller.goods.api.GetGoodsListResponse;
import com.xianzhi.platform.webapp.controller.goods.api.GoodsVO;
import com.xianzhi.platform.webapp.data.filter.GoodsFilter;
import com.xianzhi.platform.webapp.model.Goods;
import com.xianzhi.platform.webapp.service.goods.api.GoodsDetailResult;
import com.xianzhi.platform.webapp.service.goods.api.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/2 15:47
 */
@RestController
@RequestMapping("/services/rs/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ServiceResponse getGoodsList(@RequestBody GetGoodsListRequest request) {

        SearchResult<Goods> result = goodsService.searchGoodsByFilter(request.fromGoodsFilter());
        List<GoodsVO> goods = GoodsVO.toVOs(result.getResult());

        GetGoodsListResponse response = new GetGoodsListResponse();
        response.setGoods(goods);
        response.setPagingResult(result.getPagingResult());

        return response;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ServiceResponse getGoodsDetail(@RequestParam("id") Integer id) {

        GoodsDetailResult result = goodsService.getGoodsDetailById(id);

        GetGoodsDetailResponse response = new GetGoodsDetailResponse();
        return response;
    }

}
