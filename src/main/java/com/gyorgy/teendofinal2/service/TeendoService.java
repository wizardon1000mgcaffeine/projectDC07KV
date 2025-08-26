package com.gyorgy.teendofinal2.service;

import com.gyorgy.teendofinal2.model.Teendo;
import com.gyorgy.teendofinal2.repository.TeendoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeendoService {

    private final TeendoRepository teendoRepository;

    public TeendoService(TeendoRepository teendoRepository) {
        this.teendoRepository = teendoRepository;
    }

    public List<Teendo> listaz() {
        return teendoRepository.findAll();
    }

    public Teendo hozzaad(Teendo teendo) {
        return teendoRepository.save(teendo);
    }

    public boolean torol(Long id) {
        if (teendoRepository.existsById(id)) {
            teendoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Teendo> keresIdSzerint(Long id) {
        return teendoRepository.findById(id);
    }
}
