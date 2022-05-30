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

    @ManyToOne // wielu koordynatorów moze dac jedno upomnienie
    private CoordinatorEntity coordinator;
    @ManyToOne // wiele upomnien moze posiadac jeden kierowca ( czy moze @OneToMany - jeden kierowca moze mieć wiele upomnien ? )
    private DriverEntity driver;



}
