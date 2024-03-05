package com.onlinestore.onlinestore.service.impl;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.onlinestore.onlinestore.repository.Product;
import com.onlinestore.onlinestore.repository.ProductRepository;
import com.onlinestore.onlinestore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> lookup(){
        return productRepository.findAll();
    }
    
    @Override
    public Optional<Product> findById(long id, String name){
    	return productRepository.findById(id);
    }
    
    @Override
    public Product save(long productId, String name, int price, String type) {
        return productRepository.findById(productId).orElse(
        		productRepository.save(new Product(productId, name, price, type)));   
    }

    @Override
	public Product save(Product product) {
    	return productRepository.save(product);
    }
    
	@Override
	public void delete(Product product){
		productRepository.delete(product);
	}
    
    @Override
    public long total() {
        return productRepository.count();
    }
}

