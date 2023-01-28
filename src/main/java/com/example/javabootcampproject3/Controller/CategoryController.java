package com.example.javabootcampproject3.Controller;

import com.example.javabootcampproject3.Pogo.Category;
import com.example.javabootcampproject3.Service.CategoryService;
import com.example.javabootcampproject3.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService Category ;
    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid @RequestBody  Category category , Errors error){

        if(error.hasErrors()){
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Category.addCategory(category);
        return ResponseEntity.status(200).body("Category added");
    }

    //display
    @GetMapping("/display")
    public ArrayList<com.example.javabootcampproject3.Pogo.Category> getProduct(){
        ArrayList<com.example.javabootcampproject3.Pogo.Category> categories = Category.getCategory();
        return categories;
    }

    //update
    @PutMapping("/update/{index}")
    public ResponseEntity updateProducts(@Valid @RequestBody Category category ,@PathVariable int index, Errors error){
        if(error.hasErrors()){
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = Category.updateCategory(Integer.toString(index),category);
        if(isUpdated){
            return ResponseEntity.status(200).body("Category have been updated");
        }
        return ResponseEntity.status(400).body("Category not found please try again");
    }

    //delete
    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteProduct(@PathVariable int index){
        boolean isDeleted = Category.deleteCategory(Integer.toString(index));
        if(isDeleted){
            return ResponseEntity.status(200).body("Product have been deleted");
        }
        return ResponseEntity.status(400).body("Product not found please try again");
    }



}
