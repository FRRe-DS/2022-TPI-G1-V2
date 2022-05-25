package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostPackDTO {
   
    private String title;
    private Double cost;
    private String description;
    private String contact;
    private int discount;

 //   private List<Long> healthInsurance = new ArrayList<>();
 //   private Long lodging;
    private List<Long> matches = new ArrayList<>();
 //   private Long travel;
    
}
