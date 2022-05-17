package com.packageadmin.servicepackageadmin.domain;

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
public class Lodging {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id; 

    @NotBlank
    @Column(name = "hotel", nullable = false, updatable = true)
    private String nameHotel;

    @NotBlank
    @Column(name = "localization", nullable = false, updatable = true)
    private String localization;

    @NotNull
    @Column(name = "rating", nullable = false, updatable = true)
    private Double rating = 0.0;

    @NotBlank
    @Column(name = "description", nullable = false, updatable = true)
    private String description;

    @OneToMany(mappedBy = "lodging",cascade = {CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.REFRESH}, orphanRemoval = true)
    private List<Room> rooms = new ArrayList<Room>(); 
}
