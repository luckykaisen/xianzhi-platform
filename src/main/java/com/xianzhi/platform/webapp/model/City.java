package com.xianzhi.platform.webapp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/4 17:08
 */
@Data
@Entity
@Table(name = "t_city")
public class City implements Serializable {

    @Id
    private Integer id;

    private String name;

    @Column(name = "province_id")
    private Integer provinceId;

    @OneToOne
    @JoinColumn(name = "province_id", insertable = false, updatable = false)
    private Province province;
}
