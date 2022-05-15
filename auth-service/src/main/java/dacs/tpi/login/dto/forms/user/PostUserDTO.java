package dacs.tpi.login.dto.forms.user;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUserDTO {

    @NotBlank(message="{error.field_blank}")
    @Column(nullable = false, unique = true)
	private String email;

    @NotBlank(message="{error.field_blank}")
	@Column(nullable = false)
	private String password;
}
