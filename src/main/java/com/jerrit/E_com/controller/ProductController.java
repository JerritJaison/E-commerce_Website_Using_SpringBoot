package com.jerrit.E_com.controller;

import com.jerrit.E_com.model.Product;
import com.jerrit.E_com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api") //localhost:8080 /api / links mentioned in method
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products") //for get methods
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(service.getAllproducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        Product product = service.getProductbyId(id);
        if (product != null)
            return new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/product", consumes = "multipart/form-data")
    public ResponseEntity<Product> addProduct(@RequestPart("product") Product product,
                                              @RequestPart("image") MultipartFile image) {


        try {
            Product prod = service.addProduct(product, image);
            return new ResponseEntity<>(prod, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("product/{productid}/image")
    public ResponseEntity<byte[]> getImagebyId(@PathVariable Integer productid) {
        Product product = service.getProductbyId(productid);
        byte[] image = product.getImage();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImagetype()))
                .body(image);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateproduct(@PathVariable Integer id, @RequestPart Product product,
                                                @RequestPart MultipartFile imageFile) {

        Product product1 = null;
        try {
            product1 = service.updateproduct(id,product,imageFile);
        } catch (IOException e) {
            return new ResponseEntity<>("update failed", HttpStatus.BAD_REQUEST);
        }

        if(product1 != null){
            return new ResponseEntity<>("updated successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("update failed", HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteproduct(@PathVariable Integer id) {

        Product product = service.getProductbyId(id);
        if(product != null) {
            service.deleteProduct(id);
            return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("delete failed", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProduct(String keyword){
        List<Product> products = service.searchProduct(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}


