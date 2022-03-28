package DemoWeb.demoWeb.Controller;

import DemoWeb.demoWeb.Model.Person;
import DemoWeb.demoWeb.Repo.IPersonRepo;
import DemoWeb.demoWeb.Repository.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DemoController {
    @Autowired
    private IPersonRepo repo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name",required = false,defaultValue = "world")String name, Model model){

        Person p = new Person(name);
        //p.setIdPerson("1");
        repo.save(p);
        //this logic to save person in the database should be a service in a new package, that's the correct way to do it

        model.addAttribute("name", name);
        return "greeting.html";//looks for the page with this name
    }
    @GetMapping("/print")
    public ResponseEntity<List<Person>> greeting(Model model){
        //type for the other method ResponseEntity<List<Person>>
        return new ResponseEntity<List<Person>>(repo.findAll(), HttpStatus.OK);
        //model.addAttribute("people", repo.findAll());
        //return "greeting.html";//looks for the page with this name
    }


}
