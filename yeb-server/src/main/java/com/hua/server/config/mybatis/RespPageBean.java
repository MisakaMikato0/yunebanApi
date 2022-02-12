package com.hua.server.config.mybatis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * mybatis分页工具类
 *
 * @Author ahuua
 * @Date 2021/3/8 17:46
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespPageBean {

    /**
     * 总条数
     */
    private Long total;

    /**
     * 数据
     */
    private List<?> data;
}