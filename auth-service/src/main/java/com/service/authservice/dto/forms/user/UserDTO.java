package com.service.authservice.dto.forms.user;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private String email;
	private String password;
    private ArrayList<String> roles = new ArrayList<>();
}
