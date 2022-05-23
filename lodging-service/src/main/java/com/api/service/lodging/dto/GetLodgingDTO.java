package com.api.service.lodging.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetLodgingDTO {
    private String url;
    private String nameHotel;
    private String localization;
    private String description;
    private String contact;
    private Double rating;
    private List<RoomDTO> listRooms = new ArrayList<>() ;
}
