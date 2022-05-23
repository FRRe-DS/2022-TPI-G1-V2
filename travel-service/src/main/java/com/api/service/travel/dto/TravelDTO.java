package com.api.service.travel.dto;

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
public class TravelDTO {
    private String descripcion;
    
    private String travelTime;
    
    private String travelDate;
    
    private String travelHour;
    
    private String localization;
    
    private String service;

    private String type;
    
    
    private String company;

    private List<TravelTicketDTO> tickets = new ArrayList<TravelTicketDTO>();
}
