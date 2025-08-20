package com.eraytasay.controller.vendor;

import com.eraytasay.database.dto.VendorSaveDto;
import com.eraytasay.service.ProductService;
import com.eraytasay.service.VendorService;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/vendors")
public class VendorController {
    private static final Logger LOGGER = Logger.getLogger(VendorController.class.getName());

    private final VendorService m_vendorService;

    public VendorController(VendorService vendorService)
    {
        m_vendorService = vendorService;
    }

    @GetMapping("/register")
    public String registerGet()
    {
        return "vendor-register";
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String registerPost(VendorSaveDto vendorSaveDto)
    {
        LOGGER.info("Vendor registration request arrived: " + vendorSaveDto);

        m_vendorService.saveVendor(vendorSaveDto);

        return "redirect:/vendors/login?register";
    }

    @GetMapping("/login")
    public String login()
    {
        return "vendor-login";
    }

    @GetMapping("/")
    public String home(Authentication authentication, Model model)
    {
        model.addAttribute("products", m_vendorService.findProductsByVendorUsername(authentication.getName()));

        return "vendor-home";
    }
}
