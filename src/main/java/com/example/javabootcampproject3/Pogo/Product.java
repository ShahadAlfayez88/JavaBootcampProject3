package com.example.javabootcampproject3.Pogo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class Product {
    @NotEmpty(message = "Id field is required!")
    @Size(min= 3 , max = 3 , message = "the length of the id must equal 3 ")
    private String  ID ;
    @NotEmpty(message = "Name field is required!")
    @Length(min= 3 , max = 3 , message = "the length of the Name must equal 3 ")
    private String name;
    @NotNull(message = "Price field is required!")
    @Positive(message = "Price must be positive")
    private int price;
    @NotEmpty(message = "Category Id field is required!")
    @Size(min= 3 , max = 3 , message = "the length of the categoryID must equal 3 ")
    private String categoryID;

}
