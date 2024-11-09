package com.neegix.domain.entity;

import com.neegix.utils.SnowFlake;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/11/16:41
 * @Description:
 */
@Data
public abstract class AggregateRoot {
    private Long id;
    public AggregateRoot(){
        this.id = new SnowFlake(1, 1).nextId();
    }
    public AggregateRoot(Long id){
        this.id = id;
    }
}
