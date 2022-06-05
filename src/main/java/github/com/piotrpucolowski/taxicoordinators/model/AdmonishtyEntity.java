package github.com.piotrpucolowski.taxicoordinators.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Admonishty")
@Getter
@Setter
@ToString(exclude = {"Coordinators"}, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AdmonishtyEntity extends BaseEntity{

    @NotBlank
    private String driver;

    @Positive
    private String admonish;

    @ManyToOne// wiele upomnien moze byc danych przez jednego koordynatora
    private CoordinatorEntity mainCoordinator;

    @ManyToMany //wielu koordynatorow moze dac wiele upomnien
    private List<CoordinatorEntity> coordinators;

    @ManyToMany
    @Builder.Default
    private List<CategoryEntity> categories = new ArrayList<>();






}
