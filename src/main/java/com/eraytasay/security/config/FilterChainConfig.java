package com.eraytasay.security.config;

import com.eraytasay.security.userdetailsservice.UserDetailsServiceBeanNames;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.PathPatternRequestMatcher;

@Configuration
public class FilterChainConfig {
    @Qualifier(UserDetailsServiceBeanNames.PURCHASER_DETAILS_SERVICE)
    private final UserDetailsService m_purchaserDetailsService;

    @Qualifier(UserDetailsServiceBeanNames.VENDOR_DETAILS_SERVICE)
    private final UserDetailsService m_vendorDetailsService;

    @Qualifier(UserDetailsServiceBeanNames.ADMIN_DETAILS_SERVICE)
    private final UserDetailsService m_adminDetailsService;

    public FilterChainConfig(UserDetailsService purchaserDetailsService, UserDetailsService vendorDetailsService, UserDetailsService adminDetailsService)
    {
        m_purchaserDetailsService = purchaserDetailsService;
        m_vendorDetailsService = vendorDetailsService;
        m_adminDetailsService = adminDetailsService;
    }

    @Bean
    @Order(1)
    public SecurityFilterChain purchaserSecurityFilterChain(HttpSecurity http) throws Exception
    {
        http.securityMatcher("/purchasers/**");

        http.userDetailsService(m_purchaserDetailsService);

        http.formLogin(c -> c
                .loginPage("/purchasers/login")
                .loginProcessingUrl("/purchasers/login")
                .defaultSuccessUrl("/purchasers/", true)
        );

        http.logout(c -> c
                .logoutUrl("/purchasers/logout")
                .logoutSuccessUrl("/?logout")
        );

        var baseMatcher = PathPatternRequestMatcher.withDefaults().basePath("/purchasers");

        http.authorizeHttpRequests(c -> c
                .requestMatchers(baseMatcher.matcher("/register"), baseMatcher.matcher("/login")).permitAll()
                .anyRequest().hasRole("PURCHASER"));

        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain vendorSecurityFilterChain(HttpSecurity http) throws Exception
    {
        http.securityMatcher("/vendors/**");

        http.userDetailsService(m_vendorDetailsService);

        http.formLogin(c -> c
                .loginPage("/vendors/login")
                .loginProcessingUrl("/vendors/login")
                .defaultSuccessUrl("/vendors/", true)
        );

        http.logout(c -> c
                .logoutUrl("/vendors/logout")
                .logoutSuccessUrl("/?logout")
        );

        var baseMatcher = PathPatternRequestMatcher.withDefaults().basePath("/vendors");

        http.authorizeHttpRequests(c -> c
                .requestMatchers(baseMatcher.matcher("/register"), baseMatcher.matcher("/login")).permitAll()
                .anyRequest().hasRole("VENDOR"));

        return http.build();
    }

    @Bean
    @Order(3)
    public SecurityFilterChain adminSecurityFilterChain(HttpSecurity http) throws Exception
    {
        http.securityMatcher("/admin/**");

        http.userDetailsService(m_adminDetailsService);

        http.formLogin(c -> c
                .loginPage("/admin/login")
                .loginProcessingUrl("/admin/login")
                .defaultSuccessUrl("/admin/", true)
        );

        http.logout(c -> c
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/?logout")
        );

        var baseMatcher = PathPatternRequestMatcher.withDefaults().basePath("/admin");

        http.authorizeHttpRequests(c -> c
                .requestMatchers(baseMatcher.matcher("/login")).permitAll()
                .anyRequest().hasRole("ADMIN"));

        return http.build();
    }
}
