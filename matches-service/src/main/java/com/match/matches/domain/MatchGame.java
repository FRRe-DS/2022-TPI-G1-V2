package com.match.matches.domain;

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
public class MatchGame {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vistTeam", nullable = false, updatable = true)
    private String vistTeam;

    @Column(name = "localTeam", nullable = false, updatable = true)
    private String localTeam;

    @NotNull
    @Column(name = "matchDate", nullable = false, updatable = true)
    private LocalDate matchDate;

    @NotNull
    @Column(name = "matchTime", nullable = false, updatable = true)
    private String matchTime;

    @Column(name = "stadium", nullable = false, updatable = true)
    private String stadium;

    @OneToMany(mappedBy = "matchgame",cascade = {CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.REFRESH}, orphanRemoval = true)
    private List<MatchTicket> tickets = new ArrayList<MatchTicket>(); 
}
