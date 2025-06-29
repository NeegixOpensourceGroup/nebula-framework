package com.neegix.system.dict.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/22/15:47
 * @Description:
 */
@Data
public class UpdateDictItemCommand implements Command<Void> {
    private Long id;
    private Long pkDictGroup;
    private String name;
    private String value;
    private Integer sort;
}
