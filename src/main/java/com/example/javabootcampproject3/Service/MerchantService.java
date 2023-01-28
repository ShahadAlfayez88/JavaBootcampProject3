package com.example.javabootcampproject3.Service;

import com.example.javabootcampproject3.Pogo.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    ArrayList<Merchant> merchants = new ArrayList<>();


    //Display
    public ArrayList<Merchant> getMerchants(){
        return merchants;
    }

    //Add
    public void addMerchant(Merchant merchant){
        merchants.add(merchant);
    }

    //Update
    public boolean updateMerchant(String id, Merchant merchant){
        for(int i =0 ; i< merchants.size();i++){
            if (merchants.get(i).getID().equals(id)){
                merchants.set(i,merchant);
                return true;
            }
        }
        return false;
    }

    //Delete
    public boolean deleteMerchant(String id){
        for(int i =0 ; i< merchants.size();i++){
            if (merchants.get(i).getID().equals(id)){
                merchants.remove(i);
                return true;
            }
        }
        return false;

}

    // Check Merchant id
    public boolean checkMerchant(String id){
        for(int i =0 ; i< merchants.size();i++){
            if (merchants.get(i).getID().equals(id)){
                return true;
            }
        }
        return false;
    }

}
