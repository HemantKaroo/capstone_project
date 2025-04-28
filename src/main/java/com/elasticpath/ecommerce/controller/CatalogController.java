package com.elasticpath.ecommerce.controller;

import com.elasticpath.ecommerce.entity.Catalog;
import com.elasticpath.ecommerce.service.CatalogService;
import com.elasticpath.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ecommerce/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String viewHome(Model model) {
        model.addAttribute("catalogs", catalogService.getAllCatalogs());
        return "home"; // maps to home.html
    }

    @GetMapping("/product-by-store-type")
    public String viewProducts(@RequestParam("storeType") String type, Model model) {
        model.addAttribute("product", productService.findByStoreType(type));
        model.addAttribute("catalogType", type);
        return "products"; // maps to products.html
    }
    
  
    @GetMapping("/getAll")
    public ResponseEntity<List<Catalog>> getAllCatalogs() {
        return ResponseEntity.ok(catalogService.getAllCatalogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Catalog> getCatalogById(@PathVariable Long id) {
        return catalogService.getAllCatalogs().stream().filter(c -> c.getId().equals(id)).findFirst()
                .map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // POST create new catalog
    @PostMapping("/add-new-catalog")
    public ResponseEntity<Catalog> createCatalog(@RequestBody Catalog catalog) {
        catalogService.createCatalog(catalog);
        return ResponseEntity.status(HttpStatus.CREATED).body(catalog);
    }
}

