package com.example.teendo.service;

import com.example.teendo.model.Teendo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TeendoServiceTest {

    private com.example.teendo.service.TeendoService service;

    @BeforeEach
    void setUp() {
        service = new com.example.teendo.service.TeendoService();
    }

    @Test
    void hozzaad_shouldAddNewTeendoWithGeneratedId() {
        Teendo teendo = new Teendo(null, "Teszt cím", "Teszt leírás", false);
        Teendo result = service.hozzaad(teendo);

        assertNotNull(result.getId());
        assertEquals("Teszt cím", result.getCim());
        assertEquals("Teszt leírás", result.getLeiras());
        assertFalse(result.isElvegzett());
    }

    @Test
    void listaz_shouldReturnAllAddedTeendok() {
        service.hozzaad(new Teendo(null, "1", "Leírás1", false));
        service.hozzaad(new Teendo(null, "2", "Leírás2", true));

        List<Teendo> lista = service.listaz();
        assertEquals(2, lista.size());
    }

    @Test
    void torol_shouldDeleteExistingTeendo() {
        Teendo teendo = service.hozzaad(new Teendo(null, "Törlendő", "Leírás", false));
        boolean siker = service.torol(teendo.getId());

        assertTrue(siker);
        assertEquals(0, service.listaz().size());
    }

    @Test
    void torol_shouldReturnFalseIfNotFound() {
        boolean siker = service.torol(999L);
        assertFalse(siker);
    }

    @Test
    void keresIdSzerint_shouldFindById() {
        Teendo teendo = service.hozzaad(new Teendo(null, "Keresett", "Leírás", false));
        Optional<Teendo> megtalalt = service.keresIdSzerint(teendo.getId());

        assertTrue(megtalalt.isPresent());
        assertEquals("Keresett", megtalalt.get().getCim());
    }

    @Test
    void keresIdSzerint_shouldReturnEmptyIfNotFound() {
        Optional<Teendo> nincs = service.keresIdSzerint(123L);
        assertTrue(nincs.isEmpty());
    }
}