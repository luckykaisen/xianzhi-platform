package com.xianzhi.platform.webapp.service.goods;

import com.xianzhi.platform.webapp.common.filter.SearchResult;
import com.xianzhi.platform.webapp.common.model.PagingData;
import com.xianzhi.platform.webapp.common.model.PagingResult;
import com.xianzhi.platform.webapp.data.dao.GoodsDao;
import com.xianzhi.platform.webapp.data.filter.GoodsCommentFilter;
import com.xianzhi.platform.webapp.data.filter.GoodsFilter;
import com.xianzhi.platform.webapp.model.Goods;
import com.xianzhi.platform.webapp.model.GoodsComment;
import com.xianzhi.platform.webapp.service.goods.api.GoodsDetailResult;
import com.xianzhi.platform.webapp.service.goods.api.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/4 18:02
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Resource
    private GoodsDao goodsDao;

    @Override
    public SearchResult<Goods> searchGoodsByFilter(GoodsFilter filter) {

        SearchResult<Goods> result = new SearchResult<>();

        List<Goods> list = goodsDao.selectGoodsByFilter(filter);
        result.setResult(list);

        PagingData pagingData = filter.getPagingData();
        if (filter.isPaged() && pagingData != null) {
            int recordNumber = goodsDao.countGoodsByFilter(filter);

            PagingResult pagingResult = new PagingResult();

            pagingResult.setRecordNumber(recordNumber);
            pagingResult.setPageSize(pagingData.getPageSize());
            pagingResult.setPageNumber(pagingData.getPageNumber());

            result.setPaged(true);
            result.setPagingResult(pagingResult);
        }

        return result;
    }

    @Override
    public GoodsDetailResult getGoodsDetailById(Integer id) {

        Goods goods = goodsDao.selectGoodsById(id);

        GoodsCommentFilter commentFilter = new GoodsCommentFilter();
        commentFilter.setGoodsId(id);

        List<GoodsComment> comments = goodsDao.selectGoodsCommentByFilter(commentFilter);

        GoodsDetailResult result = new GoodsDetailResult();
        result.setComments(comments);
        result.setGoods(goods);

        return result;
    }
}
