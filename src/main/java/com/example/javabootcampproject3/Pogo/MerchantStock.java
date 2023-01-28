package com.example.javabootcampproject3.Pogo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotEmpty(message = "Id field is required!")
    @Size(min= 3 , max = 3 , message = "the length of the id must equal 3 ")
    private String ID;
    @NotEmpty(message = "Product id field is required!")
    @Size(min= 3 , max = 3 , message = "the length of the product id must equal 3 ")
    private String productid;
    @NotEmpty(message = "Merchant id field is required!")
    @Size(min= 3 , max = 3 , message = "the length of the Merchant id must equal 3 ")
    private String merchantid;

    @NotNull(message = "Stock field is required!")
    @Min(value = 10 , message = "the size of stock must equal 10 or more ")
    private int stock;

}
