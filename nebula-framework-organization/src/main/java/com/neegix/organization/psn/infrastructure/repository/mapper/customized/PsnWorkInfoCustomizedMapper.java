package com.neegix.organization.psn.infrastructure.repository.mapper.customized;

import com.neegix.organization.psn.infrastructure.repository.dataobject.PsnWorkInfoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * This file is auto-generated by nebula-framework-generator.
 * The auto-generation plugin was developed using IntelliJ IDEA Community Edition.
 * Thanks to JetBrains for their outstanding contributions to the developer community.
 * <p>
 * The code generated by this tool is owned by the user of the tool.
 * The tool itself is copyrighted by <a href="https://www.neegix.com">https://www.neegix.com</a>.
 *
 * @author <a href="https://www.neegix.com">https://www.neegix.com</a>
 * @version 1.0.0
 * @since 2024-12-11 15:13:32
 */

@Mapper
public interface PsnWorkInfoCustomizedMapper {
   void batchInsertPsnWorkInfo(List<PsnWorkInfoDO> psnWorkInfoDOS);
   void batchDeleteByPkPsn(List<Long> pkPsn);
   List<PsnWorkInfoDO> selectPsnWorkInfos(Long pkPsn);
   List<Long> selectPsnPkByBizUnitAndDept(Long pkBizUnit, Long pkDept);
}