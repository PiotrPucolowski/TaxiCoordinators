package github.com.piotrpucolowski.taxicoordinators.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "driver")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DriverEntity extends BaseEntity {

    @NotBlank
    @Column(unique = true)
    private String carPlate;

    @OneToMany
    private List<AdmonishEntity> admonishList = new ArrayList<>();
    //jeden kierowca moze dostac wiele upomnien

    @OneToOne
    private BlockEntity blockList = new BlockEntity();
    // kierowca moze dostac tylko jeden efekt upomnienia (nic bądz blokada)

    @OneToMany
    private List<UserEntity> userList = new ArrayList<>();
    //jeden kierowca moze zostać upomniany przez wielu koordynatorow

}
