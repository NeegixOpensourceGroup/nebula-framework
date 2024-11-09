package com.neegix.application.query;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/24/16:50
 * @Description:
 */
@Setter
@Getter
public class OrderBy {
    private String column;
    private EnumOrder enumOrder;

    public OrderBy(String column, EnumOrder enumOrder){
        this.column = column;
        this.enumOrder = enumOrder;
    }
}
