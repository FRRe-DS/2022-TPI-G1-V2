package com.example.demo.mapper;

import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.Pack;
import com.example.demo.dto.GetPackDTO;
import com.example.demo.dto.PostPackDTO;
import com.example.demo.request.GetMatchByIdDTO;
import com.example.demo.service.HealthClientRest;
import com.example.demo.service.LodgingClientRest;
import com.example.demo.service.MatchClientRest;
import com.example.demo.service.TravelClientRest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PackMapper {
    
    private final TravelClientRest travelClientRest;
    private final MatchClientRest matchClientRest;
    private final HealthClientRest healthClientRest;
    private final LodgingClientRest lodgingClientRest;
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
        
            return (controlRelational(pack,postPackDTO))?pack:null;            
    }

    private Boolean controlRelational(Pack pack,PostPackDTO postPackDTO){
        if(controlMatches(postPackDTO.getMatches())){
            pack.setMatches(postPackDTO.getMatches());
        }else{
            return false;
        }
        
        if(controlHealths(postPackDTO.getHealthInsurance())){
            pack.setHealthInsurance(postPackDTO.getHealthInsurance());
        }else{
            return false;
        }
        
        if(controlTravel(postPackDTO.getTravel())){
            pack.setTravel(postPackDTO.getTravel());
        }else{
            return false;
        }
        
        if(controlTravel(postPackDTO.getTravel())){
            pack.setTravel(postPackDTO.getTravel());
        }else{
            return false;
        }
        return true;
    }

    public GetPackDTO  packGetMapper(Pack pack) {
        GetPackDTO packRequest = GetPackDTO.builder()
             .id(pack.getId())
             .title(pack.getTitle())
             .cost(pack.getCost())
             .description(pack.getDescription())
             .cost(pack.getCost()-(pack.getCost()*(pack.getCost()/100)))
             .contact(pack.getContact())
             .discount(pack.getDiscount())
             .reserved(pack.getReserved())
             .date(pack.getCreationDate())
             .build();
         
             if(!pack.getMatches().isEmpty())
             packRequest.setMatches(loadMatches(pack.getMatches()));

             if(!pack.getHealthInsurance().isEmpty())
             packRequest.setHealthInsurance(loadHealths(pack.getHealthInsurance()));
             
             if(pack.getTravel() != null)
             packRequest.setTravel(loadTravel(pack.getTravel()));
             
             if(pack.getLodging() != null)
             packRequest.setLodging(loadLodging(pack.getLodging()));

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

    private Boolean controlHealths(List<Long> healthsId){
        int errors = 0;
        for (Long health : healthsId) {
            ResponseEntity<?> matchRequest = healthClientRest.getHealthServiceById(health);
                
            if(matchRequest.getStatusCode() != HttpStatus.OK){
                    errors += 1;
            }
        }
        return (errors > 0)?false:true;
    }

    private Boolean controlTravel(Long travelId){

        ResponseEntity<?> healthRequest = travelClientRest.getTravelById(travelId);;
                
        return (healthRequest.getStatusCode() != HttpStatus.OK)?false:true;
    }

    private Boolean controlLodging(Long lodgingId){

        ResponseEntity<?> lodgingRequest = lodgingClientRest.getLodgingById(lodgingId);
                
        return (lodgingRequest.getStatusCode() != HttpStatus.OK)?false:true;
    }


    private List<Object> loadMatches(List<Long> objectsId){
        List<Object> listResult = new ArrayList<>();
        for (Long req : objectsId) {
            ResponseEntity<?> matchRequest = matchClientRest.getMatchById(req);
            
            if(matchRequest.getStatusCode() == HttpStatus.OK){
                Object matchRequest2 = matchRequest.getBody();
                listResult.add(matchRequest2);
            }
        }
        return listResult;
    }

    private List<Object> loadHealths(List<Long> objectsId){
        List<Object> listResult = new ArrayList<>();
        for (Long req : objectsId) {
            ResponseEntity<?> healthRequest = healthClientRest.getHealthServiceById(req);
            
            if(healthRequest.getStatusCode() == HttpStatus.OK){
                Object matchRequest2 = healthRequest.getBody();
                listResult.add(matchRequest2);
            }
        }
        return listResult;
    }

    private Object loadTravel(Long objectsId){
        Object result = null;
        ResponseEntity<?> healthRequest = travelClientRest.getTravelById(objectsId);

        if(healthRequest.getStatusCode() == HttpStatus.OK){
            result = healthRequest.getBody();
        }
        return result;
    }

    private Object loadLodging(Long objectsId){
        Object result = null;
        ResponseEntity<?> lodgingRequest = lodgingClientRest.getLodgingById(objectsId);

        if(lodgingRequest.getStatusCode() == HttpStatus.OK){
            result = lodgingRequest.getBody();
        }
        return result;
    }

}
