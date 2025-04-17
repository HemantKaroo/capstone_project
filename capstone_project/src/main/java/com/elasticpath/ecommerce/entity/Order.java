package com.elasticpath.ecommerce.entity;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private Long id;

    private List<Product> products;

    private BigDecimal totalAmount;
}

