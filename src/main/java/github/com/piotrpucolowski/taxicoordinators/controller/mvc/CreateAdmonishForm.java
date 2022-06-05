package github.com.piotrpucolowski.taxicoordinators.controller.mvc;

import github.com.piotrpucolowski.taxicoordinators.model.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAdmonishForm {

    @NotBlank
    @Length(min = 5)
    private String Admonish;

    @Builder.Default
    private String driver;
    private CoordinatorItem mainCoordinator;
    @Builder.Default
    private List<CoordinatorItem> coordinators = new ArrayList<>();
    @Builder.Default
    private List<CategoryItem> categories = new ArrayList<>();

}
