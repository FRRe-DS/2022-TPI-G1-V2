package com.service.payment_service.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.service.payment_service.domain.CreditCard;
import com.service.payment_service.dto.CreditCardPostDTO;
import com.service.payment_service.mapper.CreditCardMapper;
import com.service.payment_service.repository.CreditCardRepository;
import com.service.payment_service.service.CreditCardService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CreditCardServiceImpl implements CreditCardService{
    private final CreditCardRepository creditCardRepository;
    private final CreditCardMapper creditCardMapper;

    @Override
    public CreditCard createCreditCard(CreditCardPostDTO creditCardPostDTO) {
        if(controlCreditCardNumber(creditCardPostDTO.getNumber()) == false){
            return null;
        }
        return creditCardRepository.save(creditCardMapper.creditCardMapper(creditCardPostDTO));
    }

    private boolean controlCreditCardNumber(String cardNumber){
        if(cardNumber == null) return false;

        ArrayList<Character> list = new ArrayList<Character>();
        char[] characterArray = cardNumber.toCharArray();
        for(char c : characterArray) list.add(c);

        for (Character digit : list) {
            Boolean control = controlDigit(digit);
            if(!control) return false;
        }

        return procesDigits(list);
    }

    private boolean procesDigits(ArrayList<Character> list){
        //Luhn Algorithm
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if(i%2 != 0){
                if(list.get(i)*2>9){
                    int num1 = list.get(i)/100;
                    int num2 = list.get(i)/10;
                    int sumParcial = num1 + num2;
                    sum += sumParcial;
                }else{
                    sum += list.get(i)*2;
                }
            }else{
                sum += list.get(i);
            }
        }
        return(sum%10 == 0)?true:false;
    }

    private boolean controlDigit(Character digit){
            try {
                Integer.valueOf(digit);   
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
    }

    @Override
    public List<CreditCard> getAllCardsByClient(Long id) {
        return creditCardRepository.findAllByClient(id);
    }

    
}
