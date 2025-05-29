package com.neegix.system.dict.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/20/17:19
 * @Description:
 */
@Data
public class UpdateDictGroupCommand implements Command<Void> {
    private Long id;
    private String code;
    private String name;

    public UpdateDictGroupCommand(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
}
