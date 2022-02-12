package com.hua.server.mapper;

import com.hua.server.pojo.MenuRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hua.server.pojo.RespBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author laoHuang
 * @since 2021-03-02
 */

public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
