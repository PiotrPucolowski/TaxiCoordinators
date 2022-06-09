package github.com.piotrpucolowski.taxicoordinators.service;

import github.com.piotrpucolowski.taxicoordinators.model.BlockEntity;

import java.util.List;

public interface BlockService {

    List<BlockEntity> findAll();

}
