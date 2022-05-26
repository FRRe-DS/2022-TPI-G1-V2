package com.match.matches.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.match.matches.domain.MatchGame;
import com.match.matches.domain.MatchTicket;
import com.match.matches.dto.GetMatchByIdDTO;
import com.match.matches.dto.GetMatchesDTO;
import com.match.matches.dto.GetTicketsByMatchDTO;
import com.match.matches.dto.MatchGameDTO;
import com.match.matches.dto.TicketsGameDTO;
import com.match.matches.mapper.MatchMapper;
import com.match.matches.mapper.TicketsMapper;
import com.match.matches.repository.MatchGameRepository;
import com.match.matches.service.MatchService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MatchServiceImpl implements MatchService{

    private final MatchMapper matchMapper;
    private final MatchGameRepository matchGameRepository;
    private final TicketsMapper ticketsMapper;
    @Override
    @Transactional  
    public MatchGame createMatchGame(MatchGameDTO matchGameDTO) {

        MatchGame match = matchMapper.matchMapper(matchGameDTO);

        return matchGameRepository.save(match);
    }

    @Override
    public List<GetMatchesDTO> getMatchesGames() {
        
        List<MatchGame> listGames = matchGameRepository.findAll();

        if(!listGames.isEmpty()){
            return matchMapper.matchMapper(listGames);
        }else{
            return null;
        }

    }

    @Override
    public List<GetTicketsByMatchDTO> getTicketsByIdMatch(Long id) {
        List<GetTicketsByMatchDTO> listTickets = new ArrayList<>();

        Optional<MatchGame> match = matchGameRepository.findById(id);

        if(match.isPresent()){
            listTickets = ticketsMapper.ticketByMatchMapper(match.get().getTickets());
        }
        return listTickets;
    }

    @Override
    public Boolean deleteMatchById(Long id) {
        Optional<MatchGame> match = matchGameRepository.findById(id);
        if(match.isPresent()){
            matchGameRepository.delete(match.get());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public GetMatchByIdDTO getMatchById(Long id) {

        Optional<MatchGame> match = matchGameRepository.findById(id);

        if(match.isPresent()){
            return matchMapper.getMatchByIdMapper(match.get());
        }else{
            return null;
        }
    }


    
}
