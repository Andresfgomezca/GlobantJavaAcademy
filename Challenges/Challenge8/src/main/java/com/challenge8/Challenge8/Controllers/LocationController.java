package com.challenge8.Challenge8.Controllers;

import com.challenge8.Challenge8.Models.Location;
import com.challenge8.Challenge8.Models.MeteorologicalData;
import com.challenge8.Challenge8.Services.LocationService;
import com.challenge8.Challenge8.Services.MeteorologicalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private MeteorologicalDataService meteorologicalDataService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        List<Location> locationList = locationService.list();
        model.addAttribute("location", new Location());
        model.addAttribute("meteorologicalData", new MeteorologicalData());
        model.addAttribute("locationList", locationList);
        model.addAttribute("lastLocationId", locationList.size());

        return "home";
    }

    @PostMapping(path = "/add")
    private String add(Location location) {
        locationService.create(location);
        return "redirect:/home";
    }


    @PostMapping(path = "/remove")
    private String delete(Long id) {
        int tempV = 0;
        if (locationService.list().size() == 0) {
            System.out.println("there are not locations to remove");
        } else {
            for (MeteorologicalData mData : meteorologicalDataService.list()) {
                if (mData.getLocation().getId() ==id) {
                    tempV++;
                }

            }
            if (tempV == 0) {
                //this method verifies that the location that we are trying to remove is
                // not associated to any meteorological report
                locationService.delete(Math.toIntExact(id));
            }
            System.out.println("Can not remove an item that is associated to " + tempV + " data report(s)");
        }

        return "redirect:/home";
    }
}
