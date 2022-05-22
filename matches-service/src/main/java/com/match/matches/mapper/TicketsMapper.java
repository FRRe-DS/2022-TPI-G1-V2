package com.match.matches.mapper;

import java.util.ArrayList;
import java.util.List;

import com.match.matches.domain.MatchGame;
import com.match.matches.domain.MatchTicket;
import com.match.matches.dto.GetTicketsByMatchDTO;
import com.match.matches.dto.TicketsGameDTO;

import org.springframework.stereotype.Component;

@Component
public class TicketsMapper {
    public List<MatchTicket> ticketMapper(List<TicketsGameDTO> ticketsGameDTO){
        List<MatchTicket> tickets = new ArrayList<MatchTicket>();

        for (TicketsGameDTO ticket : ticketsGameDTO) {
            for (int i = 0; i < ticket.getCount(); i++) {    
                tickets.add(
                    MatchTicket.builder()
                        .buyed(false)
                        .position(ticket.getPosition())
                        .cost(ticket.getCost())
                        .build()
                );   
            }
        }
        return tickets;
    }
    
    public List<GetTicketsByMatchDTO> ticketByMatchMapper(List<MatchTicket> ticketsGame){
        List<GetTicketsByMatchDTO> tickets = new ArrayList<GetTicketsByMatchDTO>();

        for (MatchTicket ticket : ticketsGame) {
            tickets.add(
                GetTicketsByMatchDTO.builder()
                    .position(ticket.getPosition())
                    .cost(ticket.getCost())
                    .matchUrl("/match/"+ticket.getMatchgame().getId())
                    .build()
            );   
        }
        return tickets;
    }





}
