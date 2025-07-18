package com.neegix.system.user.application.service.query;

import com.neegix.application.command.ICommand;
import com.neegix.cqrs.command.Command;
import com.neegix.cqrs.query.Query;
import com.neegix.system.user.interfaces.vo.UserForExportVO;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/07/18/16:14
 * @Description:
 */
@Data
public class GetUserQuery implements Query<List<UserForExportVO>> {
}
