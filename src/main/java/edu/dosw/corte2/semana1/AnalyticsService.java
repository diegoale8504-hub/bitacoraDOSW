package edu.dosw.corte2.semana1;

import java.util.*;
import java.util.stream.Collectors;


public class AnalyticsService {

    // 1
    public List<Student> getBlueTeamStudents(List<Student> students) {
        return students.stream()
                .filter(student -> "AZUL".equals(student.getTeam()))
                .collect(Collectors.toList());
    }


    // 2
    public List<String> getStudentNamesSorted(List<Student> students) {
        return students.stream()
                .map(Student::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    // 3
    public OptionalDouble getOverallAverage(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getGrades().stream())
                .mapToDouble(Grade::getScore)
                .average();
    }

    //4
    public Map<String, Double> getAveragePerSubjectForStudent(Student student) {
        return student.getGrades().stream()
                .collect(Collectors.groupingBy(
                        Grade::getSubject,
                        Collectors.averagingDouble(Grade::getScore)
                ));
    }

    // 5
    public Optional<Student> getTopStudent(List<Student> students) {
        return students.stream()
                .max(Comparator.comparingDouble(this::calculateStudentAverage));
    }


    private double calculateStudentAverage(Student student) {
        return student.getGrades().stream()
                .mapToDouble(Grade::getScore)
                .average()
                .orElse(0.0);
    }

    // 6
    public Map<String, Long> getFailedGradesCountByTeam(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getTeam,
                        Collectors.summingLong(student ->
                                student.getGrades().stream()
                                        .filter(grade -> !grade.isPassed())
                                        .count()
                        )
                ));
    }

    //7
    public List<Student> getTop3StudentsByPassedGrades(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingLong(
                        (Student s) -> s.getGrades().stream()
                                .filter(Grade::isPassed)
                                .count()
                ).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }


    public Map<AcademicStatus, List<Student>> groupByAcademicStatus(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(student -> {
                    double avg = calculateStudentAverage(student);
                    if (avg >= 4.5) {
                        return AcademicStatus.ALTO_RENDIMIENTO;
                    } else if (avg >= 3.5) {
                        return AcademicStatus.REGULAR;
                    } else {
                        return AcademicStatus.RIESGO;
                    }
                }));
    }

    // ─────────────────────────────────────────────────────────────────────────────
    // Ejercicio 9: Obtener la materia con más reprobaciones
    // ─────────────────────────────────────────────────────────────────────────────

    /**
     * Encuentra la materia que acumula más reprobaciones (passed=false) en todo el sistema.
     *
     * @param students lista total de estudiantes
     * @return Optional con el nombre de la materia con más reprobaciones
     */
    public Optional<String> getSubjectWithMostFailures(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getGrades().stream())
                .filter(grade -> !grade.isPassed())
                .collect(Collectors.groupingBy(Grade::getSubject, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    // ─────────────────────────────────────────────────────────────────────────────
    // Ejercicio 10: Pipeline complejo sobre equipo AZUL
    // ─────────────────────────────────────────────────────────────────────────────

    /**
     * Pipeline funcional completo:
     * 1. Toma solo estudiantes del equipo AZUL
     * 2. Obtiene todas sus notas
     * 3. Filtra solo notas aprobadas (passed=true)
     * 4. Agrupa por materia
     * 5. Calcula promedio por materia
     * 6. Ordena descendente por promedio
     * 7. Retorna LinkedHashMap preservando el orden
     *
     * @param students lista total de estudiantes
     * @return LinkedHashMap con materia → promedio de notas aprobadas, ordenado descendente
     */
    public LinkedHashMap<String, Double> getBlueTeamPassedGradesAverageBySubject(List<Student> students) {
        return students.stream()
                .filter(student -> "AZUL".equals(student.getTeam()))
                .flatMap(student -> student.getGrades().stream())
                .filter(Grade::isPassed)
                .collect(Collectors.groupingBy(
                        Grade::getSubject,
                        Collectors.averagingDouble(Grade::getScore)
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
