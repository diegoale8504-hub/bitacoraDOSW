package edu.dosw.corte2.semana1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnalyticsServiceTest {

    private AnalyticsService service;
    private List<Student> students;

    @BeforeEach
    void setUp() {
        service = new AnalyticsService();

        students = List.of(
                new Student("1", "Ana", "AZUL", List.of(
                        new Grade("DOSW", 4.8, LocalDate.of(2026, 3, 1), true),
                        new Grade("BD", 4.2, LocalDate.of(2026, 3, 2), true),
                        new Grade("REDES", 2.9, LocalDate.of(2026, 3, 3), false)
                )),
                new Student("2", "Bruno", "DORADO", List.of(
                        new Grade("DOSW", 3.2, LocalDate.of(2026, 3, 1), false),
                        new Grade("BD", 3.6, LocalDate.of(2026, 3, 2), true),
                        new Grade("REDES", 3.4, LocalDate.of(2026, 3, 3), false)
                ))
                // ... Carla y Diego
        );
    }

    @Test
    void ejercicio1_obtenerAzul() {
        assertEquals(1, service.getBlueTeamStudents(students).size());
    }
}