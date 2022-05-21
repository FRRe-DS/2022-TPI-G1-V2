package com.match.matches.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.match.matches.domain.MatchGame;
import com.match.matches.dto.GetMatchesDTO;
import com.match.matches.dto.MatchGameDTO;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class MatchMapper {

    private final TicketsMapper ticketMapper;
    
    public MatchGame matchMapper(MatchGameDTO matchGameDTO){
        
        return MatchGame.builder()
        .localTeam(matchGameDTO.getLocalTeam())
        .vistTeam(matchGameDTO.getVistTeam())
        .stadium(matchGameDTO.getStadium())
        .matchDate(convertStringToLocalDate(matchGameDTO.getMatchDate()))
        .matchTime(matchGameDTO.getMatchTime())
        .tickets(ticketMapper.ticketMapper(matchGameDTO.getListTickets()))
        .build();
        

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
