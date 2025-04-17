package com.elasticpath.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.elasticpath.ecommerce.entity.Catalog;

@Service
public class CatalogService {

    private List<Catalog> catalogList = new ArrayList<>();
    public Catalog createCatalog(Catalog catalog) {
        catalogList.add(catalog);
        return catalog;
    }

    public List<Catalog> getAllCatalogs() {
        return catalogList;
    }

    public List<Catalog> getCatalogsByStoreType(String storeType) {
        return catalogList.stream().filter(catalog->catalog.getStoreType().equalsIgnoreCase(storeType)).toList();
    }

    public Catalog getCatalogById(Long id) {
        return catalogList.stream().filter(catalog->catalog.getId().equals(id)).findFirst().get();
    }

    public void deleteCatalog(Long id) {

    }
}