package com.api.service.lodging.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
public class Room {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name = "number", nullable = false, updatable = true)
    private Long numberRoom;
    
    @NotNull
    @Column(name = "occupancy", nullable = false, updatable = true)
    private int occupancy;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="lodging", nullable = false, updatable = true)
    private Lodging lodging;

    @Column(name = "roomServices", nullable = false, updatable = true)
    private String service;
}
