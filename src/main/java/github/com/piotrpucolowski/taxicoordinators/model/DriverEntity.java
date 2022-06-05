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
    private String carPlate;

    @ManyToOne
    private CoordinatorEntity coordinatorEntities;

    @ManyToMany
    private List<CoordinatorEntity> coordinators;

    @ManyToMany
    private List<CategoryEntity> categories = new ArrayList<>();

}
