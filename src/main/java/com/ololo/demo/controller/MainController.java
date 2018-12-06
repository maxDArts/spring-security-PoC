package com.ololo.demo.controller;

import com.ololo.demo.common.ReadAccess;
import com.ololo.demo.common.WriteAccess;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @ReadAccess
    @GetMapping("/{network}/{organization}/read")
    public ResponseEntity<String> getResource(@PathVariable("network") String network, @PathVariable("organization") String organization) {
        return ResponseEntity.ok("YEEEEAHH!");
    }

    @WriteAccess
    @GetMapping("/{network}/{organization}/write")
    public ResponseEntity<String> write(@PathVariable("network") String network, @PathVariable("organization") String organization) {
        return ResponseEntity.ok("It's not for you!");
    }
}
