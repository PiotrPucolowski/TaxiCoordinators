package github.com.piotrpucolowski.taxicoordinators.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Admonishty")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class AdmonishtyEntity {

    @Id
    private String id;

    @NotBlank
    private String Admonish;

    @ManyToOne
    private CoordinatorEntity coordinator;
    @ManyToOne
    private DriverEntity driver;


}
