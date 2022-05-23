package com.api.service.travel.domain;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Travel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "rating", nullable = false, updatable = true)
    private Double rating = 0.0;
    
    @Column(name = "descripcion", nullable = false, updatable = true)
    private String descripcion;
    
    @Column(name = "traveltime", nullable = false, updatable = true)
    private String travelTime;
    
    @Column(name = "traveldate", nullable = false, updatable = true)
    private LocalDate travelDate;
    
    @Column(name = "travelhour", nullable = false, updatable = true)
    private String travelHour;
    
    @Column(name = "localization", nullable = false, updatable = true)
    private String localization;
    
    @Column(name = "type", nullable = false, updatable = true)
    private String type;
    
    @Column(name = "service", nullable = false, updatable = true)
    private String service;
    
    @Column(name = "company", nullable = false, updatable = true)
    private String company;

    @OneToMany(mappedBy = "travel",cascade = {CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.REFRESH}, orphanRemoval = true)
    private List<TravelTicket> tickets = new ArrayList<TravelTicket>();
}
