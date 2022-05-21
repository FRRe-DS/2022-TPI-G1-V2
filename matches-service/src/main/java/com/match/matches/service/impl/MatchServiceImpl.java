package com.match.matches.service.impl;

import java.util.List;

import com.match.matches.domain.MatchGame;
import com.match.matches.dto.GetMatchesDTO;
import com.match.matches.dto.MatchGameDTO;
import com.match.matches.mapper.MatchMapper;
import com.match.matches.repository.MatchGameRepository;
import com.match.matches.service.MatchService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MatchServiceImpl implements MatchService{

    private final MatchMapper matchMapper;
    private final MatchGameRepository matchGameRepository;
    
    @Override  
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
    
}
