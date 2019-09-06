package com.xianzhi.platform.webapp.model;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/4 17:13
 */
@Data
public class UserGoodsLike implements Serializable {

    private Integer id;
    private Date createTime;
    private Integer goodsId;
    private Integer userId;

}
