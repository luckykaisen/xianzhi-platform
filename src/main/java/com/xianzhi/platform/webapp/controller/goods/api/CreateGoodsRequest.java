package com.xianzhi.platform.webapp.controller.goods.api;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xianzhi.platform.webapp.common.model.AccountCO;
import com.xianzhi.platform.webapp.common.session.SessionContextAccessor;
import com.xianzhi.platform.webapp.model.Goods;
import com.xianzhi.platform.webapp.model.GoodsCategory;
import com.xianzhi.platform.webapp.model.GoodsStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/7 9:07
 */
@Data
public class CreateGoodsRequest {

    @NotNull
    private String name;

    @NotNull
    private Integer price;

    @NotNull
    private String address;

    @NotNull
    @JsonProperty("category_id")
    private Integer categoryId;

    @NotNull
    private String description;

    @NotNull
    private List<String> images;

    public Goods fromGoods() {

        Goods goods = new Goods();
        goods.setName(name);
        goods.setPrice(price);
        goods.setAddress(address);
        goods.setCategory(GoodsCategory.fromId(categoryId));
        goods.setDescription(description);
        goods.setImages(JSONArray.toJSONString(images));
        goods.setCoverImage(images.get(0));
        goods.setDistrictId(110115);
        goods.setStatus(GoodsStatus.PUTAWAY);

        AccountCO account = SessionContextAccessor.getCurrentAccount();
        goods.setUserId(account.getId());

        return goods;
    }
}
