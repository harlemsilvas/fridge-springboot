package dev.java10x.Fridge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/api/teste")
    public Map<String, String> teste() {
        return Map.of("status", "ok", "msg", "Spring conectado!");
    }
}
