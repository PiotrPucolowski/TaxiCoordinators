package github.com.piotrpucolowski.taxicoordinators.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "coordinators")
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor @AllArgsConstructor @SuperBuilder
public class CoordinatorEntity extends BaseEntity{

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Size(min = 4, max = 8)
    private String number;

    @NotBlank
    private String password;


}
