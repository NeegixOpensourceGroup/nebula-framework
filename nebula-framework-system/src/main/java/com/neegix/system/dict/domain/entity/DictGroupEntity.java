package com.neegix.system.dict.domain.entity;

import com.neegix.domain.entity.AggregateRoot;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/11/16:37
 * @Description:
 */
@Data
public class DictGroupEntity implements AggregateRoot {
    private Long id;
    private String code;
    private String name;

    public DictGroupEntity() {}

    public DictGroupEntity(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public DictGroupEntity(Long id, String code, String name) {
        this.code = code;
        this.name = name;
    }
}
