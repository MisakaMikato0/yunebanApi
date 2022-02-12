package com.hua.server.utils;

import com.hua.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Admin工具类
 *
 * @Author ahuua
 * @Date 2021/3/8 15:08
 * @Version 1.0
 */
public class AdminUtils {

    /**
     * 获取当前操作员
     * @return
     */
    public static Admin getCurrentAdmin(){
        return (Admin) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
    }


}