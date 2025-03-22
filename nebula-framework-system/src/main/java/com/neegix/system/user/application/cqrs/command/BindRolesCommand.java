package com.neegix.system.user.application.cqrs.command;

import com.neegix.application.command.ICommand;
import com.neegix.system.user.infrastructure.repository.dataobject.UserRoleRelDO;
import com.neegix.system.user.infrastructure.repository.mapper.customized.UserCustomizedMapper;
import com.neegix.utils.SnowFlake;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/03/19/14:49
 * @Description:
 */
public class BindRolesCommand implements ICommand<Void> {
    private final List<Long> userIds;
    private final List<Long> roleIds;

    public BindRolesCommand(List<Long> userIds, List<Long> roleIds) {
        this.userIds = userIds;
        this.roleIds = roleIds;
    }
    @Override
    public Void execute(ApplicationContext context) {
        TransactionTemplate transactionTemplate = context.getBean(TransactionTemplate.class);
        transactionTemplate.execute(status -> {
            UserCustomizedMapper userCustomizedMapper =  context.getBean(UserCustomizedMapper.class);
            userCustomizedMapper.deleteUserRoleRel(userIds);
            List<UserRoleRelDO> result = new ArrayList<>();
            SnowFlake snowFlake = new SnowFlake(1, 1);
            // 遍历用户ID和角色ID，组装 UserRoleRelDO 对象
            for (Long userId : userIds) {
                for (Long roleId : roleIds) {
                    UserRoleRelDO userRoleRelDO = new UserRoleRelDO();
                    userRoleRelDO.setId(snowFlake.nextId());
                    userRoleRelDO.setPkUser(userId);
                    userRoleRelDO.setPkRole(roleId);
                    result.add(userRoleRelDO);
                }
            }
            userCustomizedMapper.insertUserRoleRel(result);
            return null;
        });






        return null;
    }
}
