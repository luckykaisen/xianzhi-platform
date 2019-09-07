package com.xianzhi.platform.webapp.service.goods;

import com.xianzhi.platform.webapp.common.constant.Constant;
import com.xianzhi.platform.webapp.common.filter.SearchResult;
import com.xianzhi.platform.webapp.common.filter.TimeRange;
import com.xianzhi.platform.webapp.common.model.PagingData;
import com.xianzhi.platform.webapp.common.model.PagingResult;
import com.xianzhi.platform.webapp.common.utility.DateTimeUtility;
import com.xianzhi.platform.webapp.data.dao.GoodsDao;
import com.xianzhi.platform.webapp.data.filter.GoodsCommentFilter;
import com.xianzhi.platform.webapp.data.filter.GoodsFilter;
import com.xianzhi.platform.webapp.exception.AddGoodsLimitTodayException;
import com.xianzhi.platform.webapp.exception.CommentsOverLimitException;
import com.xianzhi.platform.webapp.model.Goods;
import com.xianzhi.platform.webapp.model.GoodsComment;
import com.xianzhi.platform.webapp.model.UserGoodsLike;
import com.xianzhi.platform.webapp.service.goods.api.GoodsDetailResult;
import com.xianzhi.platform.webapp.service.goods.api.IGoodsService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
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

        // 更新view_count
        goodsDao.accumulateGoodsViewCount(id, 1);

        GoodsDetailResult result = new GoodsDetailResult();
        result.setComments(comments);
        result.setGoods(goods);

        return result;
    }

    @Override
    public void likeGoods(Integer id, Integer userId) {

        UserGoodsLike like = goodsDao.selectUserGoodsLikeByUserIdAndGoodsId(userId, id);

        if (like == null) {

            UserGoodsLike goodsLike = new UserGoodsLike();
            goodsLike.setGoodsId(id);
            goodsLike.setUserId(userId);

            goodsDao.insertUserGoodsLike(goodsLike);
        } else {
            goodsDao.deleteUserGoodsLikeById(like.getId());
        }
    }

    @Override
    public void addGoodsComment(GoodsComment comment) {

        Integer goodsId = comment.getGoodsId();
        Integer fromUserId = comment.getFromUserId();

        Goods goods = goodsDao.selectGoodsById(goodsId);
        if (!goods.getUserId().equals(fromUserId)) {

            GoodsCommentFilter filter = new GoodsCommentFilter();
            filter.setGoodsId(comment.getGoodsId());
            filter.setFromUserId(comment.getFromUserId());

            int count = goodsDao.countGoodsCommentByFilter(filter);

            if (count > 5) {
                throw new CommentsOverLimitException("comment over limit, user id: " + fromUserId);
            }
        }

        goodsDao.insertGoodsComment(comment);
    }

    @Override
    public void addGoods(Goods goods) {

        Integer userId = goods.getUserId();
        Date today = DateTimeUtility.getDate(new Date());
        Date tomorrow = DateTimeUtility.addDays(today, 1);

        GoodsFilter filter = new GoodsFilter();
        filter.setUserId(userId);
        filter.setCreateTimeRange(new TimeRange(today, tomorrow));

        int countToday = goodsDao.countGoodsByFilter(filter);

        if (countToday >= Constant.GOODS_COUNT_LIMIT_TODAY) {
            throw new AddGoodsLimitTodayException("add goods limit today, user id: " + userId);
        }

        goodsDao.insertGoods(goods);
    }
}
