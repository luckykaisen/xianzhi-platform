package com.xianzhi.platform.webapp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/4 17:08
 */
@Data
@Table(name = "t_district")
@Entity
public class District implements Serializable {

    @Id
    private Integer id;

    private String name;

    @Column(name = "city_id")
    private Integer cityId;

    @OneToOne
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    private City city;
}
