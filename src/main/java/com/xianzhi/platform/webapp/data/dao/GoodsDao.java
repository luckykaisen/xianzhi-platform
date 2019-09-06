package com.xianzhi.platform.webapp.data.dao;

import com.xianzhi.platform.webapp.data.filter.GoodsCommentFilter;
import com.xianzhi.platform.webapp.data.filter.GoodsFilter;
import com.xianzhi.platform.webapp.mapper.GoodsMapper;
import com.xianzhi.platform.webapp.model.Goods;
import com.xianzhi.platform.webapp.model.GoodsComment;
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
}
