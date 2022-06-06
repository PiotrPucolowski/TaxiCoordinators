package github.com.piotrpucolowski.taxicoordinators.service;

import github.com.piotrpucolowski.taxicoordinators.controller.mvc.CategoryItem;
import github.com.piotrpucolowski.taxicoordinators.controller.mvc.CoordinatorItem;
import github.com.piotrpucolowski.taxicoordinators.controller.mvc.CreateAdmonishForm;

import java.util.List;

public interface AdmonishService {

    void createAdmonish(CreateAdmonishForm createAdmonishForm);

    List<CoordinatorItem> getAllCoordinators();

    List<CategoryItem> getAllCategories();
}
