package com.hua.server.controller;

import com.hua.server.pojo.Admin;
import com.hua.server.pojo.AdminLoginParam;
import com.hua.server.pojo.RespBean;
import com.hua.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * 登录
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {

    @Autowired
    private IAdminService iAdminService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLoginParam admin, HttpServletRequest request){
        return iAdminService.login(admin.getUsername(),admin.getPassword(),admin.getCode(),request);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal){
        if (null==principal){
            return null;
        }
        String username = principal.getName();
        Admin admin = iAdminService.getAdminByUserName(username);
        admin.setPassword(null);
        admin.setRoles(iAdminService.getRoleByAdminId(admin.getId()));
        return admin;
    }

}
