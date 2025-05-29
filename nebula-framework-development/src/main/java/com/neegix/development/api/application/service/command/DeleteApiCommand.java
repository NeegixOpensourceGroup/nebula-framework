package com.neegix.development.api.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/25/16:48
 * @Description:
 */
@Data
public class DeleteApiCommand implements Command<Void> {
    List<Long> ids;
}
