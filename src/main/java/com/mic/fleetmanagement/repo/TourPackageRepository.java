package com.mic.fleetmanagement.repo;

import com.mic.fleetmanagement.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TourPackageRepository extends CrudRepository<TourPackage,String> {

    public  TourPackage findByName(@Param("name") String packageName);
}
