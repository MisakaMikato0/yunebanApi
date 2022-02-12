package com.hua.server.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hua.server.pojo.AdminRole;
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

public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    /**
     * 更新操作员角色
     * @param adminId
     * @param rids
     * @return
     */
    Integer updateAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
