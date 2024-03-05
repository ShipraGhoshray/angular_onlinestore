package com.onlinestore.onlinestore.webservice;

import java.util.*;
import java.util.NoSuchElementException;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.onlinestore.repository.Product;
import com.onlinestore.onlinestore.repository.User;
import com.onlinestore.onlinestore.service.ProductService;
import com.onlinestore.onlinestore.service.UserService;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:3000")
public class ProductWebService {
	
	private final com.onlinestore.onlinestore.service.UserService userService;
	private final ProductService productService;
	
	public ProductWebService(UserService userService, ProductService productService) {
		this.userService = userService;
		this.productService = productService;
	}
	
	@GetMapping("/users")
    public List<User> getAllUsersProducts(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "") String searchKey){
        return (List<User>) this.userService.lookup();
    }
	
	@GetMapping("/products")
    public Iterable<Product> products(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "") String searchKey){
        return this.productService.lookup();
    }
	
	@PostMapping("/createNewProduct")
    public Product createNewProduct(@RequestBody Product product){
        return this.productService.save(product.getProductId(), product.getName(), product.getPrice(), product .getType());
    }

	@PutMapping("/products/{productId}/details")
	public Product updateProduct(@PathVariable(value = "productId") String productId, @RequestBody @Validated Product productRequest) {
		Product item = verifyProduct(productId, productRequest.getName());
		item.setPrice(productRequest.getPrice());
		return productService.save(item);
	}

	private Product verifyProduct(String reqProductId, String name) throws NoSuchElementException {
		long productId = Long.valueOf(reqProductId);
		return productService.findById(productId, name).orElseThrow(() -> new NoSuchElementException("Product requested("+ productId + " for name" + name));
	}

    @DeleteMapping(path = "deleteProduct/{productId}")
    public void delete(@PathVariable(value = "productId") String productId) {
    	try {
    		Product item = verifyProduct(productId, "");
    		productService.delete(item);
    	}catch(NoSuchElementException e) {
    		System.out.println("User does not exist");
    	}
    }
}
