package com.example.Thesis.Controllers;

import com.example.Thesis.Dtos.RegistrationRequest;
import com.example.Thesis.Services.RegistrationService;
import com.example.Thesis.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/registration")
@AllArgsConstructor
public class RegistrationController {

    private final UserService userService;
    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @PostMapping(path = "/admin")
    public void registerAdmins() {
        userService.createAdminprofiles();
    }

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
