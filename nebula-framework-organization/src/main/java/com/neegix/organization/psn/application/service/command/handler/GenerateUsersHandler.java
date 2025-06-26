package com.neegix.organization.psn.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.organization.psn.application.service.command.GenerateUsersCommand;
import com.neegix.organization.psn.domain.entity.PsnEntity;
import com.neegix.organization.psn.domain.repository.PsnRepository;
import com.neegix.system.user.application.factory.UserFactory;
import com.neegix.system.user.domain.entity.UserEntity;
import com.neegix.system.user.domain.repository.UserRepository;
import com.neegix.system.user.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/06/21/10:58
 * @Description:
 */
@Service
public class GenerateUsersHandler implements CommandHandler<GenerateUsersCommand, Void> {
    @Autowired
    private PsnRepository psnRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDomainService userDomainService;

    @Override
    public Void handle(GenerateUsersCommand command) {
        // 构建人员
        for (Long psnId: command.getPsnIds()){
            Optional<PsnEntity> optional = psnRepository.findById(psnId);
            if (optional.isPresent()){
                // 生成用户
                PsnEntity psn = optional.get();
                UserEntity user = UserFactory.createUser(psn.getCode(), psn.getName(), psn.getEmail());
                boolean isUnique = userDomainService.checkUserUnique(user);
                if (isUnique){
                    userRepository.save(user);
                } else {
                    throw new BusinessRuntimeException("用户名["+user.getName()+"]或者邮箱["+user.getEmail()+"]已存在");
                }
            }
        }

        return null;
    }
}
