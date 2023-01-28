package com.example.javabootcampproject3.Pogo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class Merchant {
    @NotEmpty(message = "Id field is required!")
    @Size(min= 3 , max = 3 , message = "the length of the id must equal 3 ")
    private String ID ;
    @NotEmpty(message = "Name field is required!")
    @Length(min= 3 , max = 3 , message = "the length of the Name must equal 3 ") //392 - 123 - 456 - 456
    private String name;
}
