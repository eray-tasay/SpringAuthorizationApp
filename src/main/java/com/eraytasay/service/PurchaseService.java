package com.eraytasay.service;

import com.eraytasay.database.dal.PurchaseServiceHelper;
import com.eraytasay.database.dto.PurchaseDto;
import com.eraytasay.database.dto.PurchaseSaveDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PurchaseService {
    private final PurchaseServiceHelper m_purchaseServiceHelper;

    public PurchaseService(PurchaseServiceHelper purchaseServiceHelper)
    {
        m_purchaseServiceHelper = purchaseServiceHelper;
    }

    public void savePurchase(PurchaseSaveDto purchaseSaveDto)
    {
        m_purchaseServiceHelper.savePurchase(purchaseSaveDto);
    }

    public List<PurchaseDto> findPurchasesByPurchaserUsername(String username)
    {
        return m_purchaseServiceHelper.findPurchasesByPurchaserUsername(username);
    }

    @PreAuthorize("hasPermission(#purchaseId, 'purchase', 'deletePurchase')")
    public void deletePurchase(int purchaseId)
    {
        m_purchaseServiceHelper.deletePurchase(purchaseId);
    }
}
