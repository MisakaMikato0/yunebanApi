package com.hua.server.service;

import com.hua.server.pojo.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author laoHuang
 * @since 2021-03-02
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
