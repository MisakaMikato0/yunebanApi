package com.hua.server.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hua.server.pojo.Department;
import com.hua.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author laoHuang
 * @since 2021-03-02
 */

public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments(Integer id);

    /**
     * 添加部门
     * @param department
     */
    void addDep(Department department);

    void deleteDep(Department department);
}
