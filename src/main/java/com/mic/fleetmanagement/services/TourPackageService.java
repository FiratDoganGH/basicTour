package com.mic.fleetmanagement.services;

import com.mic.fleetmanagement.domain.TourPackage;
import com.mic.fleetmanagement.repo.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {

    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }
    public TourPackage createTourPackage(String code,String name){
        if(!tourPackageRepository.existsById(code)){
            tourPackageRepository.save(new TourPackage(code, name));
        }
        return null;
    }

    public Iterable<TourPackage> allPackages(){
        return tourPackageRepository.findAll();
    }

    public long totalNumberOfTourPackages() {
        return  tourPackageRepository.count();
    }
}
