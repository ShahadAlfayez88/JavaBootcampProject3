package com.example.javabootcampproject3.Controller;

import com.example.javabootcampproject3.Pogo.MerchantStock;
import com.example.javabootcampproject3.Pogo.Product;
import com.example.javabootcampproject3.Pogo.User;
import com.example.javabootcampproject3.Service.MerchantService;
import com.example.javabootcampproject3.Service.MerchantStockService;
import com.example.javabootcampproject3.Service.ProductService;
import com.example.javabootcampproject3.Service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final MerchantService merchantService;
    private final MerchantStockService merchantStockService;
    private final ProductService productService;

    MerchantStock merchantStock = null;



    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user , Errors error){

        if(error.hasErrors()){
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User added");
    }

    //display
    @GetMapping("/display")
    public ArrayList<User> getUser(){
        ArrayList<User> users = userService.getUser();
        return users;
    }

    //update
    @PutMapping("/update/{index}")
    public ResponseEntity updateUser(@Valid @RequestBody User user ,@PathVariable int index, Errors error){
        if(error.hasErrors()){
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = userService.updateUser(Integer.toString(index),user);
        if(isUpdated){
            return ResponseEntity.status(200).body("User have been updated");
        }
        return ResponseEntity.status(400).body("User not found please try again");
    }

    //delete
    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteUser(@PathVariable int index){
        boolean isDeleted = userService.deleteUser(Integer.toString(index));
        if(isDeleted){
            return ResponseEntity.status(200).body("User have been deleted");
        }
        return ResponseEntity.status(400).body("User not found please try again");
    }

//     add product to merchant stock

    @PostMapping("/addProduct")
    public ResponseEntity addProduct(@Valid @RequestBody MerchantStock merchantStock, Errors error){

        if(error.hasErrors()){
            String message = error.getFieldError().getDefaultMessage();
            if(message.equals("Id field is required!")){}
            else
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
            }
        userService.addProduct(merchantStock);
        return ResponseEntity.status(200).body("Product added");
    }

    //buy product
    @GetMapping("/buyProduct/userid/{index1}/productid/{index2}/merchantid/{index3}/merchantstockid/{index4}")
    public ResponseEntity buyProduct( @PathVariable int index1, @PathVariable int index2, @PathVariable int index3, @PathVariable int index4) {

        boolean isValidUserId = userService.checkUser(Integer.toString(index1));

        boolean isValidProductId = productService.checkProduct(Integer.toString(index2));

        boolean isValidMerchantId = merchantService.checkMerchant(Integer.toString(index3));

        boolean isBalanceNotSufficient = userService.checkBalance(Integer.toString(index1),Integer.toString(index2));

        boolean isStockSufficient = userService.checkStock(Integer.toString(index2),Integer.toString(index3));


        // check all id - worked
        if (isValidProductId && isValidUserId && isValidMerchantId) {

            // check balance
            if (isBalanceNotSufficient) {
                return ResponseEntity.status(400).body("your balance is is insufficient");
            } else {
                // check stock
                if (isStockSufficient) {
                    return ResponseEntity.status(200).body("Thank You for Your purchase");
                }else
                    return ResponseEntity.status(400).body("Stock is is insufficient");

            }


        }
            return ResponseEntity.status(400).body("Please make sure that you have entered a valid ID ");



    }
}
