package com.huangzh.orderservice.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author: night-wind
 * @Date: 2021/3/24 20:18
 */
@Slf4j
@Component
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("项目初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("项目处理");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("项目销毁");
    }
}
