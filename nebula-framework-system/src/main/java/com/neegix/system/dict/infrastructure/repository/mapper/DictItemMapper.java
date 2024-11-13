package com.neegix.system.dict.infrastructure.repository.mapper;

import com.neegix.base.BaseMapper;
import com.neegix.system.dict.infrastructure.repository.dataobject.DictItemDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/21/22:37
 * @Description:
 */
@Mapper
public interface DictItemMapper extends BaseMapper<DictItemDO, Long> {
}
