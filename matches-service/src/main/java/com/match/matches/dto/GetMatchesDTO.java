package com.match.matches.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetMatchesDTO {
    private String vistTeam;
    private String localTeam;
    private LocalDate matchDate;
    private String matchTime;
    private String stadium;
    private String url;
}
