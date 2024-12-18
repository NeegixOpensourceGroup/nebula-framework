
package com.neegix.system.user.interfaces.controller;

import com.neegix.base.PageVO;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.result.Result;
import com.neegix.system.user.application.assembler.UserAssembler;
import com.neegix.system.user.application.cqrs.query.UserQueryRepository;
import com.neegix.system.user.domain.entity.UserEntity;
import com.neegix.system.user.interfaces.vo.UserVO;
import com.neegix.system.user.application.service.UserService;
import com.neegix.system.user.interfaces.form.NewUserForm;
import com.neegix.system.user.interfaces.form.QueryUserForm;
import com.neegix.system.user.interfaces.form.UpdateUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

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
  * @since 2024-12-03 11:47:28
  */

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserQueryRepository userQueryRepository;

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('system:user:add')")
    @PostMapping
    public Result<Void> createUser(@RequestBody NewUserForm userForm){
        Void result = userService.createUser(UserAssembler.INSTANCE.covertEntity(userForm));
        return Result.success("创建成功", result);
    }

    @PreAuthorize("hasAuthority('system:user:modify')")
    @PutMapping("/{id}")
    public Result<Void> updateUser(@PathVariable Long id, @RequestBody UpdateUserForm userForm){
        UserEntity userEntity = UserAssembler.INSTANCE.covertEntity(userForm);
        userEntity.setId(id);
        Void result = userService.modifyUser(userEntity);
        return Result.success("更新成功",result);
    }

    @PreAuthorize("hasAuthority('system:user:list')")
    @GetMapping("/{currentPage}/{pageSize}")
    public Result<PageVO<UserVO>> getUsers(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize, @ModelAttribute QueryUserForm userForm){
        if(userForm == null) {
            userForm = new QueryUserForm();
        }
        PageVO<UserVO> pageVO = userQueryRepository.findPage(currentPage, pageSize, UserAssembler.INSTANCE.covertDTO(userForm));
        return Result.success("查询成功",pageVO);
    }

    @PreAuthorize("hasAuthority('system:user:get')")
    @GetMapping("/{id}")
    public Result<UserVO> getUserById(@PathVariable("id") Long id) {
        Optional<UserVO> optional = userQueryRepository.findById(id);
        return Result.success("获取成功", optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在")));
    }

    @PreAuthorize("hasAuthority('system:user:remove')")
    @DeleteMapping
    public Result<Void> removeUser(@RequestBody List<Long> ids){
        return Result.success("删除成功", userService.removeUser(ids));
    }
}