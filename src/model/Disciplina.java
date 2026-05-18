package model;

public class Disciplina {
    private int codDisciplina;
    private String nomeDisciplina;

    public Disciplina() {}

    public Disciplina(int codDisciplina, String nomeDisciplina) {
        this.codDisciplina = codDisciplina;
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getCodDisciplina() { return codDisciplina; }
    
    public void setCodDisciplina(int codDisciplina) {
    	this.codDisciplina = codDisciplina;
    }

    public String getNomeDisciplina() { return nomeDisciplina; }
    public void setNomeDisciplina(String nomeDisciplina) { this.nomeDisciplina = nomeDisciplina; }

    @Override
    public String toString() {
        // toString é usado pelo JComboBox para exibir o texto
        return nomeDisciplina;
    }
}