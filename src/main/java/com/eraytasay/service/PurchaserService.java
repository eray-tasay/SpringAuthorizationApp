package com.eraytasay.service;

import com.eraytasay.database.dal.PurchaserServiceHelper;
import com.eraytasay.database.dto.PurchaserDto;
import com.eraytasay.database.dto.PurchaserSaveDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PurchaserService {
    private final PurchaserServiceHelper m_purchaserServiceHelper;

    @Value("${products.page.size}")
    private int m_pageSize;

    public PurchaserService(PurchaserServiceHelper purchaserServiceHelper)
    {
        m_purchaserServiceHelper = purchaserServiceHelper;
    }

    public PurchaserDto savePurchaser(PurchaserSaveDto purchaserSaveDto)
    {
        return m_purchaserServiceHelper.savePurchaser(purchaserSaveDto);
    }

    public Optional<PurchaserDto> findPurchaserByUsername(String username)
    {
        return m_purchaserServiceHelper.findPurchaserByUsername(username);
    }
}
