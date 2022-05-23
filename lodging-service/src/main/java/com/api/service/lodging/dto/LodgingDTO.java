package com.api.service.lodging.dto;
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
public class LodgingDTO {

    private String nameHotel;
    private String localization;
    private String description;
    private String contact;
    private List<RoomDTO> listRooms = new ArrayList<>() ;
}
