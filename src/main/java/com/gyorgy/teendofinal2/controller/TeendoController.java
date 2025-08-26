package com.gyorgy.teendofinal2.controller;

import com.gyorgy.teendofinal2.model.Teendo;
import com.gyorgy.teendofinal2.service.TeendoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teendok")
@CrossOrigin(origins = "*")
public class TeendoController {

    private final TeendoService teendoService;

    public TeendoController(TeendoService teendoService) {
        this.teendoService = teendoService;
    }

    @GetMapping
    public List<Teendo> osszes() {
        return teendoService.listaz();
    }

    @PostMapping
    public Teendo letrehoz(@RequestBody Teendo teendo) {
        return teendoService.hozzaad(teendo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> torol(@PathVariable Long id) {
        boolean sikeres = teendoService.torol(id);
        return sikeres ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}