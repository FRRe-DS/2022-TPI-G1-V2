package com.match.matches.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class MatchTicket {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {})
    private MatchGame matchgame;

    @Column(name = "position", nullable = false, updatable = true)
    private String position;

    @Column(name = "buyed", nullable = false, updatable = true)
    private Boolean buyed = false;

    @NotNull
    @Column(name = "cost", nullable = false, updatable = true)
    private Double cost;
}
