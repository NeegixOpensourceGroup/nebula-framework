package com.neegix.system.user.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.inferfaces.vo.CurrentUser;
import com.neegix.infrastructure.utils.SecurityUtils;
import com.neegix.system.user.application.service.command.ModifyMinePasswordCommand;
import com.neegix.system.user.domain.entity.UserEntity;
import com.neegix.system.user.domain.repository.UserRepository;
import com.neegix.system.user.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/17:48
 * @Description:
 */
@Service
public class ModifyMinePasswordHandler implements CommandHandler<ModifyMinePasswordCommand, Void> {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserDomainService userDomainService;

    @Override
    public Void handle(ModifyMinePasswordCommand command) {
        // 验证两密码是否一致
        if (!command.getNewPassword().equals(command.getConfirmPassword())){
            throw new BusinessRuntimeException("密码输入不一致！");
        }
        // 验证旧密码是否正确
        CurrentUser userDetails = SecurityUtils.getCurrentUser();

        assert userDetails != null;
        boolean isConfirm = passwordEncoder.matches(command.getOldPassword(), userDetails.getPassword());
        if (!isConfirm){
            throw new BusinessRuntimeException("旧密码不正确，请重新输入！");
        }
        // 更新密码
        String encryptedPassword = passwordEncoder.encode(command.getNewPassword());

        UserEntity user = userDomainService.getUser(userDetails.getId());

        user.setPassword(encryptedPassword);

        userRepository.save(user);

        return null;
    }
}
