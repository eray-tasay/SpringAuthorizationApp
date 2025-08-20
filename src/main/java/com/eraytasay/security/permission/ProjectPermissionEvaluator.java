package com.eraytasay.security.permission;

import com.eraytasay.database.repository.IProductRepository;
import com.eraytasay.database.repository.IPurchaseRepository;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ProjectPermissionEvaluator implements PermissionEvaluator {
    private final IProductRepository m_productRepository;
    private final IPurchaseRepository m_purchaseRepository;

    public ProjectPermissionEvaluator(IProductRepository productRepository, IPurchaseRepository purchaseRepository)
    {
        m_productRepository = productRepository;
        m_purchaseRepository = purchaseRepository;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission)
    {
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission)
    {
        // Other target types could be added in the future. For that reason switch statement is used;
        switch (targetType) {
            case "product":
                return evaluateForProduct(authentication, targetId, permission);
            case "purchase":
                return evaluateForPurchase(authentication, targetId, permission);
            default:
                return false;
        }
    }

    private boolean evaluateForProduct(Authentication authentication, Serializable targetId, Object permission)
    {
        var permissionStr = (String)permission;

        // Other permissions could be added in the future. For that reason switch statement is used;
        switch (permissionStr) {
            case "deleteProduct":
                return evaluateForProductDeletion(authentication, targetId);
            default:
                return false;
        }
    }

    private boolean evaluateForProductDeletion(Authentication authentication, Serializable targetId)
    {
        var productId = (int)targetId;
        var productOpt = m_productRepository.findById(productId);

        // There is no problem in terms of authorization.
        if (productOpt.isEmpty())
            return true;

        var product = productOpt.get();

        return product.vendor.username.equals(authentication.getName());
    }

    private boolean evaluateForPurchaseDeletion(Authentication authentication, Serializable targetId)
    {
        var purchaseId = (int)targetId;
        var purchaseOpt = m_purchaseRepository.findById(purchaseId);

        // There is no problem in terms of authorization.
        if (purchaseOpt.isEmpty())
            return true;

        var purchase = purchaseOpt.get();

        return purchase.purchaser.username.equals(authentication.getName());
    }

    private boolean evaluateForPurchase(Authentication authentication, Serializable targetId, Object permission)
    {
        var permissionStr = (String)permission;

        // Other permissions could be added in the future. For that reason switch statement is used;
        switch (permissionStr) {
            case "deletePurchase":
                return evaluateForPurchaseDeletion(authentication, targetId);
            default:
                return false;
        }
    }
}
