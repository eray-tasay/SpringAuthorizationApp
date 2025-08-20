package com.eraytasay.controller.purchaser;

import com.eraytasay.database.dto.PurchaserSaveDto;
import com.eraytasay.service.ProductService;
import com.eraytasay.service.PurchaseService;
import com.eraytasay.service.PurchaserService;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
@RequestMapping("/purchasers")
public class PurchaserController {
    private static final Logger LOGGER = Logger.getLogger(PurchaserController.class.getName());

    private final PurchaserService m_purchaserService;
    private final ProductService m_productService;
    private final PurchaseService m_purchaseService;

    public PurchaserController(PurchaserService purchaserService, ProductService productService, PurchaseService purchaseService)
    {
        m_purchaserService = purchaserService;
        m_productService = productService;
        m_purchaseService = purchaseService;
    }

    @GetMapping("/register")
    public String registerGet()
    {
        return "purchaser-register";
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String registerPost(PurchaserSaveDto purchaserSaveDto)
    {
        LOGGER.info("Purchaser registration request arrived: " + purchaserSaveDto);

        m_purchaserService.savePurchaser(purchaserSaveDto);

        return "redirect:/purchasers/login?register";
    }

    @GetMapping("/login")
    public String login()
    {
        return "purchaser-login";
    }

    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "0") int page, Model model, Authentication authentication)
    {
        model.addAttribute("productPage", m_productService.findVendorProducts(page));
        model.addAttribute("purchases", m_purchaseService.findPurchasesByPurchaserUsername(authentication.getName()));

        return "purchaser-home";
    }
}
