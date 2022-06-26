package com.service.authservice.dto.forms.user;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUserDTO {

    @Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;
}
