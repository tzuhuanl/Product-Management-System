package com.simpleWebApp.service;


import com.simpleWebApp.exception.ResourceNotFoundException;
import com.simpleWebApp.model.Product;
import com.simpleWebApp.model.Users;
import com.simpleWebApp.repository.ProductRepo;
import com.simpleWebApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService{

    @Autowired
    ProductRepo repo;

    @Autowired
    UserRepo userRepo;

    public List<Product> getProductList(){

        return repo.findAll();
    }

    public Product getProductById(int id){
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find No. " + id + " product."));
    }

    public void addProduct(Product product, String username){

        Users user = userRepo.findByUsername(username);
        if(user == null){
            throw new ResourceNotFoundException("User not found");
        }

        product.setUser(user);

        repo.save(product);

        repo.save(product);
    }

    public void updateProduct(Product product){
        repo.save(product);
    }

    public void deleteProduct(int id){
        repo.deleteById(id);
    }


}
