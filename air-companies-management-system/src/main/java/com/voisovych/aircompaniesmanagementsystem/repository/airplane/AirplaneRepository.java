package com.voisovych.aircompaniesmanagementsystem.repository.airplane;

import com.voisovych.aircompaniesmanagementsystem.model.Airplane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends CrudRepository<Airplane, Long> {
    Airplane findByFactorySerialNumber(String factorySerialNumber);
}
