package github.com.piotrpucolowski.taxicoordinators.model;

import github.com.piotrpucolowski.taxicoordinators.validator.PasswordConfirmation;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter @ToString(exclude = "password", callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserEntity{ // Koordynator bądz admin

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    @Size( min = 2, max = 15)
    private String username;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Size(min = 6, max = 30)
    private String password;
    @PasswordConfirmation
    private String matchingPassword;
    @NotBlank
    @Size( min = 2, max = 15 )
    private String role;


    @OneToMany
    @ToString.Exclude
    private List<AdmonishEntity> admonishList = new ArrayList<>();
    //jeden uzytkownik(koordynator) może dać wiele upomnien

    @OneToOne
    private BlockEntity block;
    //uzytkownik moze dac tylko jeden efekt upomnienia ( ale czy to bedzie dzialac, ze moze dac jeden efekt upomnienia kierowcyA, a kierowcyB inny efekt ale tez tylko jeden?)

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    @ToString.Exclude
    private List<RoleEntity> roleList = new ArrayList<>();
}
