package com.api.service.lodging.mapper;

import java.util.ArrayList;
import java.util.List;

import com.api.service.lodging.domain.Room;
import com.api.service.lodging.dto.RoomDTO;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RoomMapper {
    
    public List<Room> roomMapper(List<RoomDTO> lRoomDTOs) {
        List<Room> listRooms = new ArrayList<>();

        for (RoomDTO rooms : lRoomDTOs) {
            
            listRooms.add(
                Room.builder()
                .numberRoom(rooms.getNumberRoom())
                .occupancy(rooms.getOccupancy())
                .service(rooms.getService())
                .build());
        }
        return listRooms;
    }

    public List<RoomDTO> roomDTOMapper(List<Room> lRoomDTOs) {
        List<RoomDTO> listRooms = new ArrayList<>();

        for (Room rooms : lRoomDTOs) {
            
            listRooms.add(
                RoomDTO.builder()
                    .numberRoom(rooms.getNumberRoom())
                    .occupancy(rooms.getOccupancy())
                    .service(rooms.getService())
                    .build()
                );
        }
        return listRooms;
    }


}
