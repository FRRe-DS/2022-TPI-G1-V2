package com.example.demo.request;

import java.time.LocalDate;
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
public class Travel {
    private String url;
    private String descripcion;
    private String travelTime;
    private LocalDate travelDate;
    private Double rating;
    private String travelHour;
    private String localization;
    private String service;
    private String type;
    private String company;
    private List<TravelTicket> tickets = new ArrayList<TravelTicket>();
}
