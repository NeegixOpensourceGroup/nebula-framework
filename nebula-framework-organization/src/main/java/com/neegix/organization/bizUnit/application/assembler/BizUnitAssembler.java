package com.neegix.organization.bizUnit.application.assembler;

import com.neegix.organization.bizUnit.application.service.command.CreateBizUnitCommand;
import com.neegix.organization.bizUnit.application.service.command.UpdateBizUnitCommand;
import com.neegix.organization.bizUnit.domain.entity.BizUnitEntity;
import com.neegix.organization.bizUnit.infrastructure.repository.dataobject.BizUnitDO;
import com.neegix.organization.bizUnit.interfaces.vo.BizUnitVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

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
  * @since 2024-12-10 10:58:59
  */

@Mapper
public interface BizUnitAssembler {
    BizUnitAssembler INSTANCE = Mappers.getMapper(BizUnitAssembler.class);

    BizUnitEntity covertEntity(CreateBizUnitCommand bizUnitCommand);

    BizUnitEntity covertEntity(UpdateBizUnitCommand bizUnitCommand);

    List<BizUnitVO> covertVO(List<BizUnitDO> BizUnitDOs);

    BizUnitVO covertVO(BizUnitEntity queryBizUnitEntity);
}