package com.example.Service.ServiceHealthInsurance.config;

import java.util.HashSet;
import java.util.Set;

import com.example.Service.ServiceHealthInsurance.domain.HealthService;
import com.example.Service.ServiceHealthInsurance.repository.HealthServiceRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DataLoaderRunner implements CommandLineRunner{


    private final HealthServiceRepository healthServiceRepository;

    @Override
    public void run(String... args) throws Exception {
        if(healthServiceRepository.findAll().isEmpty()) loadHealthService();
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


}
