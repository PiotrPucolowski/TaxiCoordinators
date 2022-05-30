package github.com.piotrpucolowski.taxicoordinators.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Drivers")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class DriverEntity {

    @Id
    private String id;
    @NotBlank
    private String carPlate; // numer kierowcy


    @ManyToOne //wielu kierowców mozę mieć to samo upomnienie
    //trzeba zmienic na wielu kierowców może mieć wiele upomnien ( @manytoMany?)
    private AdmonishtyEntity admonishty;

    @ManyToOne // kierowce może upomnieć wielu koordynatorów
    private  CoordinatorEntity coordinator;




}
