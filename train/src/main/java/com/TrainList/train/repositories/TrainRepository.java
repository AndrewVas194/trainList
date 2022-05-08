package com.TrainList.train.repositories;


import com.TrainList.train.models.Train;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrainRepository extends CrudRepository<Train, Long> {
    /*public List<Train> findByNameContainingIgnoreCase(String name);*/
}
