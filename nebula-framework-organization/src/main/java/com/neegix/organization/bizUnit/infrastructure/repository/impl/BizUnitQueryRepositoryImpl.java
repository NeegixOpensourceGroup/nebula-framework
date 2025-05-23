package com.neegix.organization.bizUnit.infrastructure.repository.impl;

import com.neegix.application.query.NebulaSQL;
import com.neegix.organization.bizUnit.application.assembler.BizUnitAssembler;
import com.neegix.organization.bizUnit.application.cqrs.query.BizUnitQueryRepository;
import com.neegix.organization.bizUnit.application.cqrs.query.condition.BizUnitWhereGroup;
import com.neegix.organization.bizUnit.application.dto.BizUnitDTO;
import com.neegix.organization.bizUnit.infrastructure.repository.convert.BizUnitConverter;
import com.neegix.organization.bizUnit.infrastructure.repository.dataobject.BizUnitDO;
import com.neegix.organization.bizUnit.infrastructure.repository.mapper.BizUnitMapper;
import com.neegix.organization.bizUnit.infrastructure.repository.mapper.customized.BizUnitCustomizedMapper;
import com.neegix.organization.bizUnit.interfaces.vo.BizUnitVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

@Repository
public class BizUnitQueryRepositoryImpl implements BizUnitQueryRepository {

    @Autowired
    private BizUnitMapper bizUnitMapper;

    @Autowired
    private BizUnitCustomizedMapper bizUnitCustomizedMapper;

    @Override
    public Optional<BizUnitVO> findById(Long id) {
        BizUnitDO bizUnitDO = bizUnitMapper.selectByPrimaryKey(id);
        return Optional.ofNullable(BizUnitAssembler.INSTANCE.covertVO(BizUnitConverter.INSTANCE.covertDTO(bizUnitDO)));
    }

    @Override
    public Integer selectCount(List<Long> ids) {
        return bizUnitCustomizedMapper.selectCountByIds(ids);
    }

    @Override
    public List<BizUnitVO> findList(BizUnitDTO bizUnitDTO) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(BizUnitWhereGroup.class)
           .andIdEqualTo(bizUnitDTO.getId())
           .andCreateTimeBetween(bizUnitDTO.getStartCreateTime(),bizUnitDTO.getEndCreateTime())
           .andUpdateTimeBetween(bizUnitDTO.getStartUpdateTime(),bizUnitDTO.getEndUpdateTime())
           .andCreateUserEqualTo(bizUnitDTO.getCreateUser())
           .andUpdateUserEqualTo(bizUnitDTO.getUpdateUser())
           .andPidEqualTo(bizUnitDTO.getPid())
           .andCodeLikeTo(bizUnitDTO.getCode())
           .andNameLikeTo(bizUnitDTO.getName())
           .andAbbreviationLikeTo(bizUnitDTO.getAbbreviation())
           .andTelLikeTo(bizUnitDTO.getTel())
           .andManagerLikeTo(bizUnitDTO.getManager())
           .andMobilePhoneLikeTo(bizUnitDTO.getMobilePhone())
           .andRemarkLikeTo(bizUnitDTO.getRemark())
           .andTypeEqualTo(bizUnitDTO.getType())
           .andEnabledEqualTo(bizUnitDTO.getEnabled())
           .andDeletedEqualTo(bizUnitDTO.getDeleted());

        List<BizUnitDO> result = bizUnitMapper.selectList(nebulaSQL);

        return BizUnitAssembler.INSTANCE.covertVO(BizUnitConverter.INSTANCE.covertDTOS(result));
    }
}
