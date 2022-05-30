package github.com.piotrpucolowski.taxicoordinators.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Drivers")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class DriverEntity {

    @Id
    private String id;
    @NotBlank
    private String carPlate;




}
