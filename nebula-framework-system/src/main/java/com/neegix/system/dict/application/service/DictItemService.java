package com.neegix.system.dict.application.service;

import com.neegix.system.dict.domain.entity.DictItemEntity;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/30/16:15
 * @Description:
 */
public interface DictItemService {
    Void createDictItem(DictItemEntity dictItemEntity);
    Void modifyDictItem(DictItemEntity dictItemEntity);
    Void removeDictItem(Long pkDictGroup, List<Long> ids);
}
