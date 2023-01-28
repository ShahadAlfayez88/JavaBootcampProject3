package com.example.javabootcampproject3.Service;

import com.example.javabootcampproject3.Pogo.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    ArrayList<Product> products = new ArrayList<>();

    //Display
    public ArrayList<Product> getProducts(){
        return products;
    }

    //Add
    public void addProducts(Product product){
        products.add(product);
    }

    //Update

    public boolean updateProduct(String id, Product product){
        for(int i =0 ; i< products.size();i++){
            if (products.get(i).getID().equals(id)){
                products.set(i,product);
                return true;
            }
        }
        return false;
    }

    //Delete
    public boolean deleteProduct(String id){
        for(int i =0 ; i< products.size();i++){
            if (products.get(i).getID().equals(id)){
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    // Check product id
    public boolean checkProduct(String id){
        for(int i =0 ; i< products.size();i++){
            if (products.get(i).getID().equals(id)){
                return true;
            }
        }
        return false;
    }
}
