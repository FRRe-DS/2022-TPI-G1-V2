package com.api.service.travel.mapper;

import java.util.ArrayList;
import java.util.List;

import com.api.service.travel.domain.TravelTicket;
import com.api.service.travel.dto.TravelTicketDTO;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TravelTicketMapper {
    public List<TravelTicket> travelMapper(List<TravelTicketDTO> travelDTO){
        List<TravelTicket> tickets = new ArrayList<>();

        for (TravelTicketDTO travelTicketDTO : travelDTO) {
            tickets.add(
                TravelTicket.builder()
                .buyed(false)
                .numberTravel(travelTicketDTO.getNumberTravel())
                .position(travelTicketDTO.getPosition())
                .build()
            );
        }

        return tickets;
    }

    public List<TravelTicketDTO> travelTicketMapper(List<TravelTicket> tickets){
        List<TravelTicketDTO> ticketsDTO = new ArrayList<>();

        for (TravelTicket ticket : tickets) {
            ticketsDTO.add(
                TravelTicketDTO.builder()
                .numberTravel(ticket.getNumberTravel())
                .position(ticket.getPosition())
                .build()
            );
        }

        return ticketsDTO;
    }



}
