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
public class MatchGame {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "vistTeam", nullable = false, updatable = true)
    private String vistTeam;

    @NotBlank
    @Column(name = "localTeam", nullable = false, updatable = true)
    private String localTeam;

    @NotNull
    @Column(name = "matchDate", nullable = false, updatable = true)
    private LocalDate matchDate;

    @NotNull
    @Column(name = "matchTime", nullable = false, updatable = true)
    private String matchTime;

    @NotBlank
    @Column(name = "localization", nullable = false, updatable = true)
    private String localization;

    @NotBlank
    @Column(name = "stadium", nullable = false, updatable = true)
    private String stadium;

    @NotNull
    @Column(name = "countTickets", nullable = false, updatable = true)
    private int countTickets;

    @OneToMany(mappedBy = "matchgame",cascade = {CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.REFRESH}, orphanRemoval = true)
    private List<MatchTicket> tickets = new ArrayList<MatchTicket>(); 
}
