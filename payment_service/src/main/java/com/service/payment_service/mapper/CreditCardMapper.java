package com.service.payment_service.mapper;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.service.payment_service.domain.CreditCard;
import com.service.payment_service.dto.CreditCardPostDTO;

@Component
public class CreditCardMapper {
    protected static Random random = new Random();    
    public CreditCard creditCardMapper(CreditCardPostDTO creditCardPostDTO){
        CreditCard creditCard = new CreditCard();

        return creditCard.builder()
                  .client(creditCardPostDTO.getClient())
                  .cvv(creditCardPostDTO.getCvv())
                  .expiredDate(mappingDate(creditCardPostDTO.getExpiredDate()))
                  .mount(randomInRange())
                  .nameOwner(creditCardPostDTO.getNameOwner())
                  .number(creditCardPostDTO.getNumber())
                  .surnameOwener(creditCardPostDTO.getSurnameOwener())
                  .type(creditCardPostDTO.getType())
                  .build();

    }

    
    public static double randomInRange() {
        double min = 10000.000;
        double max = 100000000.000;
        double range = max - min;
        double scaled = random.nextDouble() * range;
        double shifted = scaled + min;
        return shifted; 
    }

    private LocalDate mappingDate(String date){
        LocalDate localDate = LocalDate.parse(date);
        return localDate;
    }
}
