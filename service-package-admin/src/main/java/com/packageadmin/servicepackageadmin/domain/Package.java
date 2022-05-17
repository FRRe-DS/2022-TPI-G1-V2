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
import javax.persistence.ManyToMany;
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
public class Package {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "rating", nullable = false, updatable = true)
    private Double rating = 0.0;

    @NotBlank
    @Column(name = "descripcion", nullable = false, updatable = true)
    private String descripcion;

    @NotBlank
    @Column(name = "enterprise", nullable = false, updatable = true)
    private String enterprise;

    @NotNull
    @Column(name = "price", nullable = false, updatable = true)
    private Double price;

    @OneToOne
    @JoinColumn(name="healthInsurance", nullable = true, updatable = true)
    private HealthInsurance healthInsurance;

    @OneToOne
    @JoinColumn(name="lodging", nullable = false, updatable = true)
    private Lodging lodging;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<MatchGame> matches = new ArrayList<MatchGame>();

    @OneToOne
    @JoinColumn(name="travel", nullable = false, updatable = true)
    private Travel travel;
}
