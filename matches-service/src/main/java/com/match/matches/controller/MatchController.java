package com.match.matches.controller;

import java.util.List;

import com.match.matches.domain.MatchGame;
import com.match.matches.dto.GetMatchesDTO;
import com.match.matches.dto.GetTicketsByMatchDTO;
import com.match.matches.dto.MatchGameDTO;
import com.match.matches.dto.ResponseDTO;
import com.match.matches.dto.TicketsGameDTO;
import com.match.matches.repository.MatchGameRepository;
import com.match.matches.service.impl.MatchServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/match")
public class MatchController {
    
    private final MatchServiceImpl matchService;
    private final MatchGameRepository matchGameRepository;
    
    @PostMapping()
    public ResponseEntity<ResponseDTO> createMatch(@RequestBody MatchGameDTO matchGameDTO){
        ResponseDTO response = new ResponseDTO();

        MatchGame match = matchService.createMatchGame(matchGameDTO);
       
        response.setId(match.getId());
        response.setUrl("/match/"+match.getId());
   
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getMatches(){
        

        List<GetMatchesDTO> matches = matchService.getMatchesGames();
        
        if(matches == null){
            return new ResponseEntity<String>("No exists matches", HttpStatus.OK);
        }else{
            return new ResponseEntity<List<GetMatchesDTO>>(matches, HttpStatus.OK);
        }
        
   
        
    }

    @GetMapping("/{id}/ticket")
    public ResponseEntity<?> getTicketsByIdMatch(@PathVariable(name = "id") Long id){
        
        List<GetTicketsByMatchDTO> tickets = matchService.getTicketsByIdMatch(id);
        
        if(tickets == null){
            return new ResponseEntity<String>("No exists tickets", HttpStatus.OK);
        }else{
            return new ResponseEntity<List<GetTicketsByMatchDTO>>(tickets, HttpStatus.OK);
        }   
    }
    
}
