package com.example.javabootcampproject3.Service;

import com.example.javabootcampproject3.Pogo.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {
    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();



    //Display
    public ArrayList<MerchantStock> getMerchantStocks(){
        return merchantStocks;
    }

    //Add
    public void addMerchantStocks(MerchantStock merchantStock){
        merchantStocks.add(merchantStock);
    }

    //Update
    public boolean updateMerchantStocks(String id,MerchantStock merchantStock){
        for(int i =0 ; i< merchantStocks.size();i++){
            if (merchantStocks.get(i).getID().equals(id)){
                merchantStocks.set(i,merchantStock);
                return true;
            }
        }
        return false;
    }

    //Delete
    public boolean deleteMerchantStocks(String id){
        for(int i =0 ; i< merchantStocks.size();i++){
            if (merchantStocks.get(i).getID().equals(id)){
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;


    }
    // Check merchant stock id
    public boolean checkMerchantStock(String id){
        for(int i =0 ; i< merchantStocks.size();i++){
            if (merchantStocks.get(i).getID().equals(id)){
                return true;
            }
        }
        return false;
    }


}
