package com.eraytasay.security.config;

import com.eraytasay.security.userdetailsservice.UserDetailsServiceBeanNames;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserManagementConfig {
    @Value("${admin.register.credentials}")
    private List<String> m_adminCredentials;

    @Bean(UserDetailsServiceBeanNames.ADMIN_DETAILS_SERVICE)
    public UserDetailsService adminDetailsService()
    {
        return new InMemoryUserDetailsManager(parseAdmins());
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    private List<UserDetails> parseAdmins()
    {
        var passwordEncoder = passwordEncoder();
        var res = new ArrayList<UserDetails>();

        for (var credential : m_adminCredentials) {
            var temp = credential.split(":");
            var username = temp[0];
            var password = temp[1];

            res.add(User
                    .withUsername(username)
                    .password(password)
                    .passwordEncoder(passwordEncoder::encode)
                    .roles("ADMIN")
                    .build()
            );
        }
        return res;
    }
}
