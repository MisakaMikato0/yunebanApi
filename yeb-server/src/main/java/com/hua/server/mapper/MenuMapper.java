package com.hua.server.mapper;

import com.hua.server.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hua.server.pojo.Role;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author laoHuang
 * @since 2021-03-02
 */

public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据用户id查询菜单列表
     * @return id
     */
    List<Menu> getMenuByAdminId(Integer id);

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();

    List<Menu> getAllMenus();
}
