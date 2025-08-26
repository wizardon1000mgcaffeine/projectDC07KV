package com.example.teendo.service;

import com.example.teendo.model.Teendo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TeendoService {

    private final List<Teendo> teendok = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Teendo> listaz() {
        return new ArrayList<>(teendok);
    }

    public Teendo hozzaad(Teendo teendo) {
        teendo.setId(idGenerator.getAndIncrement());
        teendok.add(teendo);
        return teendo;
    }

    public boolean torol(Long id) {
        return teendok.removeIf(t -> t.getId().equals(id));
    }

    public Optional<Teendo> keresIdSzerint(Long id) {
        return teendok.stream().filter(t -> t.getId().equals(id)).findFirst();
    }
}