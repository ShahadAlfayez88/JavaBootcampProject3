package com.example.javabootcampproject3.Service;

import com.example.javabootcampproject3.Pogo.MerchantStock;
import com.example.javabootcampproject3.Pogo.Product;
import com.example.javabootcampproject3.Pogo.User;
import com.example.javabootcampproject3.Service.ProductService;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserService {

    ArrayList<User> users = new ArrayList<User>();
    private final ProductService productService;

    private final MerchantStockService merchantStockService;

    // add user
    public void addUser(User user){
        users.add(user);
    }

    // get users
    public ArrayList<User> getUser(){
        return users;
    }

    // update user
    public boolean updateUser(String id, User user){
        for(int i =0 ; i< users.size();i++){
            if (users.get(i).getId().equals(id)){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }

    // delete user
    public boolean deleteUser(String id){
        for(int i =0 ; i< users.size();i++){
            if (users.get(i).getId().equals(id)){
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    // Check user id
    public boolean checkUser(String id){
        for(int i =0 ; i< users.size();i++){
            if (users.get(i).getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    // check user balance
    public boolean checkBalance(String id ,String id2){

        for (User user : users){

            if(id.equals(user.getId())){
            int balance = user.getBalance();

                for (Product product : productService.getProducts()){

                    if(id2.equals(product.getID())){

                       int price = product.getPrice();
                        System.out.println(product.getPrice());
                        if(price>balance) {
                            return true;
                        }else
                            user.setBalance(user.getBalance()-product.getPrice());

                    }

                }

            }
        }

        return false;
    }

    //check stock
    public boolean checkStock(String index2 ,String index3){


        for (int i = 0; i < merchantStockService.getMerchantStocks().size(); i++) {

            // check merchant stock if its have the same product id and merchant id - worked
            if (merchantStockService.getMerchantStocks().get(i).getMerchantid().equals(index3)
                    && merchantStockService.getMerchantStocks().get(i).getProductid().equals(index2)) {

                // check merchant stock - worked
                if (merchantStockService.getMerchantStocks().get(i).getStock() >= 10) {
                    int stock = merchantStockService.getMerchantStocks().get(i).getStock();
                    stock--;
                    merchantStockService.getMerchantStocks().get(i).setStock(stock);
                    return true;
                }
    }}
        return false;
    }

    // add product to a merchant stock

    public void addProduct(MerchantStock merchantStock ){

        Random rand = new Random();
        int id = rand. nextInt(900) + 100;

        String ID = Integer.toString(id);
        merchantStock.setID(ID);
        merchantStockService.addMerchantStocks(merchantStock);
    }
}



