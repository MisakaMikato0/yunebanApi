package com.hua.server.service;

import com.hua.server.config.mybatis.RespPageBean;
import com.hua.server.pojo.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.server.pojo.RespBean;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author laoHuang
 * @since 2021-03-02
 */
public interface IEmployeeService extends IService<Employee> {

    /**
     * 获取所有员工(分页)
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDateScope
     * @return
     */
    RespPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);

    /**
     * 获取工号
     * @return
     */
    RespBean MaxWorkID();

    /**
     * 添加员工
     * @param employee
     * @return
     */
    RespBean addEmp(Employee employee);

    /**
     * 根据id获取员工
     * @param id
     * @return
     */
    List<Employee> getEmployees(Integer id);

    /**
     * 获取所有工资账套
     * @param currentPage
     * @param size
     * @return
     */
    RespPageBean getEmployeeWithSalary(Integer currentPage, Integer size);
}
