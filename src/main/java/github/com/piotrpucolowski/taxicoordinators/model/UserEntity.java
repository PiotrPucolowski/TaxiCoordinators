package github.com.piotrpucolowski.taxicoordinators.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Getter @Setter @ToString(exclude = "password") @EqualsAndHashCode(of = "id")
@NoArgsConstructor @AllArgsConstructor @Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size( min = 2, max = 15)
    private String username;
    @NotBlank
    @Size(min = 6, max = 30)
    private String password;
    @NotBlank
    @Size(min = 4, max = 8)
    private String login;

    @NotBlank
    @Size( min = 2, max = 15 )
    private String role;

    @ManyToOne
    private UserEntity user;
    @OneToOne
    private CoordinatorEntity coordinator;




}
