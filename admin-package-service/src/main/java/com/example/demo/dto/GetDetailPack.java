package com.example.demo.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.request.GetMatchByIdDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetDetailPack {

    private Long id;
    private String title;
    private Double cost;
    private String description;
    private String contact;
    private LocalDate date;
    private Boolean reserved;
    private int discount;

    private PaymentGetDTO paymentGetDTO;
    private List<Object> healthInsurance = new ArrayList<>();
    private Object lodging;
    private List<Object> matches = new ArrayList<>();
    private Object travel;
    
}
