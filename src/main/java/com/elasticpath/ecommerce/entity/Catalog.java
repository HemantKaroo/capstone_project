package com.elasticpath.ecommerce.entity;

public class Catalog {
    private Long catalogId;
    private String catalogName;
    private String storeType;
    public Long getId() {
        return catalogId;
    }
    public void setId(Long id) {
        this.catalogId = id;
    }
    public String getName() {
        return catalogName;
    }
    public void setName(String name) {
        this.catalogName = name;
    }
    public String getStoreType() {
        return storeType;
    }
    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

}
