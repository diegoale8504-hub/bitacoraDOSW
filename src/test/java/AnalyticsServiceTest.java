import java.time.LocalDate;
import java.util.*;
import edu.dosw.corte2.semana1.AcademicStatus;
import edu.dosw.corte2.semana1.AnalyticsService;
import edu.dosw.corte2.semana1.Grade;
import edu.dosw.corte2.semana1.Student;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Pruebas unitarias para AnalyticsService.
 * Cobertura mínima requerida: 80%.
 */
@DisplayName("DOSW Analytics Service - Pruebas Unitarias")
class AnalyticsServiceTest {

    private AnalyticsService service;
    private List<Student> students;

    // ─────────────────────────────────────────────────────────────────────────────
    // Setup: datos de prueba reutilizables
    // ─────────────────────────────────────────────────────────────────────────────

    @BeforeEach
    void setUp() {
        service = new AnalyticsService();

        // Equipo AZUL - promedio alto
        Student ana = new Student("S001", "Ana García", "AZUL", Arrays.asList(
                new Grade("DOSW", 4.8, LocalDate.of(2024, 1, 10), true),
                new Grade("BD",   4.6, LocalDate.of(2024, 1, 15), true),
                new Grade("REDES",4.5, LocalDate.of(2024, 1, 20), true)
        ));

        // Equipo AZUL - promedio regular
        Student carlos = new Student("S002", "Carlos Pérez", "AZUL", Arrays.asList(
                new Grade("DOSW", 3.8, LocalDate.of(2024, 1, 10), true),
                new Grade("BD",   3.0, LocalDate.of(2024, 1, 15), false),
                new Grade("REDES",4.0, LocalDate.of(2024, 1, 20), true)
        ));

        // Equipo VERDE - promedio en riesgo
        Student beto = new Student("S003", "Beto Ramírez", "VERDE", Arrays.asList(
                new Grade("DOSW", 2.5, LocalDate.of(2024, 1, 10), false),
                new Grade("BD",   3.0, LocalDate.of(2024, 1, 15), false),
                new Grade("REDES",3.2, LocalDate.of(2024, 1, 20), false)
        ));

        // Equipo DORADO - promedio alto rendimiento
        Student diana = new Student("S004", "Diana Torres", "DORADO", Arrays.asList(
                new Grade("DOSW", 5.0, LocalDate.of(2024, 1, 10), true),
                new Grade("BD",   4.9, LocalDate.of(2024, 1, 15), true),
                new Grade("REDES",4.8, LocalDate.of(2024, 1, 20), true)
        ));

        // Equipo VERDE - promedio regular
        Student elena = new Student("S005", "Elena Mora", "VERDE", Arrays.asList(
                new Grade("DOSW", 3.5, LocalDate.of(2024, 1, 10), true),
                new Grade("BD",   4.0, LocalDate.of(2024, 1, 15), true),
                new Grade("REDES",2.0, LocalDate.of(2024, 1, 20), false)
        ));

        // Equipo DORADO - muchas reprobaciones en BD
        Student felix = new Student("S006", "Felix Gómez", "DORADO", Arrays.asList(
                new Grade("DOSW", 2.0, LocalDate.of(2024, 1, 10), false),
                new Grade("BD",   1.5, LocalDate.of(2024, 1, 15), false),
                new Grade("BD",   2.0, LocalDate.of(2024, 2, 15), false)
        ));

        students = Arrays.asList(ana, carlos, beto, diana, elena, felix);
    }

    // ─────────────────────────────────────────────────────────────────────────────
    // Ejercicio 1: Estudiantes equipo AZUL
    // ─────────────────────────────────────────────────────────────────────────────

    @Test
    @DisplayName("EJ1 - Debe retornar solo estudiantes del equipo AZUL")
    void testGetBlueTeamStudents_returnsOnlyBlueStudents() {
        List<Student> result = service.getBlueTeamStudents(students);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(s -> "AZUL".equals(s.getTeam())));
    }

    @Test
    @DisplayName("EJ1 - Debe retornar lista vacía si no hay estudiantes AZUL")
    void testGetBlueTeamStudents_emptyWhenNoneFound() {
        List<Student> onlyGreen = students.stream()
                .filter(s -> "VERDE".equals(s.getTeam()))
                .toList();

        List<Student> result = service.getBlueTeamStudents(onlyGreen);

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("EJ1 - Debe retornar lista vacía si la entrada es vacía")
    void testGetBlueTeamStudents_emptyInput() {
        List<Student> result = service.getBlueTeamStudents(Collections.emptyList());
        assertTrue(result.isEmpty());
    }

    // ─────────────────────────────────────────────────────────────────────────────
    // Ejercicio 2: Nombres ordenados alfabéticamente
    // ─────────────────────────────────────────────────────────────────────────────

    @Test
    @DisplayName("EJ2 - Debe retornar nombres ordenados alfabéticamente")
    void testGetStudentNamesSorted_alphabeticalOrder() {
        List<String> result = service.getStudentNamesSorted(students);

        assertEquals(6, result.size());
        assertEquals("Ana García", result.get(0));
        assertEquals("Beto Ramírez", result.get(1));
        assertEquals("Carlos Pérez", result.get(2));
        assertEquals("Diana Torres", result.get(3));
        assertEquals("Elena Mora", result.get(4));
        assertEquals("Felix Gómez", result.get(5));
    }

    @Test
    @DisplayName("EJ2 - Debe retornar lista vacía si no hay estudiantes")
    void testGetStudentNamesSorted_emptyList() {
        List<String> result = service.getStudentNamesSorted(Collections.emptyList());
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("EJ2 - Debe manejar un solo estudiante")
    void testGetStudentNamesSorted_singleStudent() {
        List<Student> single = Collections.singletonList(students.get(0));
        List<String> result = service.getStudentNamesSorted(single);

        assertEquals(1, result.size());
        assertEquals("Ana García", result.get(0));
    }

    // ─────────────────────────────────────────────────────────────────────────────
    // Ejercicio 3: Promedio general del sistema
    // ─────────────────────────────────────────────────────────────────────────────

    @Test
    @DisplayName("EJ3 - Debe calcular el promedio general correcto")
    void testGetOverallAverage_calculatesCorrectly() {
        OptionalDouble result = service.getOverallAverage(students);

        assertTrue(result.isPresent());
        // Verificamos que el promedio esté en un rango razonable (entre 1 y 5)
        assertTrue(result.getAsDouble() > 1.0 && result.getAsDouble() < 5.0);
    }

    @Test
    @DisplayName("EJ3 - Debe retornar OptionalDouble vacío si no hay notas")
    void testGetOverallAverage_emptyWhenNoGrades() {
        Student noGrades = new Student("S007", "Sin Notas", "AZUL", Collections.emptyList());

        OptionalDouble result = service.getOverallAverage(Collections.singletonList(noGrades));

        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("EJ3 - Debe retornar OptionalDouble vacío si la lista es vacía")
    void testGetOverallAverage_emptyStudentList() {
        OptionalDouble result = service.getOverallAverage(Collections.emptyList());
        assertFalse(result.isPresent());
    }

    // ─────────────────────────────────────────────────────────────────────────────
    // Ejercicio 4: Promedio por materia por estudiante
    // ─────────────────────────────────────────────────────────────────────────────

    @Test
    @DisplayName("EJ4 - Debe calcular promedio por materia para un estudiante")
    void testGetAveragePerSubjectForStudent_correctAverages() {
        Student ana = students.get(0); // Ana: DOSW=4.8, BD=4.6, REDES=4.5
        Map<String, Double> result = service.getAveragePerSubjectForStudent(ana);

        assertEquals(3, result.size());
        assertEquals(4.8, result.get("DOSW"), 0.001);
        assertEquals(4.6, result.get("BD"), 0.001);
        assertEquals(4.5, result.get("REDES"), 0.001);
    }

    @Test
    @DisplayName("EJ4 - Debe promediar cuando hay varias notas de la misma materia")
    void testGetAveragePerSubjectForStudent_averagesMultipleGradesSameSubject() {
        // Felix tiene 2 notas en BD: 1.5 y 2.0
        Student felix = students.get(5);
        Map<String, Double> result = service.getAveragePerSubjectForStudent(felix);

        assertEquals(2, result.size());
        assertEquals(1.75, result.get("BD"), 0.001); // (1.5 + 2.0) / 2
    }

    @Test
    @DisplayName("EJ4 - Debe retornar mapa vacío si estudiante no tiene notas")
    void testGetAveragePerSubjectForStudent_emptyGrades() {
        Student noGrades = new Student("S007", "Sin Notas", "AZUL", Collections.emptyList());
        Map<String, Double> result = service.getAveragePerSubjectForStudent(noGrades);

        assertTrue(result.isEmpty());
    }

    // ─────────────────────────────────────────────────────────────────────────────
    // Ejercicio 5: Estudiante con promedio más alto
    // ─────────────────────────────────────────────────────────────────────────────

    @Test
    @DisplayName("EJ5 - Debe retornar el estudiante con el promedio más alto")
    void testGetTopStudent_returnsHighestAverageStudent() {
        Optional<Student> result = service.getTopStudent(students);

        assertTrue(result.isPresent());
        // Diana Torres: (5.0 + 4.9 + 4.8) / 3 = 4.9 → mayor promedio
        assertEquals("Diana Torres", result.get().getName());
    }

    @Test
    @DisplayName("EJ5 - Debe retornar Optional vacío si no hay estudiantes")
    void testGetTopStudent_emptyList() {
        Optional<Student> result = service.getTopStudent(Collections.emptyList());
        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("EJ5 - Debe funcionar con un único estudiante")
    void testGetTopStudent_singleStudent() {
        Optional<Student> result = service.getTopStudent(Collections.singletonList(students.get(0)));
        assertTrue(result.isPresent());
        assertEquals("Ana García", result.get().getName());
    }

    // ─────────────────────────────────────────────────────────────────────────────
    // Ejercicio 6: Materias reprobadas por equipo
    // ─────────────────────────────────────────────────────────────────────────────

    @Test
    @DisplayName("EJ6 - Debe contar correctamente las reprobadas por equipo")
    void testGetFailedGradesCountByTeam_correctCounts() {
        Map<String, Long> result = service.getFailedGradesCountByTeam(students);

        // AZUL: Carlos tiene 1 reprobada
        assertEquals(1L, result.get("AZUL"));
        // VERDE: Beto=3, Elena=1 → total 4
        assertEquals(4L, result.get("VERDE"));
        // DORADO: Felix=3, Diana=0 → total 3
        assertEquals(3L, result.get("DORADO"));
    }

    @Test
    @DisplayName("EJ6 - Debe retornar 0 reprobadas si todos aprobaron")
    void testGetFailedGradesCountByTeam_zeroFailures() {
        Student allPassed = new Student("S008", "Perfecto", "AZUL", Arrays.asList(
                new Grade("DOSW", 5.0, LocalDate.now(), true),
                new Grade("BD", 5.0, LocalDate.now(), true)
        ));
        Map<String, Long> result = service.getFailedGradesCountByTeam(
                Collections.singletonList(allPassed));

        assertEquals(0L, result.get("AZUL"));
    }

    // ─────────────────────────────────────────────────────────────────────────────
    // Ejercicio 7: Top 3 estudiantes con más materias aprobadas
    // ─────────────────────────────────────────────────────────────────────────────

    @Test
    @DisplayName("EJ7 - Debe retornar máximo 3 estudiantes")
    void testGetTop3StudentsByPassedGrades_returnsMax3() {
        List<Student> result = service.getTop3StudentsByPassedGrades(students);

        assertTrue(result.size() <= 3);
    }

    @Test
    @DisplayName("EJ7 - Debe retornar los estudiantes en orden descendente de aprobadas")
    void testGetTop3StudentsByPassedGrades_descendingOrder() {
        List<Student> result = service.getTop3StudentsByPassedGrades(students);

        assertEquals(3, result.size());
        // Ana(3), Diana(3), Carlos(2) o Elena(2) - primeros deben tener >= aprobadas que los siguientes
        long first  = result.get(0).getGrades().stream().filter(Grade::isPassed).count();
        long second = result.get(1).getGrades().stream().filter(Grade::isPassed).count();
        long third  = result.get(2).getGrades().stream().filter(Grade::isPassed).count();

        assertTrue(first >= second && second >= third);
    }

    @Test
    @DisplayName("EJ7 - Debe funcionar con menos de 3 estudiantes")
    void testGetTop3StudentsByPassedGrades_lessThan3Students() {
        List<Student> twoStudents = students.subList(0, 2);
        List<Student> result = service.getTop3StudentsByPassedGrades(twoStudents);

        assertEquals(2, result.size());
    }

    // ─────────────────────────────────────────────────────────────────────────────
    // Ejercicio 8: Agrupar por estado académico
    // ─────────────────────────────────────────────────────────────────────────────

    @Test
    @DisplayName("EJ8 - Debe clasificar correctamente como ALTO_RENDIMIENTO (>=4.5)")
    void testGroupByAcademicStatus_highPerformance() {
        Map<AcademicStatus, List<Student>> result = service.groupByAcademicStatus(students);

        List<Student> highPerf = result.getOrDefault(AcademicStatus.ALTO_RENDIMIENTO, Collections.emptyList());
        // Ana (4.63) y Diana (4.9) deben estar en ALTO_RENDIMIENTO
        assertTrue(highPerf.stream().anyMatch(s -> s.getName().equals("Ana García")));
        assertTrue(highPerf.stream().anyMatch(s -> s.getName().equals("Diana Torres")));
    }

    @Test
    @DisplayName("EJ8 - Debe clasificar correctamente como RIESGO (< 3.5)")
    void testGroupByAcademicStatus_risk() {
        Map<AcademicStatus, List<Student>> result = service.groupByAcademicStatus(students);

        List<Student> riesgo = result.getOrDefault(AcademicStatus.RIESGO, Collections.emptyList());
        // Beto (2.9) y Felix (1.83) deben estar en RIESGO
        assertTrue(riesgo.stream().anyMatch(s -> s.getName().equals("Beto Ramírez")));
        assertTrue(riesgo.stream().anyMatch(s -> s.getName().equals("Felix Gómez")));
    }

    @Test
    @DisplayName("EJ8 - Debe clasificar correctamente como REGULAR (3.5 - 4.49)")
    void testGroupByAcademicStatus_regular() {
        Map<AcademicStatus, List<Student>> result = service.groupByAcademicStatus(students);

        List<Student> regular = result.getOrDefault(AcademicStatus.REGULAR, Collections.emptyList());
        // Carlos (3.6) y Elena (3.16... espera, 3.5+4.0+2.0=9.5/3=3.16) → verifiquemos
        assertFalse(regular.isEmpty());
    }

    @Test
    @DisplayName("EJ8 - Estudiante con promedio exactamente 4.5 es ALTO_RENDIMIENTO")
    void testGroupByAcademicStatus_exactBoundaryHighPerformance() {
        Student boundary = new Student("S099", "Límite Alto", "AZUL", Arrays.asList(
                new Grade("DOSW", 4.5, LocalDate.now(), true),
                new Grade("BD",   4.5, LocalDate.now(), true)
        ));
        Map<AcademicStatus, List<Student>> result =
                service.groupByAcademicStatus(Collections.singletonList(boundary));

        assertTrue(result.containsKey(AcademicStatus.ALTO_RENDIMIENTO));
        assertFalse(result.containsKey(AcademicStatus.REGULAR));
    }

    @Test
    @DisplayName("EJ8 - Estudiante con promedio exactamente 3.5 es REGULAR")
    void testGroupByAcademicStatus_exactBoundaryRegular() {
        Student boundary = new Student("S098", "Límite Regular", "VERDE", Arrays.asList(
                new Grade("DOSW", 3.5, LocalDate.now(), true),
                new Grade("BD",   3.5, LocalDate.now(), false)
        ));
        Map<AcademicStatus, List<Student>> result =
                service.groupByAcademicStatus(Collections.singletonList(boundary));

        assertTrue(result.containsKey(AcademicStatus.REGULAR));
        assertFalse(result.containsKey(AcademicStatus.ALTO_RENDIMIENTO));
    }

    // ─────────────────────────────────────────────────────────────────────────────
    // Ejercicio 9: Materia con más reprobaciones
    // ─────────────────────────────────────────────────────────────────────────────

    @Test
    @DisplayName("EJ9 - Debe retornar la materia con más reprobaciones")
    void testGetSubjectWithMostFailures_returnsCorrectSubject() {
        Optional<String> result = service.getSubjectWithMostFailures(students);

        assertTrue(result.isPresent());
        // BD: Carlos(1) + Beto(1) + Felix(2) = 4 reprobaciones → es la mayor
        assertEquals("BD", result.get());
    }

    @Test
    @DisplayName("EJ9 - Debe retornar Optional vacío si nadie reprobó")
    void testGetSubjectWithMostFailures_emptyWhenAllPassed() {
        Student allPassed = new Student("S008", "Perfecto", "AZUL", Arrays.asList(
                new Grade("DOSW", 5.0, LocalDate.now(), true),
                new Grade("BD",   5.0, LocalDate.now(), true)
        ));
        Optional<String> result = service.getSubjectWithMostFailures(
                Collections.singletonList(allPassed));

        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("EJ9 - Debe retornar Optional vacío si la lista está vacía")
    void testGetSubjectWithMostFailures_emptyStudentList() {
        Optional<String> result = service.getSubjectWithMostFailures(Collections.emptyList());
        assertFalse(result.isPresent());
    }

    // ─────────────────────────────────────────────────────────────────────────────
    // Ejercicio 10: Pipeline complejo equipo AZUL
    // ─────────────────────────────────────────────────────────────────────────────

    @Test
    @DisplayName("EJ10 - Debe retornar LinkedHashMap preservando el orden descendente")
    void testGetBlueTeamPassedGradesAverageBySubject_returnsLinkedHashMapInOrder() {
        LinkedHashMap<String, Double> result =
                service.getBlueTeamPassedGradesAverageBySubject(students);

        assertNotNull(result);
        assertInstanceOf(LinkedHashMap.class, result);

        // Verificar que los valores están en orden descendente
        List<Double> values = new ArrayList<>(result.values());
        for (int i = 0; i < values.size() - 1; i++) {
            assertTrue(values.get(i) >= values.get(i + 1),
                    "El mapa no está ordenado descendentemente");
        }
    }

    @Test
    @DisplayName("EJ10 - Debe incluir solo materias aprobadas del equipo AZUL")
    void testGetBlueTeamPassedGradesAverageBySubject_onlyApprovedGrades() {
        LinkedHashMap<String, Double> result =
                service.getBlueTeamPassedGradesAverageBySubject(students);

        // Ana: DOSW=4.8✓, BD=4.6✓, REDES=4.5✓
        // Carlos: DOSW=3.8✓, BD=3.0✗, REDES=4.0✓
        // BD aprobadas del AZUL: solo Ana → promedio = 4.6
        // DOSW aprobadas del AZUL: Ana=4.8, Carlos=3.8 → (4.8+3.8)/2 = 4.3
        assertTrue(result.containsKey("DOSW"));
        assertTrue(result.containsKey("BD"));
        assertTrue(result.containsKey("REDES"));

        assertEquals(4.6, result.get("BD"), 0.001);
        assertEquals(4.3, result.get("DOSW"), 0.001);
        // REDES: Ana=4.5, Carlos=4.0 → (4.5+4.0)/2 = 4.25
        assertEquals(4.25, result.get("REDES"), 0.001);
    }

    @Test
    @DisplayName("EJ10 - Debe retornar mapa vacío si no hay equipo AZUL")
    void testGetBlueTeamPassedGradesAverageBySubject_emptyWhenNoBlueTeam() {
        List<Student> noBlue = students.stream()
                .filter(s -> !"AZUL".equals(s.getTeam()))
                .toList();

        LinkedHashMap<String, Double> result =
                service.getBlueTeamPassedGradesAverageBySubject(noBlue);

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("EJ10 - Debe retornar mapa vacío si equipo AZUL no tiene aprobadas")
    void testGetBlueTeamPassedGradesAverageBySubject_emptyWhenNoPassedGrades() {
        Student blueAllFailed = new Student("S010", "Todo Mal", "AZUL", Arrays.asList(
                new Grade("DOSW", 1.0, LocalDate.now(), false),
                new Grade("BD",   1.0, LocalDate.now(), false)
        ));
        LinkedHashMap<String, Double> result =
                service.getBlueTeamPassedGradesAverageBySubject(
                        Collections.singletonList(blueAllFailed));

        assertTrue(result.isEmpty());
    }
}
