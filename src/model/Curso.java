package model;

public class Curso {
    private int codCurso;
    private String nomeCurso;
    private String periodo;
    private String campus;

    public Curso() {}

    public Curso(int codCurso, String nomeCurso, String periodo, String campus) {
        this.codCurso = codCurso;
        this.nomeCurso = nomeCurso;
        this.periodo = periodo;
        this.campus = campus;
    }

    public int getCodCurso() { 
    	return codCurso; }
    
    public void setCodCurso(int codCurso) { 
    	this.codCurso = codCurso; }

    public String getNomeCurso() { 
    	return nomeCurso; }
    
    public void setNomeCurso(String nomeCurso) { 
    	this.nomeCurso = nomeCurso; }

    public String getPeriodo() { 
    	return periodo; }
    
    public void setPeriodo(String periodo) { 
    	this.periodo = periodo; }

    public String getCampus() { 
    	return campus; }
    
    public void setCampus(String campus) { 
    	this.campus = campus; }

    @Override
    public String toString() {
        return this.nomeCurso;
    }
}