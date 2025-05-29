package com.neegix.cqrs.command;

import com.neegix.cqrs.command.handler.AsyncCommandHandler;
import com.neegix.cqrs.command.handler.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/23/16:52
 * @Description:
 */
@Component
public class UniversalCommandBus implements CommandBus {
    // 同步命令处理器缓存
    private final Map<Class<?>, CommandHandler<?, ?>> syncHandlers = new ConcurrentHashMap<>();

    // 异步命令处理器缓存
    private final Map<Class<?>, AsyncCommandHandler<?, ?>> asyncHandlers = new ConcurrentHashMap<>();

    @Autowired
    public UniversalCommandBus(ApplicationContext context) {
        // 自动注册所有同步处理器
        context.getBeansOfType(CommandHandler.class).values()
                .forEach(this::registerSyncHandler);

        // 自动注册所有异步处理器
        context.getBeansOfType(AsyncCommandHandler.class).values()
                .forEach(this::registerAsyncHandler);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R, C extends Command<R>> R execute(C command) {
        CommandHandler<C, R> handler = (CommandHandler<C, R>) syncHandlers.get(command.getClass());
        if (handler == null) {
            throw new CommandHandlerNotFoundException(command.getClass());
        }
        return handler.handle(command);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R, C extends AsyncCommand<R>> CompletableFuture<R> executeAsync(C command) {
        AsyncCommandHandler<C, R> handler = (AsyncCommandHandler<C, R>) asyncHandlers.get(command.getClass());
        if (handler == null) {
            throw new CommandHandlerNotFoundException(command.getClass());
        }
        return handler.handleAsync(command);
    }

    // 自动解析并注册同步处理器
    private void registerSyncHandler(CommandHandler<?, ?> handler) {
        Class<?> commandType = resolveCommandType(handler.getClass(), CommandHandler.class);
        syncHandlers.put(commandType, handler);
    }

    // 自动解析并注册异步处理器
    private void registerAsyncHandler(AsyncCommandHandler<?, ?> handler) {
        Class<?> commandType = resolveCommandType(handler.getClass(), AsyncCommandHandler.class);
        asyncHandlers.put(commandType, handler);
    }

    // 通过反射解析处理器处理的命令类型
    private Class<?> resolveCommandType(Class<?> handlerClass, Class<?> targetInterface) {
        // 如果是 CGLIB 代理类，获取其父类（原始类）
        Class<?> actualClass = handlerClass;
        while (actualClass.getName().contains("$$")) {
            actualClass = actualClass.getSuperclass();
        }

        // 检查接口的泛型参数
        for (Type genericInterface : actualClass.getGenericInterfaces()) {
            if (genericInterface instanceof ParameterizedType) {
                ParameterizedType paramType = (ParameterizedType) genericInterface;
                if (paramType.getRawType().equals(targetInterface)) {
                    return (Class<?>) paramType.getActualTypeArguments()[0];
                }
            }
        }

        throw new IllegalStateException("无法解析 " + handlerClass.getName() + " 的命令类型");
    }
}
