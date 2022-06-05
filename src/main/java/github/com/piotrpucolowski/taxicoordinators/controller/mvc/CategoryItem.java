package github.com.piotrpucolowski.taxicoordinators.controller.mvc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryItem {

    private Long id;
    private String name;
    private String description;

    public static CategoryItem valueof(String id) {
        return CategoryItem.builder().id(Long.parseLong(id)).build();
    }
}
