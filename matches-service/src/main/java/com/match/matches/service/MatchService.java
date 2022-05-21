package com.match.matches.service;

import java.util.List;

import com.match.matches.domain.MatchGame;
import com.match.matches.dto.GetMatchesDTO;
import com.match.matches.dto.MatchGameDTO;

public interface MatchService {
    MatchGame createMatchGame(MatchGameDTO matchGameDTO);
    List<GetMatchesDTO> getMatchesGames();
}
