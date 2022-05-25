package com.example.demo.request;

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
public class Lodging {
    private String url;
    private String nameHotel;
    private String localization;
    private String description;
    private String contact;
    private Double rating;
    private List<Room> listRooms = new ArrayList<>();
}
