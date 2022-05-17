package com.packageadmin.servicepackageadmin.config;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.packageadmin.servicepackageadmin.domain.HealthService;
import com.packageadmin.servicepackageadmin.domain.MatchGame;
import com.packageadmin.servicepackageadmin.domain.RoomService;
import com.packageadmin.servicepackageadmin.repository.HealthServiceRepository;
import com.packageadmin.servicepackageadmin.repository.MatchRepository;
import com.packageadmin.servicepackageadmin.repository.RoomServiceRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DataLoaderRunner implements CommandLineRunner{
    

    private MatchRepository matchRepository;
    private HealthServiceRepository healthServiceRepository;
    private RoomServiceRepository roomServiceRepository;

    @Override
    public void run(String... args) throws Exception {
        
        if(matchRepository.findAll().isEmpty()) loadMatchs();
        if(healthServiceRepository.findAll().isEmpty()) loadHealthService();
        if(roomServiceRepository.findAll().isEmpty()) roomService();
    }

    private void loadMatchs(){
        
        createMatch((long) 1,"Qatar","Ecuador",LocalDate.of(2022, 11, 21),"19:00","Estadio Al Bayt","Estadio Al Bayt");
        createMatch((long) 2,"Senegal","Países Bajos",LocalDate.of(2022, 11, 21),"13:00","Estadio Al Thumama","Estadio Al Thumama");
        createMatch((long) 3,"Qatar","Senegal",LocalDate.of(2022, 11, 25),"18:00","Estadio Al Thumama","Estadio Al Thumama");
        createMatch((long) 4,"Ecuador","Países Bajos",LocalDate.of(2022, 11, 25),"19:00","Estadio Internacional Khalifa","Estadio Internacional Khalifa");
        createMatch((long) 5,"Qatar","Países Bajos",LocalDate.of(2022, 11, 29),"18:00","Estadio Al Bayt","Estadio Al Bayt");
        createMatch((long) 6,"Ecuador","Senegal",LocalDate.of(2022, 11, 29),"19:00","Estadio Internacional Khalifa","Estadio Internacional Khalifa");
    }

    private void createMatch(Long idMatch,String localTeam, String vistTeam, LocalDate dateMatch, String timeMatch,String localization, String stadium){
   
        matchRepository.save(new MatchGame(
        idMatch,
        vistTeam,
        localTeam,
        dateMatch,
        timeMatch,
        localization,
        stadium,
        0,
        null));
        
    }

    private void loadHealthService(){
        Set<String> healthServiceDescription = new HashSet<String>();
        healthServiceDescription.add("Generous medical and evacuation limits.");
        healthServiceDescription.add("Top-notch baggage loss coverage of $3,000 per person.");
        healthServiceDescription.add("Generous missed connection coverage of $1,500 per person (but for cruises and tours only).");
        healthServiceDescription.add("Superior medical coverage of $500,000.");
        healthServiceDescription.add("Good hurricane and weather coverage.");
        healthServiceDescription.add("Top-notch coverage limits for medical expenses and evacuation.");
        healthServiceDescription.add("Excellent baggage loss coverage limit of $2,000 per person.");
        healthServiceDescription.add("Superior medical expenses and medical evacuation coverage limits.");
        healthServiceDescription.add("Includes coverage for sports equipment loss.");
        healthServiceDescription.add("Includes $20,000 for non-medical evacuation, which includes coverage to get you to a safe place or back home if there’s a Travel Advisory.");
        Long idService = (long) 0;

        for (String service : healthServiceDescription) {
            healthServiceRepository.save(new HealthService(idService + 1,service));
        }    
    }

    private void roomService(){
        Set<String> roomServiceDescription = new HashSet<String>();
        roomServiceDescription.add("Hotel management");
        roomServiceDescription.add("Restaurant manager");
        roomServiceDescription.add("Waiter/waitress");
        roomServiceDescription.add("Executive chef");
        roomServiceDescription.add("Kitchen staff");
        roomServiceDescription.add("Continental breakfast attendant");
        roomServiceDescription.add("Food runner");
        roomServiceDescription.add("Superior medical expenses and medical evacuation coverage limits.");
        Long idService = (long) 0;

        for (String service : roomServiceDescription) {
            roomServiceRepository.save(new RoomService(idService + 1,service));
        }    
    }


}
