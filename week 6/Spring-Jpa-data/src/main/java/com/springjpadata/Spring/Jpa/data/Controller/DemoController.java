package com.springjpadata.Spring.Jpa.data.Controller;


import com.springjpadata.Spring.Jpa.data.model.User;
import com.springjpadata.Spring.Jpa.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class DemoController {
    @Autowired
    private UserRepository repo;

    @GetMapping("/save")
    public String save(@RequestParam(name = "name",required = false,defaultValue = "there is not info sended")String name, Model model){

        User p = new User(repo.count()+1,name, name);
        repo.save(p);
        return "info.com";
        //this logic to save person in the database should be a service in a new package, that's the correct way to do it
    }
    @DeleteMapping("/delete_last")
    public void delete_last(Model model){

        repo.deleteById(repo.count());
    }
    @DeleteMapping("/print")
    public ResponseEntity<List<User>> print(Model model){
        //type for the other method ResponseEntity<List<Person>>
        return new ResponseEntity<List<User>>(repo.findAll(), HttpStatus.OK);
        //model.addAttribute("people", repo.findAll());
        //return "greeting.html";//looks for the page with this name
    }


}
