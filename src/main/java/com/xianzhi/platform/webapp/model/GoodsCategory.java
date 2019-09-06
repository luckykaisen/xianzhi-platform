package com.xianzhi.platform.webapp.model;

import com.xianzhi.platform.webapp.common.mybatis.typehandler.IdInterface;

import java.util.HashMap;
import java.util.Map;

public enum GoodsCategory implements IdInterface {

    CATEGORY_1  (1, "手机/数码"),
    CATEGORY_2  (2, "电脑/办公"),
    CATEGORY_3  (3, "家具/家居/厨具"),
    CATEGORY_4  (4, "服装"),
    CATEGORY_5  (5, "美妆/宠物"),
    CATEGORY_6  (6, "鞋/箱包/珠宝/户外"),
    CATEGORY_7  (7, "汽车用品"),
    CATEGORY_8  (8, "食品/酒类/生鲜"),
    CATEGORY_9  (9, "图书/生活"),
    CATEGORY_10 (10, "其它"),
            ;

    private static final Map<Integer, GoodsCategory> id2Enums;

    private int id;
    private String name;

    static {
        id2Enums = new HashMap<>();

        for (GoodsCategory record : GoodsCategory.values()) {
            id2Enums.put(record.getId(), record);
        }
    }

    public static GoodsCategory fromId(Integer id) {
        return id2Enums.get(id);
    }

    GoodsCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
