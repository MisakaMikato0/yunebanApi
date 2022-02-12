package com.hua.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hua.server.pojo.*;
import com.hua.server.service.IMenuRoleService;
import com.hua.server.service.IMenuService;
import com.hua.server.service.IRoleService;
import com.hua.server.vo.RoleVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限组
 *
 * @Author ahuua
 * @Date 2021/3/6 14:54
 * @Version 1.0
 */
@RestController
@RequestMapping("/system/basic/permission")
public class PermissionController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IMenuRoleService menuRoleService;

    /*@ApiOperation(value = "获取所有角色(分页)")
    @GetMapping("/")
    public DataGridView getAllRoles(RoleVo roleVo) {
        //分页对象
        IPage<Role> page = new Page<>(roleVo.getPage(),roleVo.getSize());
        //查询条件
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.like(!ObjectUtils.isEmpty(roleVo.getNameZh()),"nameZh",roleVo.getName());
        wrapper.like(!ObjectUtils.isEmpty(roleVo.getName()),"name",roleVo.getName());
        roleService.page(page,wrapper);
        return new DataGridView<Role>(page.getTotal(),page.getRecords());
    }*/

    @ApiOperation(value = "获取所有角色")
    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.list();
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/role")
    public RespBean addRoles(@RequestBody Role role){
        if (!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        if (roleService.save(role)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/role/{id}")
    public RespBean removeRole(@PathVariable("id") Integer id){
        if (roleService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    @ApiOperation(value = "根据角色id查询菜单id")
    @GetMapping("/mid/{rid}")
    public List<Integer> getMidByRid(@PathVariable("rid") Integer rid){
        return menuRoleService.list(new QueryWrapper<MenuRole>()
                .eq("rid",rid)).stream().map(MenuRole::getMid).collect(Collectors.toList());
    }

    @ApiOperation(value = "更新角色菜单")
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid,Integer[] mids){
        return menuRoleService.updateMenuRole(rid,mids);
    }


}