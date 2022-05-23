package com.match.matches.dto;
import java.time.LocalDate;
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
public class GetMatchByIdDTO {
    private String url;
    private String vistTeam;
    private String localTeam;
    private LocalDate matchDate;
    private String matchTime;
    private String stadium;
    private List<GetTicketsDTO> listTickets = new ArrayList<GetTicketsDTO>();    
}
