package com.neegix.organization.post.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.organization.post.application.service.command.DeletePostCommand;
import com.neegix.organization.post.domain.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/27/11:49
 * @Description:
 */
@Service
public class DeletePostHandler implements CommandHandler<DeletePostCommand, Void> {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Void handle(DeletePostCommand command) {
        postRepository.removeByIds(command.getIds());
        return null;
    }
}
