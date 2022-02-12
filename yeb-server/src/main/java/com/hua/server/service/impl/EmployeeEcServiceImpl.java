package com.hua.server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hua.server.config.mybatis.RespPageBean;
import com.hua.server.mapper.EmployeeMapper;
import com.hua.server.pojo.Employee;
import com.hua.server.pojo.EmployeeEc;
import com.hua.server.mapper.EmployeeEcMapper;
import com.hua.server.service.IEmployeeEcService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author laoHuang
 * @since 2021-03-02
 */
@Service
public class EmployeeEcServiceImpl extends ServiceImpl<EmployeeEcMapper, EmployeeEc> implements IEmployeeEcService {


}
