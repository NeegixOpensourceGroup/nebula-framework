package com.neegix.log.aspect;

import com.neegix.auth.interfaces.vo.NebulaUserDetails;
import com.neegix.infrastructure.annotation.BizLog;
import com.neegix.infrastructure.annotation.LoginLog;
import com.neegix.infrastructure.type.LogTypeEnum;
import com.neegix.log.exceptionLog.infrastructure.repository.dataobject.ExceptionLogDO;
import com.neegix.log.exceptionLog.infrastructure.repository.mapper.ExceptionLogMapper;
import com.neegix.log.loginLog.infrastructure.repository.dataobject.LoginLogDO;
import com.neegix.log.loginLog.infrastructure.repository.mapper.LoginLogMapper;
import com.neegix.log.operationLog.infrastructure.repository.dataobject.OperationLogDO;
import com.neegix.log.operationLog.infrastructure.repository.mapper.OperationLogMapper;
import com.neegix.infrastructure.utils.ClientInfoUtil;
import com.neegix.infrastructure.utils.IPAddressUtil;
import com.neegix.infrastructure.utils.IPInfo;
import com.neegix.infrastructure.utils.PlatformTypeUtil;
import com.neegix.infrastructure.utils.SnowFlake;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/12/17/15:25
 * @Description:
 */
@Aspect
@Component
public class LogAspect {
    @Autowired
    private OperationLogMapper operationLogMapper;

    @Autowired
    private ExceptionLogMapper exceptionLogMapper;

    @Autowired
    private LoginLogMapper loginLogMapper;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private AuthenticationManager authenticationManager;


    @AfterReturning(pointcut = "@annotation(loginLog)")
    public void loginSuccess(JoinPoint joinPoint, LoginLog loginLog) {
        Object[] args = joinPoint.getArgs();
        String username = (String)args[0];
        String ip = IPAddressUtil.getIpAddress(httpServletRequest);
        IPInfo region = IPAddressUtil.getIpRegion(ip);
        LoginLogDO loginLogDO = new LoginLogDO();
        loginLogDO.setUser(username);
        loginLogDO.setId(new SnowFlake(1,1).nextId());
        loginLogDO.setIp(region.ip());
        loginLogDO.setClient(ClientInfoUtil.getClientInfo(httpServletRequest));
        loginLogDO.setType(PlatformTypeUtil.getClientType(httpServletRequest));
        loginLogDO.setArea(region.country()+"|"+region.province()+"|"+region.city());
        loginLogMapper.insert(loginLogDO);
    }

    @AfterReturning(pointcut = "@annotation(bizLog)")
    public void success(JoinPoint joinPoint, BizLog bizLog) {

        String userName = getUserName();
        // 获取注解的属性
        String module = bizLog.module();
        String description = bizLog.description();
        LogTypeEnum type = bizLog.type();

        OperationLogDO operationLogDO = new OperationLogDO();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof NebulaUserDetails nebulaUserDetails){
            operationLogDO.setUser(nebulaUserDetails.getUsername());
        }
        operationLogDO.setModule(module);
        operationLogDO.setType(type.ordinal());
        operationLogDO.setDescription(description);
        operationLogDO.setId(new SnowFlake(1,1).nextId());
        operationLogDO.setUser(userName);
        operationLogMapper.insert(operationLogDO);
    }

    private static String getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = null;
        if (authentication != null) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof NebulaUserDetails) {
                // 如果是 NebulaUserDetails 类型，则强转并获取用户名
                userName = ((NebulaUserDetails) principal).getUsername();
            } else if (principal instanceof UserDetails) {
                // 如果是标准的 UserDetails 类型，则强转并获取用户名
                userName = ((UserDetails) principal).getUsername();
            } else {
                // 如果 principal 不是 UserDetails 类型，则假定它是 String 类型的用户名
                userName = principal.toString();
            }
        }
        return userName;
    }

    @AfterThrowing(pointcut = "@annotation(bizLog)", throwing = "ex")
    public void exception(JoinPoint joinPoint, BizLog bizLog, Throwable ex){

        String userName = getUserName();
        // 获取注解的属性
        String module = bizLog.module();
        String description = bizLog.description();
        LogTypeEnum type = bizLog.type();
        // 获取方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取声明该方法的类的全限定名
        String className = signature.getDeclaringTypeName();
        // 获取方法名称
        String methodName = signature.getName();

        // 组合成方法的全限定名
        String fullyQualifiedName = className + "." + methodName;
        ExceptionLogDO exceptionLogDO = new ExceptionLogDO();
        exceptionLogDO.setId(new SnowFlake(1,1).nextId());
        exceptionLogDO.setUser(userName);
        exceptionLogDO.setModule(module);
        exceptionLogDO.setDescription(description);
        exceptionLogDO.setType(type.ordinal());
        exceptionLogDO.setException(ex.getMessage());
        exceptionLogDO.setFullName(fullyQualifiedName);
        exceptionLogDO.setUri(httpServletRequest.getRequestURI());
        exceptionLogMapper.insert(exceptionLogDO);
    }
}
