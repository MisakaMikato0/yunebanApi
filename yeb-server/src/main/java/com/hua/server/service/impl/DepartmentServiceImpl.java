package com.hua.server.service.impl;

import com.hua.server.pojo.Department;
import com.hua.server.mapper.DepartmentMapper;
import com.hua.server.pojo.RespBean;
import com.hua.server.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author laoHuang
 * @since 2021-03-02
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 获取所有部门
     * @return
     */
    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments(-1);
    }

    /**
     * 添加部门
     * @param department
     * @return
     */
    @Override
    public RespBean addDep(Department department) {
        department.setEnabled(true);
        departmentMapper.addDep(department);
        if (1==department.getResult()){
            return RespBean.success("添加成功",department);
        }
        return RespBean.error("添加失败");
    }

    /**
     * 删除部门
     * @return
     * @param id
     */
    @Override
    public RespBean deleteDep(Integer id){
        Department dep = new Department();
        dep.setId(id);
        departmentMapper.deleteDep(dep);
        if (-2==dep.getResult()){
            return RespBean.error("该部门下还有子部门，删除失败");
        }
        if (-1==dep.getResult()){
            return RespBean.error("该部门下还有员工,删除失败");
        }
        return RespBean.success("删除成功");
    }
}
