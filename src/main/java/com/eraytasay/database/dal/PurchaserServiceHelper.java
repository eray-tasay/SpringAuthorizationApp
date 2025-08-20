package com.eraytasay.database.dal;

import com.eraytasay.database.dto.PurchaserDto;
import com.eraytasay.database.dto.PurchaserSaveDto;
import com.eraytasay.database.mapper.ProductMapper;
import com.eraytasay.database.mapper.PurchaserMapper;
import com.eraytasay.database.repository.IProductRepository;
import com.eraytasay.database.repository.IPurchaserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PurchaserServiceHelper {
    private final IPurchaserRepository m_purchaserRepository;
    private final PurchaserMapper m_purchaserMapper;
    private final PasswordEncoder m_passwordEncoder;

    public PurchaserServiceHelper(IPurchaserRepository purchaserRepository, PurchaserMapper purchaserMapper, PasswordEncoder passwordEncoder)
    {
        m_purchaserRepository = purchaserRepository;
        m_purchaserMapper = purchaserMapper;
        m_passwordEncoder = passwordEncoder;
    }

    public Optional<PurchaserDto> findPurchaserByUsername(String username)
    {
        return m_purchaserRepository.findPurchaserViewByUsername(username).map(m_purchaserMapper::toPurchaserDto);
    }

    public PurchaserDto savePurchaser(PurchaserSaveDto purchaserSaveDto)
    {
        var purchaser = m_purchaserMapper.toPurchaser(purchaserSaveDto, m_passwordEncoder);

         return m_purchaserMapper.toPurchaserDto(m_purchaserRepository.save(purchaser));
    }
}
