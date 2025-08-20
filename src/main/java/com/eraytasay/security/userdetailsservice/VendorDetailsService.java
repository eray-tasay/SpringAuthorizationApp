package com.eraytasay.security.userdetailsservice;

import com.eraytasay.database.repository.IVendorRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component(UserDetailsServiceBeanNames.VENDOR_DETAILS_SERVICE)
public class VendorDetailsService implements UserDetailsService {
    private final IVendorRepository m_vendorRepository;

    public VendorDetailsService(IVendorRepository vendorRepository)
    {
        m_vendorRepository = vendorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
    {
        var vendor = m_vendorRepository.findVendorByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username %s is not found".formatted(username)));

        return User
                .withUsername(vendor.username)
                .password(vendor.password)
                .roles("VENDOR")
                .build();
    }
}
