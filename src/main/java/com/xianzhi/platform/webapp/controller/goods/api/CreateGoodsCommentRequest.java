package com.xianzhi.platform.webapp.controller.goods.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xianzhi.platform.webapp.common.model.AccountCO;
import com.xianzhi.platform.webapp.common.session.SessionContextAccessor;
import com.xianzhi.platform.webapp.model.GoodsComment;
import lombok.Data;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/6 14:04
 */
@Data
public class CreateGoodsCommentRequest {

    private Integer id;

    private String content;

    @JsonProperty("to_user_id")
    private Integer toUserId;

    public GoodsComment fromComment() {

        AccountCO account = SessionContextAccessor.getCurrentAccount();

        GoodsComment comment = new GoodsComment();
        comment.setGoodsId(id);
        comment.setContent(content);
        comment.setFromUserId(account.getId());
        comment.setToUserId(toUserId);

        return comment;
    }
}
