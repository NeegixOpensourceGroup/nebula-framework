
package com.neegix.organization.dept.interfaces.controller;

import com.neegix.exception.BusinessRuntimeException;
import com.neegix.organization.dept.application.assembler.DeptAssembler;
import com.neegix.organization.dept.application.cqrs.query.DeptQueryRepository;
import com.neegix.organization.dept.application.service.DeptService;
import com.neegix.organization.dept.domain.entity.DeptEntity;
import com.neegix.organization.dept.interfaces.form.NewDeptForm;
import com.neegix.organization.dept.interfaces.form.QueryDeptForm;
import com.neegix.organization.dept.interfaces.form.UpdateDeptForm;
import com.neegix.organization.dept.interfaces.vo.DeptVO;
import com.neegix.result.Result;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  * @since 2024-12-10 14:48:03
  */

@RestController
@RequestMapping("/api/v1/dept")
public class DeptController {

    @Autowired
    private DeptQueryRepository deptQueryRepository;

    @Autowired
    private DeptService deptService;

    @PreAuthorize("hasAuthority('organization:dept:add')")
    @PostMapping("/bizUnit/{pkBizUnit}")
    public Result<Void> createDept(@PathVariable("pkBizUnit") Long pkBizUnit, @RequestBody @Valid NewDeptForm deptForm){
        DeptEntity deptEntity = DeptAssembler.INSTANCE.covertEntity(deptForm);
        deptEntity.setPkBizUnit(pkBizUnit);
        Void result = deptService.createDept(deptEntity);
        return Result.success("创建成功", result);
    }

    @PreAuthorize("hasAuthority('organization:dept:modify')")
    @PutMapping("/{id}/bizUnit/{pkBizUnit}")
    public Result<Void> updateDept(@PathVariable Long id, @PathVariable Long pkBizUnit, @RequestBody @Valid UpdateDeptForm deptForm){
        DeptEntity deptEntity = DeptAssembler.INSTANCE.covertEntity(deptForm);
        deptEntity.setId(id);
        deptEntity.setPkBizUnit(pkBizUnit);
        Void result = deptService.modifyDept(deptEntity);
        return Result.success("更新成功",result);
    }

    @PreAuthorize("hasAuthority('organization:dept:list')")
    @GetMapping("/bizUnit/{pkBizUnit}")
    public Result<List<DeptVO>> getDepts(@PathVariable("pkBizUnit") Long pkBizUnit, @ModelAttribute QueryDeptForm deptForm){
        if(deptForm == null) {
            deptForm = new QueryDeptForm();
        }
        List<DeptVO> result = deptQueryRepository.findList(pkBizUnit, DeptAssembler.INSTANCE.covertDTO(deptForm));
        return Result.success("查询成功",result);
    }

    @PreAuthorize("hasAuthority('organization:dept:get')")
    @GetMapping("/{id}")
    public Result<DeptVO> getDeptById(@PathVariable("id") Long id) {
        Optional<DeptVO> optional = deptQueryRepository.findById(id);
        return Result.success("获取成功", optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在")));
    }

    @PreAuthorize("hasAuthority('organization:dept:remove')")
    @DeleteMapping
    public Result<Void> removeDept(@RequestBody List<Long> ids){
        return Result.success("删除成功", deptService.removeDept(ids));
    }
}