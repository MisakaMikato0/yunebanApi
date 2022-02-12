package com.hua.server.config.filter;

import com.hua.server.pojo.Menu;
import com.hua.server.pojo.Role;
import com.hua.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 权限控制
 * 根据请求Url分析请求所需要的角色
 *
 * @Author ahuua
 * @Date 2021/3/5 13:58
 * @Version 1.0
 */
@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private IMenuService iMenuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获得请求的URL
        String url = ((FilterInvocation) object).getRequestUrl();
        List<Menu> menus = iMenuService.getMenusWithRole();
        for (Menu menu : menus) {
            //判断URL和请求的URL是否匹对
            if (antPathMatcher.match(menu.getUrl(),url)){
                String[] array = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);
                return SecurityConfig.createList(array);
            }
        }
        //没匹配的URL默认登录即可访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}