package com.bank.customerprofile.controllers;

import com.bank.customerprofile.models.DTOs.userrequest.createuserrequest;

import com.bank.customerprofile.service_impl.UserService;
import com.bank.customerprofile.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {


    private final IUserService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody createuserrequest data){
        service.createuser(data);
        return ResponseEntity.ok("User Created Successfully!");
    }
}
