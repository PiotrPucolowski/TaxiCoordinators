package github.com.piotrpucolowski.taxicoordinators.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Drivers")
@Getter
@Setter
@ToString(exclude = {"coordinators"}, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DriverEntity extends BaseEntity {

    @NotBlank
    @Column(unique = true)
    private String carPlate;

}
