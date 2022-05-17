package com.packageadmin.servicepackageadmin.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchTicket {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {})
    private MatchGame matchgame;

    @NotBlank
    @Column(name = "position", nullable = false, updatable = true)
    private String position;

    @NotNull
    @Column(name = "cost", nullable = false, updatable = true)
    private Double cost;
}
