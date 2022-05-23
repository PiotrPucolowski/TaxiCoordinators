package github.com.piotrpucolowski.taxicoordinators.controller.mvc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class CreateUserForm {

    @NotBlank @Length(min = 4)
    private String username;
    private String nickname;

}
