package com.example.demo.domain;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.example.demo.request.HealthInsurance;
import com.example.demo.request.Lodging;
import com.example.demo.request.GetMatchByIdDTO;
import com.example.demo.request.Travel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pack {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, updatable = true)
    private String title;

    @Column(name = "creationDate", nullable = false, updatable = true)
    private LocalDate creationDate = LocalDate.now();
    
    @Column(name = "cost", nullable = false, updatable = true)
    private Double cost;
    
    @Column(name = "description", nullable = false, updatable = true)
    private String description;
    
    @Column(name = "contact", nullable = false, updatable = true)
    private String contact;
    
    @Column(name = "discount", nullable = true, updatable = true)
    private int discount;
    
    @Column(name = "reserved", nullable = false, updatable = true)
    private Boolean reserved;

    /**RELATIONSHIP */

 //   private List<HealthInsurance> healthInsurance = new ArrayList<>();
 //   private Lodging lodging;
   @Column(name = "matches", nullable = false, updatable = true)
   @ElementCollection(targetClass=Long.class)
   private List<Long> matches = new ArrayList<>();
 //   private Travel travel;

}
