package com.github.pettyfer.basic.basicinfoserver.rest;


import com.github.pettyfer.basic.basicinfoserver.service.ISystemUserService;
import com.github.pettyfer.basic.common.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-27
 */
@RestController
@RequestMapping("/user")
public class SystemUserController {

    @Autowired
    private ISystemUserService systemUserService;

    /**
     * 通过用户名查询用户及其角色信息
     *
     * @param username 用户名
     * @return UseVo 对象
     */
    @GetMapping("/findUserByUsername/{username}")
    public UserVo findUserByUsername(@PathVariable String username) {
        return systemUserService.findUserByUsername(username);
    }
}

