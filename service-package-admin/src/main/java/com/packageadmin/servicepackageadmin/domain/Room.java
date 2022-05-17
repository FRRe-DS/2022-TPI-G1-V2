package com.packageadmin.servicepackageadmin.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
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

    @OneToOne(cascade = {})
    @JoinColumn(name="lodging", nullable = false, updatable = true)
    private Lodging lodging;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = true)
    private List<RoomService> services = new ArrayList<RoomService>();
}
