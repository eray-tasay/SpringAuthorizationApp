package com.eraytasay.controller.purchaser;

import com.eraytasay.database.dto.PurchaseSaveDto;
import com.eraytasay.service.PurchaseService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/purchasers")
public class PurchaseController {
    private final static Logger LOGGER = Logger.getLogger(PurchaserController.class.getName());

    private final PurchaseService m_purchaseService;

    public PurchaseController(PurchaseService purchaseService)
    {
        m_purchaseService = purchaseService;
    }

    @PostMapping("/buy/products/{productId}")
    public String purchaseProduct(@PathVariable("productId") int productId, Authentication authentication,
                                  RedirectAttributes redirectAttributes)
    {
        var purchaseSaveDto = new PurchaseSaveDto();

        purchaseSaveDto.productId = productId;
        purchaseSaveDto.purchaserUsername = authentication.getName();

        try {
            m_purchaseService.savePurchase(purchaseSaveDto);

            redirectAttributes.addFlashAttribute("alertMessage", "Product is bought successfully.");
            redirectAttributes.addFlashAttribute("successAlert", true);

            return "redirect:/purchasers/";
        }
        catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Exception occurred while saving purchase", ex);

            redirectAttributes.addFlashAttribute("alertMessage", "Product could not be bought.");
            redirectAttributes.addFlashAttribute("errorAlert", true);

            return "redirect:/purchasers/";
        }
    }

    @PostMapping("/delete/purchase/{purchaseId}")
    public String deletePurchase(@PathVariable("purchaseId") int purchaseId, RedirectAttributes redirectAttributes)
    {
        try {
            m_purchaseService.deletePurchase(purchaseId);

            redirectAttributes.addFlashAttribute("alertMessage", "Purchase is deleted successfully.");
            redirectAttributes.addFlashAttribute("successAlert", true);

            return "redirect:/purchasers/";
        }
        catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Exception occurred while deleting purchase with id %d".formatted(purchaseId), ex);

            redirectAttributes.addFlashAttribute("alertMessage", "Purchase could not be deleted.");
            redirectAttributes.addFlashAttribute("errorAlert", true);

            return "redirect:/purchasers/";
        }
    }
}
