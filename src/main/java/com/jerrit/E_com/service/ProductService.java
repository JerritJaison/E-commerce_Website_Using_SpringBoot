package com.jerrit.E_com.service;

import com.jerrit.E_com.model.Product;
import com.jerrit.E_com.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllproducts() {

        return repo.findAll();
    }

    public Product getProductbyId(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile image) throws IOException {
        product.setImagename(image.getOriginalFilename());
        product.setImagetype(image.getContentType());
        product.setImage(image.getBytes());
        return repo.save(product);
    }

    public Product updateproduct(Integer id, Product product, MultipartFile image) throws IOException {

        product.setImagename(image.getOriginalFilename());
        product.setImagetype(image.getContentType());
        product.setImage(image.getBytes());

        return repo.save(product);
    }

    public void deleteProduct(Integer id) {
        repo.deleteById(id);
    }

    public List<Product> searchProduct(String keyword) {
        return repo.searchProduct(keyword);
    }
}
