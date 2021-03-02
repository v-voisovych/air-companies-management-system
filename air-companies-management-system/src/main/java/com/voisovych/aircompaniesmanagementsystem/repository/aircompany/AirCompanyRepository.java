package com.voisovych.aircompaniesmanagementsystem.repository.aircompany;

import com.voisovych.aircompaniesmanagementsystem.model.AirCompany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCompanyRepository extends CrudRepository<AirCompany, Long> {
    AirCompany findByName(String name);
}
