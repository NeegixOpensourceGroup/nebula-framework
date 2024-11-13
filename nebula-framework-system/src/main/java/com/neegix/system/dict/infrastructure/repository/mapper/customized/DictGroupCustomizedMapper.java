package com.neegix.system.dict.infrastructure.repository.mapper.customized;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/29/11:44
 * @Description:
 */
@Mapper
public interface DictGroupCustomizedMapper {
    Integer selectCountByIds(List<Long> ids);
}
