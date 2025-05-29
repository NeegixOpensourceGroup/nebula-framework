package com.neegix.system.user.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.system.user.application.service.command.BindRolesCommand;
import com.neegix.system.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/12/17:22
 * @Description:
 */
@Service
public class BindRolesHandler implements CommandHandler<BindRolesCommand, Void> {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public Void handle(BindRolesCommand command) {
        List<Long> userIds = command.getUserIds();

        /**
         * TODO 这不是我想要的，我认为，这边应该使用聚合根领域模型中的更新角色方法处理，然后在用仓储层的
         * save 方法处理（需要处理先删除后更新的逻辑），这块后续考虑用防腐层查询角色聚合来处理构建用户的聚合根
         */
        for (Long userId : userIds){
            userRepository.removeById(userId);
            userRepository.batchInsertUserRoleRel(userId, command.getRoleIds());
        }
        return null;
    }
}
