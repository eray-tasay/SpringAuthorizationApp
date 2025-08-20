package com.eraytasay.security.userdetailsservice;

import com.eraytasay.database.repository.IPurchaserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component(UserDetailsServiceBeanNames.PURCHASER_DETAILS_SERVICE)
public class PurchaserDetailsService implements UserDetailsService {
    private final IPurchaserRepository m_purchaserRepository;

    public PurchaserDetailsService(IPurchaserRepository purchaserRepository)
    {
        m_purchaserRepository = purchaserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
    {
        var purchaser = m_purchaserRepository.findPurchaserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username %s is not found".formatted(username)));

        return User
                .withUsername(purchaser.username)
                .password(purchaser.password)
                .roles("PURCHASER")
                .build();
    }
}
