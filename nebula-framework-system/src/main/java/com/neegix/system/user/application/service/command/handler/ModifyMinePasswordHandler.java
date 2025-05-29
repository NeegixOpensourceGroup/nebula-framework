package com.neegix.system.user.application.service.command.handler;

import com.neegix.auth.interfaces.vo.NebulaUserDetails;
import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.system.user.application.service.command.ModifyMinePasswordCommand;
import com.neegix.system.user.domain.entity.UserEntity;
import com.neegix.system.user.domain.repository.UserRepository;
import com.neegix.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Void handle(ModifyMinePasswordCommand command) {
        // 验证两密码是否一致
        if (!command.getNewPassword().equals(command.getConfirmPassword())){
            throw new BusinessRuntimeException("密码输入不一致！");
        }
        // 验证旧密码是否正确
        NebulaUserDetails userDetails = SecurityUtils.getCurrentUser(NebulaUserDetails.class);

        assert userDetails != null;
        boolean isConfirm = passwordEncoder.matches(command.getOldPassword(), userDetails.getPassword());
        if (!isConfirm){
            throw new BusinessRuntimeException("旧密码不正确，请重新输入！");
        }
        // 更新密码
        String encryptedPassword = passwordEncoder.encode(command.getNewPassword());

        Optional<UserEntity> optional = userRepository.findById(userDetails.getId());

        UserEntity user = optional.orElseThrow(()-> new BusinessRuntimeException("用户不存在"));

        user.setPassword(encryptedPassword);

        userRepository.save(user);

        return null;
    }
}
