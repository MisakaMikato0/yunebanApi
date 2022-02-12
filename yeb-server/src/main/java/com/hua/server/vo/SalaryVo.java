package com.hua.server.vo;

import com.hua.server.pojo.Salary;
import lombok.Data;

/**
 * @author mornd
 * @date 2021/2/24 - 13:18
 */
@Data
public class SalaryVo extends Salary {
    private Integer page;
    private Integer size;
}
