package com.neegix.organization.bizUnit.application.assembler;

import com.neegix.organization.bizUnit.application.dto.BizUnitDTO;
import com.neegix.organization.bizUnit.interfaces.vo.BizUnitVO;
import com.neegix.organization.bizUnit.domain.entity.BizUnitEntity;
import com.neegix.organization.bizUnit.interfaces.form.NewBizUnitForm;
import com.neegix.organization.bizUnit.interfaces.form.QueryBizUnitForm;
import com.neegix.organization.bizUnit.interfaces.form.UpdateBizUnitForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "createUser", ignore = true)
    @Mapping(target = "updateUser", ignore = true)
    BizUnitEntity covertEntity(NewBizUnitForm newBizUnitForm);

    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "createUser", ignore = true)
    @Mapping(target = "updateUser", ignore = true)
    BizUnitEntity covertEntity(UpdateBizUnitForm updateBizUnitForm);

    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    BizUnitDTO covertDTO(QueryBizUnitForm queryBizUnitForm);

    List<BizUnitVO> covertVO(List<BizUnitDTO> BizUnitDTOs);

    BizUnitVO covertVO(BizUnitDTO queryBizUnitDTO);
}