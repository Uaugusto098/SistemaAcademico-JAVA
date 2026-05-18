package model;

public class Desempenho extends Aluno {

    private double nota;
    private int faltas;
    private int codDisciplina;
    private String semestre;

    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }

    public int getFaltas() { return faltas; }
    public void setFaltas(int faltas) { this.faltas = faltas; }

    public int getCodDisciplina() { return codDisciplina; } // ✅ INT
    public void setCodDisciplina(int codDisciplina) { this.codDisciplina = codDisciplina; }

    public String getSemestre() { return semestre; }
    public void setSemestre(String semestre) { this.semestre = semestre; }
}