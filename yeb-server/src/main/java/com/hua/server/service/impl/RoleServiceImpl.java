package com.hua.server.service.impl;

import com.hua.server.pojo.RespBean;
import com.hua.server.pojo.Role;
import com.hua.server.mapper.RoleMapper;
import com.hua.server.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author laoHuang
 * @since 2021-03-02
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
