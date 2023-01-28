package com.example.javabootcampproject3.Controller;

import com.example.javabootcampproject3.Pogo.MerchantStock;
import com.example.javabootcampproject3.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchantStock")
@RequiredArgsConstructor
public class MerchantStockController {
    private final MerchantStockService merchantStockService;


    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@Valid @RequestBody MerchantStock merchantStock , Errors error){

        if(error.hasErrors()){
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStockService.addMerchantStocks(merchantStock);
        return ResponseEntity.status(200).body("Merchant Stock added");
    }

    //display
    @GetMapping("/display")
    public ArrayList<MerchantStock> getMerchantStocks(){
        ArrayList<MerchantStock> merchantStocks = merchantStockService.getMerchantStocks();
        return merchantStocks;
    }

    //update
    @PutMapping("/update/{index}")
    public ResponseEntity updateMerchant(@Valid @RequestBody MerchantStock merchantStock ,@PathVariable int index, Errors error){
        if(error.hasErrors()){
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = merchantStockService.updateMerchantStocks(Integer.toString(index),merchantStock);
        if(isUpdated){
            return ResponseEntity.status(200).body("Merchant Stock have been updated");
        }
        return ResponseEntity.status(400).body("Merchant Stock not found please try again");
    }

    //delete
    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteMerchant(@PathVariable int index){
        boolean isDeleted = merchantStockService.deleteMerchantStocks(Integer.toString(index));
        if(isDeleted){
            return ResponseEntity.status(200).body("Merchant Stock have been deleted");
        }
        return ResponseEntity.status(400).body("Merchant Stock not found please try again");
    }




}
