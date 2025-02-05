package Controller;

import dev.danvega.SSOTEST.entity.SSOUserTest;
import dev.danvega.SSOTEST.service.SSOUserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apitest")
public class SSOUserTestController {

    @Autowired
    private SSOUserTestService service;

    @PostMapping("/gentoken")
    public ResponseEntity<?> createSSOUserTest(@RequestBody SSOUserTest ssoUserTest) {
        try {
            SSOUserTest saved = service.saveSSOUserTest(ssoUserTest);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving data");
        }
    }
}
