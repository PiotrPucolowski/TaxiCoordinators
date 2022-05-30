package github.com.piotrpucolowski.taxicoordinators.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "coordinators")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class CoordinatorEntity {

    @Id
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotBlank @Email
    private String email;


    @OneToMany
    private AdmonishtyEntity admonishty;






}
