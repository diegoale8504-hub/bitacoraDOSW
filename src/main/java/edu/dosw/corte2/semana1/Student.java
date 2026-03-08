package edu.dosw.corte2.semana1;
import java.util.List;
public class Student {

    private String id;
    private String name;
    private String team;   // "DORADO", "AZUL", "VERDE"
    private List<Grade> grades;

    public Student(String id, String name, String team, List<Grade> grades) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.grades = grades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", grades=" + grades +
                '}';
    }
}
