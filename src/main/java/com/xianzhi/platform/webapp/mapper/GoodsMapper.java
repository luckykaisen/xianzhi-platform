package com.xianzhi.platform.webapp.mapper;

import com.xianzhi.platform.webapp.data.filter.GoodsCommentFilter;
import com.xianzhi.platform.webapp.data.filter.GoodsFilter;
import com.xianzhi.platform.webapp.model.Goods;
import com.xianzhi.platform.webapp.model.GoodsComment;
import com.xianzhi.platform.webapp.model.UserGoodsLike;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/5 16:34
 */
public interface GoodsMapper {

    List<Goods> selectGoodsByFilter(@Param("filter") GoodsFilter filter);

    int countGoodsByFilter(@Param("filter") GoodsFilter filter);

    Goods selectGoodsById(Integer id);

    List<GoodsComment> selectGoodsCommentByFilter(@Param("filter") GoodsCommentFilter filter);

    void accumulateGoodsViewCount(@Param("id") Integer id,
                                  @Param("count") int count);

    UserGoodsLike selectUserGoodsLikeByUserIdAndGoodsId(@Param("userId") Integer userId,
                                                        @Param("goodsId") Integer id);

    void insertUserGoodsLike(UserGoodsLike goodsLike);

    void deleteUserGoodsLikeById(Integer id);
}
