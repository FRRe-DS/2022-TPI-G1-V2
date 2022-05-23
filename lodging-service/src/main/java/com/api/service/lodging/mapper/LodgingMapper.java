package com.api.service.lodging.mapper;

import java.util.ArrayList;
import java.util.List;

import com.api.service.lodging.domain.Lodging;
import com.api.service.lodging.domain.Room;
import com.api.service.lodging.dto.GetLodgingDTO;
import com.api.service.lodging.dto.LodgingDTO;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class LodgingMapper {
    private final RoomMapper roomMapper;
    
    public Lodging lodgingMapper(LodgingDTO lodgingDTO) {
        
        Lodging lodging = Lodging.builder()
            .contact(lodgingDTO.getContact())
            .description(lodgingDTO.getDescription())
            .localization(lodgingDTO.getLocalization())
            .nameHotel(lodgingDTO.getNameHotel())
            .rating(0.0)
            .build();

        if(!lodgingDTO.getListRooms().isEmpty())
        lodging = loadRooms(lodgingDTO,lodging);
        
        return lodging;
    }

    public List<GetLodgingDTO> returnLodgings(List<Lodging> lodgings){
        List<GetLodgingDTO> lodgingDTOs = new ArrayList<>();
        
        for (Lodging lodging : lodgings) {
            lodgingDTOs.add(
                GetLodgingDTO.builder()
                    .nameHotel(lodging.getNameHotel())
                    .contact(lodging.getContact())
                    .description(lodging.getDescription())
                    .localization(lodging.getLocalization())
                    .rating(lodging.getRating())
                    .url("/lodging"+lodging.getId())
                    .listRooms(roomMapper.roomDTOMapper(lodging.getRooms()))
                    .build()
            );
        }
        return lodgingDTOs;
    }

    public GetLodgingDTO returnLodging(Lodging lodgings){
        return GetLodgingDTO.builder()
                .nameHotel(lodgings.getNameHotel())
                .contact(lodgings.getContact())
                .description(lodgings.getDescription())
                .localization(lodgings.getLocalization())
                .rating(lodgings.getRating())
                .url("/lodging"+lodgings.getId())
                .listRooms(roomMapper.roomDTOMapper(lodgings.getRooms()))
                .build();
    }

     

    private Lodging loadRooms(LodgingDTO lodgingDTO, Lodging lodging){
        List<Room> rooms = roomMapper.roomMapper(lodgingDTO.getListRooms());
        for (Room room : rooms) {
            room.setLodging(lodging);
        }
        lodging.setRooms(rooms);
        return lodging;
    }
}
