package com.eraytasay.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Configuration
@EnableMethodSecurity
public class MethodSecurityConfig {
    private final PermissionEvaluator m_permissionEvaluator;

    public MethodSecurityConfig(PermissionEvaluator permissionEvaluator)
    {
        m_permissionEvaluator = permissionEvaluator;
    }

    @Bean
    public MethodSecurityExpressionHandler methodSecurityExpressionHandler()
    {
        var res = new DefaultMethodSecurityExpressionHandler();

        res.setPermissionEvaluator(m_permissionEvaluator);
        return res;
    }
}
