package github.com.piotrpucolowski.taxicoordinators.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "block")
@Getter
@Setter
@ToString( callSuper = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BlockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Min(0) @Max(72)
    @Digits(integer = 1, fraction = 0)
    private String block;

    @NotBlank
    private LocalDate startDate;

    @NotBlank
    private LocalDate endDate;

    @OneToMany
    private List<DriverEntity> driverList = new ArrayList<>();
    //jeden efekt można dać wielu kierowcom

    @OneToMany
    private List<UserEntity> userList = new ArrayList<>();
    //jeden efekt moze byc dana przez wielu userow(koordynatorow)

}
