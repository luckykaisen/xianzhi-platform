package com.xianzhi.platform.webapp.model;

import com.xianzhi.platform.webapp.common.mybatis.typehandler.IdInterface;

import java.util.HashMap;
import java.util.Map;

public enum GoodsStatus implements IdInterface {

    PUTAWAY (1, "上架"),
    SOLD_OUT(2, "下架");

    private static final Map<Integer, GoodsStatus> id2Enums;

    private int id;
    private String name;

    static {
        id2Enums = new HashMap<>();

        for (GoodsStatus record : GoodsStatus.values()) {
            id2Enums.put(record.getId(), record);
        }
    }

    public static GoodsStatus fromId(Integer id) {
        return id2Enums.get(id);
    }

    GoodsStatus(int id, String name) {
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
