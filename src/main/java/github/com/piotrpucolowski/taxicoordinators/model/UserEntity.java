package github.com.piotrpucolowski.taxicoordinators.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Getter @Setter @ToString(exclude = "password", callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserEntity extends BaseEntity {

    @NotBlank
    @Column(unique = true)
    @Size( min = 2, max = 15)
    private String username;

    @NotBlank
    @Size(min = 6, max = 30)
    private String password;


    @NotBlank
    @Size( min = 2, max = 15 )
    private String role;

}
