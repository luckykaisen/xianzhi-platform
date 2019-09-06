package com.xianzhi.platform.webapp.controller.goods;

import com.xianzhi.platform.webapp.common.filter.SearchResult;
import com.xianzhi.platform.webapp.common.model.AccountCO;
import com.xianzhi.platform.webapp.common.rs.api.ServiceResponse;
import com.xianzhi.platform.webapp.common.session.SessionContextAccessor;
import com.xianzhi.platform.webapp.controller.goods.api.*;
import com.xianzhi.platform.webapp.model.Goods;
import com.xianzhi.platform.webapp.service.goods.api.GoodsDetailResult;
import com.xianzhi.platform.webapp.service.goods.api.IGoodsService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/2 15:47
 */
@RestController
@RequestMapping("/services/rs/goods")
public class GoodsController {

    @Resource
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
        GoodsDetailVO detail = GoodsDetailVO.fromDetail(result);

        return new GetGoodsDetailResponse(detail);
    }


    @RequestMapping(value = "/like", method = RequestMethod.GET)
    public ServiceResponse likeGoods(@RequestParam("id") Integer id) {

        AccountCO account = SessionContextAccessor.getCurrentAccount();
        goodsService.likeGoods(id, account.getId());

        return new ServiceResponse();
    }
}
