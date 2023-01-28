package com.example.javabootcampproject3.Service;

import com.example.javabootcampproject3.Pogo.Category;
import com.example.javabootcampproject3.Pogo.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class CategoryService {
    ArrayList<Category> categories = new ArrayList<>();

    //Display
    public ArrayList<Category> getCategory(){
        return categories;
    }

    //Add
    public void addCategory(Category category){
        categories.add(category);
    }

    //Update
    public boolean updateCategory(String id, Category category){
        for(int i =0 ; i< categories.size();i++){
            if (categories.get(i).getID().equals(id)){
                categories.set(i,category);
                return true;
            }
        }
        return false;
    }

    //Delete
    public boolean deleteCategory(String id){
        for(int i =0 ; i< categories.size();i++){
            if (categories.get(i).getID().equals(id)){
                categories.remove(i);
                return true;
            }
        }
        return false;
    }

}
