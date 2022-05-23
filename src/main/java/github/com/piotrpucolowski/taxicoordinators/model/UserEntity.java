package github.com.piotrpucolowski.taxicoordinators.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
@Getter @Setter @ToString(exclude = "password") @EqualsAndHashCode(of = "id")
@NoArgsConstructor @AllArgsConstructor @Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String username;
    private String password;
    private String role;

    @ManyToOne
    private UserEntity user;



}
