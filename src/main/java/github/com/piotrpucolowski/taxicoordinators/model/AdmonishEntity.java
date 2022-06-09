package github.com.piotrpucolowski.taxicoordinators.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Admonish")
@Getter
@Setter
@ToString( callSuper = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AdmonishEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String admonishty;

    @NotBlank @Pattern(regexp = "nothing|block", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String effect;


    @OneToMany
    private List<UserEntity> userList = new ArrayList<>();
    // jedno upomnienie moze byc dane przez wielu koordynatorow
    @OneToOne
    private BlockEntity block;
    //tylko jeden efekt upomnienia

    @ManyToOne
    private DriverEntity driver;
    //wiele upomnien dla jednego kierowcy;







}
