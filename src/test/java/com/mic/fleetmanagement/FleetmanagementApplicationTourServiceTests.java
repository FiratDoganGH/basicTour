package com.mic.fleetmanagement;

import com.mic.fleetmanagement.domain.Difficulty;
import com.mic.fleetmanagement.domain.Region;
import com.mic.fleetmanagement.domain.Tour;
import com.mic.fleetmanagement.domain.TourPackage;
import com.mic.fleetmanagement.services.TourPackageService;
import com.mic.fleetmanagement.services.TourService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FleetmanagementApplicationTourServiceTests {

    @Autowired
    private TourService tourService;

    @Autowired
    private TourPackageService tourPackageService;
    private String tourCode="KRD01";
    private String tourPackageName ="Black Sea tour package";
    private String tourTitle ="Black Sea";

    private TourPackage tourPackage;

    @Before
    public void initilaize(){
        tourPackage=tourPackageService.createTourPackage(tourCode, tourPackageName);
    }


    @Test
    public void contextLoads() {
    }

    @Test
    public void test_For_Create_New_Tour(){
        Tour newTour=tourService.createNew(tourTitle,"Wild rivers and bridges","Blrp",1250,
                "10 days","Bullets","keywords",tourPackage.getCode(), Region.Central_Coast, Difficulty.ExtraDifficult);

        Assert.assertEquals(tourTitle,newTour.getTitle());
    }



}
