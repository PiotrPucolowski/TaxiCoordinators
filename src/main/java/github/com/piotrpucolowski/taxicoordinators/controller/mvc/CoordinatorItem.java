package github.com.piotrpucolowski.taxicoordinators.controller.mvc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoordinatorItem {

    private Long id;
    private String firstName;
    private String lastName;
    private String number;

    public String getFullName(){
        return String.join( " ", firstName, lastName, number);
    }
}
