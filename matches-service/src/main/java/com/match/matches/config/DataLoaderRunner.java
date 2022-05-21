package com.match.matches.config;

import java.time.LocalDate;

import com.match.matches.domain.MatchGame;
import com.match.matches.repository.MatchGameRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DataLoaderRunner implements CommandLineRunner{
    private MatchGameRepository matchRepository;

    @Override
    public void run(String... args) throws Exception {
        if(matchRepository.findAll().isEmpty()) loadMatchs();
        
    }

    private void loadMatchs(){
        
        createMatch((long) 1,"Qatar","Ecuador",LocalDate.of(2022, 11, 21),"19:00","Estadio Al Bayt");
        createMatch((long) 2,"Senegal","Países Bajos",LocalDate.of(2022, 11, 21),"13:00","Estadio Al Thumama");
        createMatch((long) 3,"Qatar","Senegal",LocalDate.of(2022, 11, 25),"18:00","Estadio Al Thumama");
        createMatch((long) 4,"Ecuador","Países Bajos",LocalDate.of(2022, 11, 25),"19:00","Estadio Internacional Khalifa");
        createMatch((long) 5,"Qatar","Países Bajos",LocalDate.of(2022, 11, 29),"18:00","Estadio Al Bayt");
        //createMatch((long) 6,"Ecuador","Senegal",LocalDate.of(2022, 11, 29),"19:00","Estadio Internacional Khalifa");
    }

    private void createMatch(Long idMatch,String localTeam, String vistTeam, LocalDate dateMatch, String timeMatch, String stadium){
   
        matchRepository.save(new MatchGame(
        idMatch,
        vistTeam,
        localTeam,
        dateMatch,
        timeMatch,
        stadium,
        null));
        
    }
    
}
