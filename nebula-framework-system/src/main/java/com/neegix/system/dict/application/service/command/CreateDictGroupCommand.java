package com.neegix.system.dict.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/20/15:46
 * @Description:
 */
@Data
public class CreateDictGroupCommand implements Command<Void> {
    private String code;
    private String name;

    public CreateDictGroupCommand(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
