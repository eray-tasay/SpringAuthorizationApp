package com.eraytasay.database.dal;

import com.eraytasay.database.dto.PurchaseDto;
import com.eraytasay.database.exception.ProductNotFoundException;
import com.eraytasay.database.dto.PurchaseSaveDto;
import com.eraytasay.database.entity.Purchase;
import com.eraytasay.database.mapper.PurchaseMapper;
import com.eraytasay.database.repository.IProductRepository;
import com.eraytasay.database.repository.IPurchaseRepository;
import com.eraytasay.database.repository.IPurchaserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PurchaseServiceHelper {
    private final IPurchaseRepository m_purchaseRepository;
    private final IProductRepository m_productRepository;
    private final IPurchaserRepository m_purchaserRepository;
    private final PurchaseMapper m_purchaseMapper;

    public PurchaseServiceHelper(IPurchaseRepository purchaseRepository, IProductRepository productRepository, IPurchaserRepository purchaserRepository, PurchaseMapper purchaseMapper)
    {
        m_purchaseRepository = purchaseRepository;
        m_productRepository = productRepository;
        m_purchaserRepository = purchaserRepository;
        m_purchaseMapper = purchaseMapper;
    }

    public void savePurchase(PurchaseSaveDto purchaseSaveDto)
    {
        var product = m_productRepository.findById(purchaseSaveDto.productId).orElseThrow(
                () -> new ProductNotFoundException("product with id %d is not found".formatted(purchaseSaveDto.productId)));
        var purchaserOpt = m_purchaserRepository.findPurchaserByUsername(purchaseSaveDto.purchaserUsername);

        assert(purchaserOpt.isPresent());

        var purchase = new Purchase();

        purchase.product = product;
        purchase.purchaser = purchaserOpt.get();

        m_purchaseRepository.save(purchase);
    }

    public List<PurchaseDto> findPurchasesByPurchaserUsername(String username)
    {
        return m_purchaseRepository.findPurchasesByPurchaserUsername(username).stream()
                .map(m_purchaseMapper::toPurchaseDto)
                .toList();
    }

    public void deletePurchase(int purchaseId)
    {
        m_purchaseRepository.deleteById(purchaseId);
    }
}
