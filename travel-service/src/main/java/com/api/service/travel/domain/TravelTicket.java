package com.api.service.travel.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelTicket {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numbertravel", nullable = false, updatable = true)
    private Long numberTravel;

    @Column(name = "buyed", nullable = false, updatable = true)
    private Boolean buyed;

    @Column(name = "position", nullable = false, updatable = true)
    private String position;

    @OneToOne(cascade = {})
    @JoinColumn(name="travel", nullable = false, updatable = true)
    private Travel travel;
}
