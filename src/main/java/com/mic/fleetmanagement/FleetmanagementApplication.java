package com.mic.fleetmanagement;

import com.mic.fleetmanagement.domain.Difficulty;
import com.mic.fleetmanagement.domain.Region;
import com.mic.fleetmanagement.services.TourPackageService;
import com.mic.fleetmanagement.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FleetmanagementApplication  implements CommandLineRunner {
    @Autowired
    private TourService tourService;
    @Autowired
    private TourPackageService tourPackageService;



    public static void main(String[] args) {
        SpringApplication.run(FleetmanagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        tourPackageService.createTourPackage("BC","Backspace California");
        tourPackageService.createTourPackage("CC","California Calisepti");
        tourPackageService.allPackages().forEach(tourPackage -> System.out.println(tourPackage));

        tourService.createNew("Lovely paradise","go to loveley paradise desc","blurb",
                567,"2 weeks","bullets here and there","keywords to be known",
                "BC", Region.Southern_California, Difficulty.Easy);
        tourService.allTours().forEach(tour -> System.out.println(tour));


    }
}
