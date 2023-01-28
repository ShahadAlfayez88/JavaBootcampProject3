package com.example.javabootcampproject3.Controller;

import com.example.javabootcampproject3.Pogo.Product;
import com.example.javabootcampproject3.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService product ;

    //add
    @PostMapping("/add")
    public ResponseEntity addProducts(@Valid @RequestBody Product p , Errors error){
        if(error.hasErrors()){
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        product.addProducts(p);
        return ResponseEntity.status(200).body("Product added");
    }

    //display
    @GetMapping("/display")
    public ArrayList<Product> getProduct(){
        ArrayList<Product> products = product.getProducts();
        return products;
    }

    //update
    @PutMapping("/update/{index}")
    public ResponseEntity updateProducts(@Valid @RequestBody Product p ,@PathVariable int index, Errors error){
        if(error.hasErrors()){
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = product.updateProduct(Integer.toString(index),p);
        if(isUpdated){
            return ResponseEntity.status(200).body("Product have been updated");
        }
        return ResponseEntity.status(400).body("Product not found please try again");
    }

    //delete
    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteProduct(@PathVariable int index){
        boolean isDeleted = product.deleteProduct(Integer.toString(index));
        if(isDeleted){
            return ResponseEntity.status(200).body("Product have been deleted");
        }
        return ResponseEntity.status(400).body("Product not found please try again");
    }


}
