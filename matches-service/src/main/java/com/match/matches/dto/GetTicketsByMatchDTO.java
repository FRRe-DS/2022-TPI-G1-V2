package com.match.matches.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetTicketsByMatchDTO {
    private String matchUrl;
    private String position;
    private Double cost;
}
