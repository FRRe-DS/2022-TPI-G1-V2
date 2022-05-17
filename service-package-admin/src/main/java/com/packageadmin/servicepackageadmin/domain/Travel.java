package com.packageadmin.servicepackageadmin.domain;

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Travel {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name = "rating", nullable = false, updatable = true)
    private Double rating = 0.0;
    
    @NotBlank
    @Column(name = "descripcion", nullable = false, updatable = true)
    private String descripcion;
    
    @NotNull
    @Column(name = "traveltime", nullable = false, updatable = true)
    private String travelTime;
    
    @NotNull
    @Column(name = "traveldate", nullable = false, updatable = true)
    private LocalDate travelDate;
    
    @NotBlank
    @Column(name = "travelhour", nullable = false, updatable = true)
    private String travelHour;
    
    @NotBlank
    @Column(name = "localization", nullable = false, updatable = true)
    private String localization;
    
    @NotBlank
    @Column(name = "type", nullable = false, updatable = true)
    private String type;
    
    @NotBlank
    @Column(name = "company", nullable = false, updatable = true)
    private String company;

    @OneToMany(mappedBy = "travel",cascade = {CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.REFRESH}, orphanRemoval = true)
    private List<TravelTicket> tickets = new ArrayList<TravelTicket>();
}
