package com.mic.fleetmanagement.services;

import com.mic.fleetmanagement.domain.Difficulty;
import com.mic.fleetmanagement.domain.Region;
import com.mic.fleetmanagement.domain.Tour;
import com.mic.fleetmanagement.domain.TourPackage;
import com.mic.fleetmanagement.repo.TourPackageRepository;
import com.mic.fleetmanagement.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TourService {

    private TourRepository tourRepository;
    private TourPackageRepository  tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createNew(String title, String description, String blurb,
                     Integer price, String duration, String bullets, String keyword,
                     String tourPackageCode, Region region, Difficulty difficulty) {

        Optional<TourPackage> tourPackage=tourPackageRepository.findById(tourPackageCode);

        if(!tourPackage.isPresent()){
            throw new RuntimeException("Tour package not exist with the code ->" +tourPackageCode);
        }

        return tourRepository.save(new Tour( title,  description,  blurb,
                 price,  duration,  bullets,  keyword,
                 tourPackage.get(),  difficulty,region));
    }

    public  Iterable<Tour> allTours(){
        return tourRepository.findAll();
    }

    public long numberOfTours(){
        return tourRepository.count();
    }

    }

