package com.neegix.system.dict.application.service;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/30/16:15
 * @Description:
 */
public interface DictGroupService {
    Void createDictGroup(String code, String name);
    Void modifyDictGroup(Long id, String code, String name);
    Void removeDictGroup(List<Long> ids);
}
