package com.neegix.log.loginLog.application.service.query.mapper;

import com.neegix.log.loginLog.application.service.query.GetPageLoginLogQuery;
import com.neegix.log.loginLog.infrastructure.repository.dataobject.LoginLogDO;
import com.neegix.log.loginLog.interfaces.form.QueryLoginLogForm;
import com.neegix.log.loginLog.interfaces.vo.LoginLogVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/14:24
 * @Description:
 */
@Mapper
public interface LoginLogQueryMapper {
    LoginLogQueryMapper INSTANCE = Mappers.getMapper(LoginLogQueryMapper.class);

    GetPageLoginLogQuery covertToGetQuery(QueryLoginLogForm queryLoginLogForm);

    List<LoginLogVO> covertVO(List<LoginLogDO> LoginLogDOs);
}
