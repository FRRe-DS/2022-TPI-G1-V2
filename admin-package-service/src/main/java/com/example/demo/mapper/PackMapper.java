package com.example.demo.mapper;

import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.Pack;
import com.example.demo.dto.GetPackDTO;
import com.example.demo.dto.PostPackDTO;
import com.example.demo.request.GetMatchByIdDTO;
import com.example.demo.service.MatchClientRest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PackMapper {
    
    private final MatchClientRest matchClientRest;
//GetPackDTO
    public Pack  packMapper(PostPackDTO postPackDTO) {
        Clock cl = Clock.systemUTC();
        LocalDate lt = LocalDate.now(cl);

       Pack pack = Pack.builder()
            .title(postPackDTO.getTitle())
            .cost(postPackDTO.getCost())
            .description(postPackDTO.getDescription())
            .cost(postPackDTO.getCost())
            .contact(postPackDTO.getContact())
            .discount(postPackDTO.getDiscount())
            .reserved(false)
            .creationDate(lt)
            .build();
        
            if(controlMatches(postPackDTO.getMatches()))
            pack.setMatches(postPackDTO.getMatches());
            
            return pack;
    }

    public GetPackDTO  packGetMapper(Pack pack) {
        GetPackDTO packRequest = GetPackDTO.builder()
             .title(pack.getTitle())
             .cost(pack.getCost())
             .description(pack.getDescription())
             .cost(pack.getCost())
             .contact(pack.getContact())
             .discount(pack.getDiscount())
             .reserved(pack.getReserved())
             .date(pack.getCreationDate())
             .build();
         
             if(!pack.getMatches().isEmpty())
             packRequest.setMatches(loadMatches(pack.getMatches()));
             
             return packRequest;
     }
    
    private Boolean controlMatches(List<Long> matchesId){
        int errors = 0;
        for (Long match : matchesId) {
            ResponseEntity<?> matchRequest = matchClientRest.getMatchById(match);
                
            if(matchRequest.getStatusCode() != HttpStatus.OK){
                    errors += 1;
            }
        }
        return (errors > 0)?false:true;
    }

    private List<Object> loadMatches(List<Long> matchesId){
        List<Object> listMatches = new ArrayList<>();
        for (Long match : matchesId) {
            ResponseEntity<?> matchRequest = matchClientRest.getMatchById(match);
            
            if(matchRequest.getStatusCode() == HttpStatus.OK){
                Object matchRequest2 = matchRequest.getBody();
                listMatches.add(matchRequest2);
            }
        }
        return listMatches;
    }

}
