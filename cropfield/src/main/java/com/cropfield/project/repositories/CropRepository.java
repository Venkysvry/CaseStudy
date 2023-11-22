package com.cropfield.project.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cropfield.project.Model.Crop;


@Repository
public interface CropRepository extends MongoRepository<Crop, Integer> {
Crop findByCropId(int id);
List<Crop> findByCropType(String type);
List<Crop> findByCropName(String name);
List<Crop> findByfId(String id);
}
