package com.neegix.cqrs.query;

import com.neegix.cqrs.query.handler.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/27/15:33
 * @Description:
 */
@Component
public class UniversalQueryBus implements QueryBus {
    private final ApplicationContext applicationContext;
    private final TaskExecutor queryExecutor;
    private final Map<Class<? extends Query<?>>, String> handlerBeanNames;

    @Autowired
    public UniversalQueryBus(ApplicationContext applicationContext,
                             @Qualifier("queryTaskExecutor") TaskExecutor queryExecutor) {
        this.applicationContext = applicationContext;
        this.queryExecutor = queryExecutor;
        this.handlerBeanNames = new ConcurrentHashMap<>();
        initializeHandlers();
    }

    private void initializeHandlers() {
        Map<String, QueryHandler> handlers = applicationContext.getBeansOfType(QueryHandler.class);

        handlers.forEach((beanName, handler) -> {
            Class<?> queryType = resolveQueryType(handler);
            if (queryType != null) {
                handlerBeanNames.put((Class<? extends Query<?>>) queryType, beanName);
            }
        });
    }

    private Class<?> resolveQueryType(QueryHandler<?, ?> handler) {
        Type[] genericInterfaces = handler.getClass().getGenericInterfaces();
        for (Type genericInterface : genericInterfaces) {
            if (genericInterface instanceof ParameterizedType) {
                ParameterizedType pt = (ParameterizedType) genericInterface;
                if (pt.getRawType().equals(QueryHandler.class)) {
                    return (Class<?>) pt.getActualTypeArguments()[0];
                }
            }
        }
        return null;
    }

    @Override
    public <R> R execute(Query<R> query) {
        QueryHandler<Query<R>, R> handler = findHandler(query);
        return handler.handle(query);
    }

    @Override
    public <R> CompletableFuture<R> executeAsync(Query<R> query) {
        return CompletableFuture.supplyAsync(() -> execute(query), queryExecutor);
    }

    @Override
    public <R> CompletableFuture<R> executeAsync(Query<R> query, Duration timeout) {
        CompletableFuture<R> future = executeAsync(query);
        return future.completeOnTimeout(null, timeout.toMillis(), TimeUnit.MILLISECONDS)
                .thenApply(result -> {
                    if (result == null) {
                        throw new QueryTimeoutException("Query execution timed out after " + timeout);
                    }
                    return result;
                });
    }

    @SuppressWarnings("unchecked")
    private <Q extends Query<R>, R> QueryHandler<Q, R> findHandler(Query<R> query) {
        String beanName = handlerBeanNames.get(query.getClass());
        if (beanName == null) {
            throw new QueryHandlerNotFoundException(query.getClass());
        }

        try {
            return (QueryHandler<Q, R>) applicationContext.getBean(beanName);
        } catch (Exception e) {
            throw new QueryHandlerNotFoundException(query.getClass());
        }
    }
}
