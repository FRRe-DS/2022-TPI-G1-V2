package com.api.service.travel.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.api.service.travel.domain.Travel;
import com.api.service.travel.domain.TravelTicket;
import com.api.service.travel.dto.GetTravelDTO;
import com.api.service.travel.dto.TravelDTO;
import com.api.service.travel.dto.TravelTicketDTO;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TravelMapper {
    
    private final TravelTicketMapper travelTicketMapper;
    public Travel travelMapper(TravelDTO travelDTO){
        
        Travel travel = Travel.builder()
            .company(travelDTO.getCompany())
            .descripcion(travelDTO.getDescripcion())
            .localization(travelDTO.getLocalization())
            .type(travelDTO.getType())
            .travelTime(travelDTO.getTravelTime())
            .service(travelDTO.getService())
            .rating(0.0)
            .travelHour(travelDTO.getTravelHour())
            .travelDate(convertStringToLocalDate(travelDTO.getTravelDate()))
            .build();
        
        if(!travelDTO.getTickets().isEmpty()) 
        loadTickets(travelDTO.getTickets(), travel);

        return travel;
    }

    public List<GetTravelDTO> travelMapper(List<Travel> travels){
        List<GetTravelDTO> lGetTravelDTOs = new ArrayList<GetTravelDTO>();
        for (Travel travel : travels) {
            lGetTravelDTOs.add(
                GetTravelDTO.builder()
                    .url("/travel/"+travel.getId())
                    .company(travel.getCompany())
                    .descripcion(travel.getDescripcion())
                    .localization(travel.getLocalization())
                    .type(travel.getType())
                    .travelTime(travel.getTravelTime())
                    .service(travel.getService())
                    .rating(travel.getRating())
                    .travelHour(travel.getTravelHour())
                    .travelDate(travel.getTravelDate())
                    .tickets(travelTicketMapper.travelTicketMapper(travel.getTickets()))
                    .build()
            );
        }
        return lGetTravelDTOs;

    }

    public GetTravelDTO getTravelById(Travel travel){
    
        return GetTravelDTO.builder()
            .url("/travel/"+travel.getId())
            .company(travel.getCompany())
            .descripcion(travel.getDescripcion())
            .localization(travel.getLocalization())
            .type(travel.getType())
            .travelTime(travel.getTravelTime())
            .service(travel.getService())
            .rating(travel.getRating())
            .travelHour(travel.getTravelHour())
            .travelDate(travel.getTravelDate())
            .tickets(travelTicketMapper.travelTicketMapper(travel.getTickets()))
            .build();
    }

    private Travel loadTickets(List<TravelTicketDTO> travelTicketDTOs,Travel travel){
        List<TravelTicket> tickets = travelTicketMapper.travelMapper(travelTicketDTOs);

        for (TravelTicket ticket : tickets) {
            ticket.setTravel(travel);
        }
        travel.setTickets(tickets);
        return travel;

    }

    private LocalDate convertStringToLocalDate(String date){
        LocalDate local_date = LocalDate.parse(date);
        return local_date;
    }

}
