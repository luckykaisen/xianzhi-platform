package com.xianzhi.platform.webapp.model;

import com.xianzhi.platform.webapp.common.model.Bool;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/4 17:10
 */
@Data
public class GoodsComment implements Serializable {

    private Integer id;
    private String content;
    private Date createTime;
    private Bool hide;
    private Integer goodsId;
    private Integer fromUserId;
    private Integer toUserId;

    private Goods goods;
    private User fromUser;
    private User toUser;

}
