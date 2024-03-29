package com.xianzhi.platform.webapp.data.dao;

import com.xianzhi.platform.webapp.data.filter.GoodsCommentFilter;
import com.xianzhi.platform.webapp.data.filter.GoodsFilter;
import com.xianzhi.platform.webapp.mapper.GoodsMapper;
import com.xianzhi.platform.webapp.model.Goods;
import com.xianzhi.platform.webapp.model.GoodsComment;
import com.xianzhi.platform.webapp.model.UserGoodsLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/5 16:33
 */
@Repository
public class GoodsDao {

    @Autowired
    private GoodsMapper goodsMapper;

    public List<Goods> selectGoodsByFilter(GoodsFilter filter) {
        return goodsMapper.selectGoodsByFilter(filter);
    }

    public int countGoodsByFilter(GoodsFilter filter) {
        return goodsMapper.countGoodsByFilter(filter);
    }

    public Goods selectGoodsById(Integer id) {
        return goodsMapper.selectGoodsById(id);
    }

    public List<GoodsComment> selectGoodsCommentByFilter(GoodsCommentFilter filter) {
        return goodsMapper.selectGoodsCommentByFilter(filter);
    }

    public void accumulateGoodsViewCount(Integer id, int count) {
        goodsMapper.accumulateGoodsViewCount(id, count);
    }

    public UserGoodsLike selectUserGoodsLikeByUserIdAndGoodsId(Integer userId, Integer id) {
        return goodsMapper.selectUserGoodsLikeByUserIdAndGoodsId(userId, id);
    }

    public void insertUserGoodsLike(UserGoodsLike goodsLike) {
        goodsMapper.insertUserGoodsLike(goodsLike);
    }

    public void deleteUserGoodsLikeById(Integer id) {
        goodsMapper.deleteUserGoodsLikeById(id);
    }

    public int countGoodsCommentByFilter(GoodsCommentFilter filter) {
        return goodsMapper.countGoodsCommentByFilter(filter);
    }

    public void insertGoodsComment(GoodsComment comment) {
        goodsMapper.insertGoodsComment(comment);
    }

    public void insertGoods(Goods goods) {
        goodsMapper.insertGoods(goods);
    }
}
