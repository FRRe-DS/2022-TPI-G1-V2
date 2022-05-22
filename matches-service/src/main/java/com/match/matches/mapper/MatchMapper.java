package com.match.matches.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.match.matches.domain.MatchGame;
import com.match.matches.domain.MatchTicket;
import com.match.matches.dto.GetMatchesDTO;
import com.match.matches.dto.MatchGameDTO;
import com.match.matches.dto.TicketsGameDTO;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class MatchMapper {

    private final TicketsMapper ticketMapper;
    
    public MatchGame matchMapper(MatchGameDTO matchGameDTO){
        
        MatchGame match = MatchGame.builder()
        .localTeam(matchGameDTO.getLocalTeam())
        .vistTeam(matchGameDTO.getVistTeam())
        .stadium(matchGameDTO.getStadium())
        .matchDate(convertStringToLocalDate(matchGameDTO.getMatchDate()))
        .matchTime(matchGameDTO.getMatchTime())
        .build();
        
        if(!matchGameDTO.getListTickets().isEmpty()) 
        match = loadTickets(matchGameDTO,match);
        
        return match;
    }

    private MatchGame loadTickets(MatchGameDTO matchGameDTO, MatchGame match){
        List<MatchTicket> listTickets = ticketMapper.ticketMapper(matchGameDTO.getListTickets());
        for (MatchTicket matchTicket : listTickets) {
            matchTicket.setMatchgame(match);
        }
        match.setTickets(listTickets);
        return match;
    }

    public List<GetMatchesDTO> matchMapper(List<MatchGame> match){
        String url = "/match";
        List<GetMatchesDTO> lGetMatchesDTOs = new ArrayList<GetMatchesDTO>();
        for (MatchGame matchGame : match) {
            lGetMatchesDTOs.add(
                GetMatchesDTO.builder()
                .localTeam(matchGame.getLocalTeam())
                .vistTeam(matchGame.getVistTeam())
                .stadium(matchGame.getStadium())
                .matchDate(matchGame.getMatchDate())
                .matchTime(matchGame.getMatchTime())
                .url(url + matchGame.getId())
                .build()
            );
        }
        return lGetMatchesDTOs;

    }

    private LocalDate convertStringToLocalDate(String date){
        LocalDate local_date = LocalDate.parse(date);
        return local_date;
    }
}
