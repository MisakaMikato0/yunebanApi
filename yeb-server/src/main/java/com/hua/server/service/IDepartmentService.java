package com.hua.server.service;

import com.hua.server.pojo.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author laoHuang
 * @since 2021-03-02
 */
public interface IDepartmentService extends IService<Department> {



    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments();

    /**
     * 添加部门
     * @param department
     * @return
     */
    RespBean addDep(Department department);

    RespBean deleteDep(Integer id);
}
