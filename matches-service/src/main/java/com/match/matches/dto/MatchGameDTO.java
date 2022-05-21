package com.match.matches.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchGameDTO {
    private String vistTeam;
    private String localTeam;
    private String matchDate;
    private String matchTime;
    private String stadium;
    private List<TicketsGameDTO> listTickets = new ArrayList<TicketsGameDTO>();
}
