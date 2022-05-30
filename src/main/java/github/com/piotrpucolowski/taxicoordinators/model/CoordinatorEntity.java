package github.com.piotrpucolowski.taxicoordinators.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @NotBlank
    @Size(min = 4, max = 8)
    private String number;


    @OneToMany // jeden koordynator moze dac wiele upomnien
    private AdmonishtyEntity admonishty;

    @ManyToOne // wielu koordynatorow moze kontrolowac jednego kierowce
    private DriverEntity driver;








}
