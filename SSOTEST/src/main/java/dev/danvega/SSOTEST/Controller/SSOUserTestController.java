package dev.danvega.SSOTEST.Controller;

import dev.danvega.SSOTEST.Entity.SSOUserTestEntity;
import dev.danvega.SSOTEST.Service.SSOUserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class SSOUserTestController {

    private final SSOUserTestService ssoUserTestService;

    @Autowired
    public SSOUserTestController(SSOUserTestService ssoUserTestService) {
        this.ssoUserTestService = ssoUserTestService;
    }

    @PostMapping
    public ResponseEntity<SSOUserTestEntity> saveUser(@RequestBody SSOUserTestEntity user) {
        SSOUserTestEntity savedUser = ssoUserTestService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

}
