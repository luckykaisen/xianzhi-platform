package com.xianzhi.platform.webapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/4 17:08
 */
@Data
@Entity
@Table(name = "t_province")
public class Province implements Serializable {

    @Id
    private Integer id;

    private String name;

}
