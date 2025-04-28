package com.elasticpath.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.elasticpath.ecommerce.entity.Product;

@Service
public class ProductService {

	private List<Product> productList = new ArrayList<>();

	public List<Product> findAllProduct() {
		return productList;
	}

	public List<Product> findByStoreType(String storeType) {
		return productList.stream().filter(product -> product.getStoreType().equalsIgnoreCase(storeType))
				.collect(Collectors.toList());
	}

	public Product createNewProduct(Product product) {
		productList.add(product);
		return product;
	}

	public Product getProductById(Long productId) {
		return productList.stream().filter(product -> product.getProductId().equals(productId)).findFirst().get();
	}
}