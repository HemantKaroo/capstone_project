package com.elasticpath.ecommerce.controller;

import com.elasticpath.ecommerce.config.AppConfig;
import com.elasticpath.ecommerce.entity.Product;
import com.elasticpath.ecommerce.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ecommerce/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private AppConfig appConfig;

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAll(@RequestParam(required = false) String storeType) {
        return ResponseEntity.ok(storeType != null ? productService.findByStoreType(storeType) : productService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Product> create(@RequestBody Product product) {
         productService.save(product);
         return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/ex")
    public String getExtenalProduct() {
        return appConfig.getExternalProducts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam Long productId, HttpSession session, RedirectAttributes redirectAttributes,Model model) {
        Product product = productService.getById(productId);

        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        cart.add(product);
        session.setAttribute("cart", cart);
        BigDecimal total = BigDecimal.ZERO;
        for (Product p : cart) {
            total = total.add(p.getPrice()); // use add() for BigDecimal
        }
        redirectAttributes.addFlashAttribute("message", product.getName() + " added to cart!");
        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        return "cart";
    }

    @PostMapping("/place-order")
    public String placeOrder(HttpSession session, RedirectAttributes attrs) {
        // Clear cart
        session.removeAttribute("cart");
        // Optionally add flash message
        attrs.addFlashAttribute("orderSuccess", true);
        return "order";
    }
}
