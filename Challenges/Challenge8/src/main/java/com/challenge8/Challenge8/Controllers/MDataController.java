package com.challenge8.Challenge8.Controllers;

import com.challenge8.Challenge8.Models.Location;
import com.challenge8.Challenge8.Models.MeteorologicalData;
import com.challenge8.Challenge8.Services.LocationService;
import com.challenge8.Challenge8.Services.MeteorologicalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("home")
@Controller
public class MDataController {

	@Autowired
	private MeteorologicalDataService meteorologicalDataService;

	@Autowired
	private LocationService locationService;

	@GetMapping({"/","","/home"})
	public String home(Model model){
		List<Location> locationList = locationService.list();
		List<MeteorologicalData> meteorologicalDataList = meteorologicalDataService.list();
 		model.addAttribute("location", new Location());
		model.addAttribute("meteorologicalData", new MeteorologicalData());
		model.addAttribute("locationList",locationList);
		model.addAttribute("meteorologicalDataList",meteorologicalDataList);
		model.addAttribute("lastLocationId",locationList.size());
		return "home";
	}


	@PostMapping(path = "/add")
	private String add(MeteorologicalData meteorologicData){
		meteorologicalDataService.create(meteorologicData);
		return "redirect:/home";
	}

	@PostMapping(path = "/remove")
	private String delete(MeteorologicalData meteorologicalData){
		meteorologicalDataService.delete(Math.toIntExact(meteorologicalData.getId()));
		return "redirect:/home";
	}

	@PostMapping(path = "/updateV")
	private String updateView(Location locationUpdated, Model model){
		if(!locationService.list().isEmpty()){
			List<Location> locationList = locationService.list();
			List<MeteorologicalData> meteorologicalDataList = meteorologicalDataService.list();
			model.addAttribute("location", new Location());
			model.addAttribute("meteorologicalData", new MeteorologicalData());
			model.addAttribute("locationList",locationList);
			model.addAttribute("meteorologicalDataList",meteorologicalDataList);
			model.addAttribute("lastLocationId",locationList.size());
			return "/update";
		}else {
			//message is printed because we can not modify an empty list
			System.out.println("the location list can not be modified, add locations first");
			return "/home";
		}
	}
	@PostMapping(path ="/update")
	public String update(Location location, Model model){
		List<Location> locationList = locationService.list();
		List<MeteorologicalData> meteorologicalDataList = meteorologicalDataService.list();
		model.addAttribute("location", new Location());
		model.addAttribute("meteorologicalData", new MeteorologicalData());
		model.addAttribute("locationList",locationList);
		model.addAttribute("meteorologicalDataList",meteorologicalDataList);
		model.addAttribute("lastLocationId",locationList.size());
		locationService.create(location);

		return "/home";
	}

	@PostMapping(path = "/updateMV")
	private String updateLView(MeteorologicalData meteorologicalData, Model model){
		if(meteorologicalDataService.list().size()>0){
			List<Location> locationList = locationService.list();
			List<MeteorologicalData> meteorologicalDataList = meteorologicalDataService.list();
			model.addAttribute("location", new Location());
			model.addAttribute("meteorologicalData", new MeteorologicalData());
			model.addAttribute("locationList",locationList);
			model.addAttribute("meteorologicalDataList",meteorologicalDataList);
			model.addAttribute("lastLocationId",locationList.size());
			return "/updateM";
		}else {
			//message is printed because we can not modify an empty list
			System.out.println("the data list can not be modified, add data first");
			return "/home";
		}
	}
	@PostMapping(path ="/updateM")
	public String updateM(MeteorologicalData meteorologicalData, Model model){
		List<Location> locationList = locationService.list();
		List<MeteorologicalData> meteorologicalDataList = meteorologicalDataService.list();
		model.addAttribute("location", new Location());
		model.addAttribute("meteorologicalData", new MeteorologicalData());
		model.addAttribute("locationList",locationList);
		model.addAttribute("meteorologicalDataList",meteorologicalDataList);
		model.addAttribute("lastLocationId",locationList.size());
		meteorologicalDataService.create(meteorologicalData);

		return "redirect:/home";
	}

	@PostMapping(path = "/removeM")
	private String deleteM(Long id){
		if(meteorologicalDataService.list().size()==0){
			System.out.println("there is not data to remove");
		} else{
			meteorologicalDataService.delete(Math.toIntExact(id));
		}
		return "redirect:/home";
	}

}
