package com.neegix.system.dict.domain.entity;

import com.neegix.domain.entity.AggregateRoot;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/14/17:06
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleEntity extends AggregateRoot {
    private String name;
    private String sign;
    private List<MenuEntity> menuEntities;
    private List<Long> interfaceIds;
    private Boolean enabled;
    private Boolean deleted;
    public RoleEntity(){
        super();
    }
    public RoleEntity(Long id) {
        super(id);
    }
}
