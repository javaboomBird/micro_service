package com.huangzh.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author huangzh
 * @date 2021/3/2
 */
@Configuration
public class GatewayConfig {

    @Bean
    public KeyResolver ipKeyResolver() {
        return new KeyResolver() {

            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                // 获取请求的 IP
                return Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
            }

        };
    }
}
