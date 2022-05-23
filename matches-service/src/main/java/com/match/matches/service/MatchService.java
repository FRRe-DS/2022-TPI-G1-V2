package com.match.matches.service;

import java.util.List;

import com.match.matches.domain.MatchGame;
import com.match.matches.domain.MatchTicket;
import com.match.matches.dto.GetMatchByIdDTO;
import com.match.matches.dto.GetMatchesDTO;
import com.match.matches.dto.GetTicketsByMatchDTO;
import com.match.matches.dto.MatchGameDTO;
import com.match.matches.dto.TicketsGameDTO;

public interface MatchService {
    MatchGame createMatchGame(MatchGameDTO matchGameDTO);
    List<GetMatchesDTO> getMatchesGames();
    List<GetTicketsByMatchDTO> getTicketsByIdMatch(Long id);
    GetMatchByIdDTO getMatchById(Long id);
    Boolean deleteMatchById(Long id);
}
