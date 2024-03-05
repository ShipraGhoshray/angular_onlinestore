package com.onlinestore.onlinestore.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.onlinestore.onlinestore.repository.Product;

@Service
public interface ProductService{

	public Iterable<Product> lookup();
    public Optional<Product> findById(long productId, String name);
	public Product save(long productId, String name, int price, String type);
	public Product save(Product product); 
	public void delete(Product product);
	public long total();
}
