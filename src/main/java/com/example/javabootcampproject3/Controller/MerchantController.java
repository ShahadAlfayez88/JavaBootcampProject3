package com.example.javabootcampproject3.Controller;

import com.example.javabootcampproject3.Pogo.Merchant;
import com.example.javabootcampproject3.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService ;

    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant , Errors error){

        if(error.hasErrors()){
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body("Merchant added");
    }

    //display
    @GetMapping("/display")
    public ArrayList<Merchant> getMerchants(){
        ArrayList<Merchant> merchants = merchantService.getMerchants();
        return merchants;
    }

    //update
    @PutMapping("/update/{index}")
    public ResponseEntity updateMerchant(@Valid @RequestBody Merchant merchant ,@PathVariable int index, Errors error){
        if(error.hasErrors()){
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = merchantService.updateMerchant(Integer.toString(index),merchant);
        if(isUpdated){
            return ResponseEntity.status(200).body("Merchant have been updated");
        }
        return ResponseEntity.status(400).body("Merchant not found please try again");
    }

    //delete
    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteMerchant(@PathVariable int index){
        boolean isDeleted = merchantService.deleteMerchant(Integer.toString(index));
        if(isDeleted){
            return ResponseEntity.status(200).body("Merchant have been deleted");
        }
        return ResponseEntity.status(400).body("Merchant not found please try again");
    }



}

