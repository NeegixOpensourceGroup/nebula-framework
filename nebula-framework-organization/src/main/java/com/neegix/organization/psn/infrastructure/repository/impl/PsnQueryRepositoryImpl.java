package com.neegix.organization.psn.infrastructure.repository.impl;

import com.neegix.application.query.NebulaSQL;
import com.neegix.base.PageVO;
import com.neegix.organization.psn.application.assembler.PsnAssembler;
import com.neegix.organization.psn.application.cqrs.query.PsnQueryRepository;
import com.neegix.organization.psn.application.cqrs.query.condition.PsnWhereGroup;
import com.neegix.organization.psn.application.dto.PsnDTO;
import com.neegix.organization.psn.infrastructure.repository.convert.PsnConverter;
import com.neegix.organization.psn.infrastructure.repository.convert.PsnWorkInfoConverter;
import com.neegix.organization.psn.infrastructure.repository.dataobject.PsnDO;
import com.neegix.organization.psn.infrastructure.repository.dataobject.PsnWorkInfoDO;
import com.neegix.organization.psn.infrastructure.repository.mapper.PsnMapper;
import com.neegix.organization.psn.infrastructure.repository.mapper.customized.PsnCustomizedMapper;
import com.neegix.organization.psn.infrastructure.repository.mapper.customized.PsnWorkInfoCustomizedMapper;
import com.neegix.organization.psn.interfaces.vo.PsnVO;
import com.neegix.organization.psn.interfaces.vo.PsnWorkInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

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

@Repository
public class PsnQueryRepositoryImpl implements PsnQueryRepository {

    @Autowired
    private PsnMapper psnMapper;

    @Autowired
    private PsnCustomizedMapper psnCustomizedMapper;

    @Autowired
    private PsnWorkInfoCustomizedMapper psnWorkInfoCustomizedMapper;

    @Override
    public Optional<PsnVO> findById(Long id) {
        PsnDO psnDO = psnMapper.selectByPrimaryKey(id);
        List<PsnWorkInfoDO> psnWorkInfoDOS = psnWorkInfoCustomizedMapper.selectPsnWorkInfos(id);
        PsnDTO psnDTO = PsnConverter.INSTANCE.covertDTO(psnDO);
        psnDTO.setPsnWorkInfos(PsnWorkInfoConverter.INSTANCE.covertDTOS(psnWorkInfoDOS));
        PsnVO psnVO = PsnAssembler.INSTANCE.covertVO(psnDTO);
        List<PsnWorkInfoVO> list = psnVO.getPsnWorkInfos();
        // 假设PsnWorkInfo是你的类，并且有一个setId方法

        // 使用IntStream.range来生成索引流，然后使用forEach来设置每个元素的ID
        IntStream.range(0, list.size())
                .forEach(index -> list.get(index).setId(index)); // 直接在原列表上设置ID为当前索引值
        return Optional.of(psnVO);
    }

    @Override
    public Integer selectCount(List<Long> ids) {
        return psnCustomizedMapper.selectCountByIds(ids);
    }

    @Override
    public PageVO<PsnVO> findPage(Integer currentPage, Integer pageSize, Long pkBizUnit, Long pkDept, PsnDTO psnDTO) {
        List<Long> pkPsn = psnWorkInfoCustomizedMapper.selectPsnPkByBizUnitAndDept(pkBizUnit, pkDept);
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(PsnWhereGroup.class)
           .andBirthLikeTo(psnDTO.getBirth())
           .andCodeLikeTo(psnDTO.getCode())
           .andContactTelLikeTo(psnDTO.getContactTel())
           .andCreateTimeBetween(psnDTO.getStartCreateTime(),psnDTO.getEndCreateTime())
           .andCreateUserEqualTo(psnDTO.getCreateUser())
           .andDeletedEqualTo(psnDTO.getDeleted())
           .andEmailLikeTo(psnDTO.getEmail())
           .andEnabledEqualTo(psnDTO.getEnabled())
           .andGenderEqualTo(psnDTO.getGender())
           .andHireDateLikeTo(psnDTO.getHireDate())
           .andHomeAddressLikeTo(psnDTO.getHomeAddress())
           .andHomeTelLikeTo(psnDTO.getHomeTel())
           .andIdIn(pkPsn)
           .andIdNoLikeTo(psnDTO.getIdNo())
           .andIdTypeEqualTo(psnDTO.getIdType())
           .andMobilePhoneLikeTo(psnDTO.getMobilePhone())
           .andNameLikeTo(psnDTO.getName())
           .andNicknameLikeTo(psnDTO.getNickname())
           .andPkBizUnitEqualTo(psnDTO.getPkBizUnit())
           .andUpdateTimeBetween(psnDTO.getStartUpdateTime(),psnDTO.getEndUpdateTime())
           .andUpdateUserEqualTo(psnDTO.getUpdateUser());
           
        nebulaSQL.setPager(currentPage, pageSize);
        List<PsnDO> result = psnMapper.selectList(nebulaSQL);
        Long total = psnMapper.selectCount(nebulaSQL);
        PageVO<PsnVO> page = new PageVO<>(currentPage, pageSize);
        page.setTotal(total);
        page.setResult(PsnAssembler.INSTANCE.covertVO(PsnConverter.INSTANCE.covertDTOS(result)));
        return page;
    }
}