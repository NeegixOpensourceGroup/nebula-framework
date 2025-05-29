package com.neegix.system.user.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.system.user.application.service.command.ResetPasswordCommand;
import com.neegix.system.user.domain.entity.UserEntity;
import com.neegix.system.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/10/21:35
 * @Description:
 */
@Service
public class ResetPasswordHandler implements CommandHandler<ResetPasswordCommand, Void> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Void handle(ResetPasswordCommand command) {
        String resetPassword = generateRandomPassword(8);
        String encryptedPassword = passwordEncoder.encode(resetPassword);
        for (Long userId : command.getUserIds()) {
            Optional<UserEntity> optional = userRepository.findById(userId);
            if (optional.isPresent()){
                UserEntity user = optional.get();
                user.setPassword(encryptedPassword);
                userRepository.save(user);
            }
        }
        return null;
    }

    private String generateRandomPassword(int length) {
        // 定义密码字符集，包含大小写字母和数字
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        // 随机选择字符拼接成密码
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }
}
