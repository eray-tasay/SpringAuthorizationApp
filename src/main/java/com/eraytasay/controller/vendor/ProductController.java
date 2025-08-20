package com.eraytasay.controller.vendor;

import com.eraytasay.database.dto.ProductSaveDto;
import com.eraytasay.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/vendors/products")
public class ProductController {
    private static final Logger LOGGER = Logger.getLogger(ProductController.class.getName());

    private final ProductService m_productService;

    public ProductController(ProductService productService)
    {
        m_productService = productService;
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String add(ProductSaveDto productSaveDto, Authentication authentication, RedirectAttributes redirectAttributes)
    {
        productSaveDto.setVendorUsername(authentication.getName());

        LOGGER.info("Product save request arrived " + productSaveDto);

        try {
            m_productService.saveProduct(productSaveDto);

            redirectAttributes.addFlashAttribute("alertMessage", "Product is added successfully");
            redirectAttributes.addFlashAttribute("successAlert", true);
        }
        catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Exception occurred while adding product", ex);

            redirectAttributes.addFlashAttribute("alertMessage", "Product could not be added.");
            redirectAttributes.addFlashAttribute("errorAlert", true);
        }

        return "redirect:/vendors/";
    }

    @PostMapping("/delete/{productId}")
    public String delete(@PathVariable("productId") int productId, RedirectAttributes redirectAttributes)
    {
        try {
            m_productService.deleteProduct(productId);

            redirectAttributes.addFlashAttribute("alertMessage", "Product is deleted successfully.");
            redirectAttributes.addFlashAttribute("successAlert", true);
        }
        catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Exception occurred while deleting product with id %d".formatted(productId), ex);

            redirectAttributes.addFlashAttribute("alertMessage", "Product could not be deleted.");
            redirectAttributes.addFlashAttribute("errorAlert", true);
        }

        return "redirect:/vendors/";
    }
}
