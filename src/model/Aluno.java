package model;

import java.util.Date;

public class Aluno {
	private String nome;
	private String ra;
	private String cpf;
	private Date dataNasc;
	private String email;
	private String municipio;
	private String uf;
	private String codCurso;
	
	public Aluno() {
		
	}
	
	public Aluno(String nome, String ra, String cpf, Date dataNasc, String email, String municipio, String uf,
			String codCurso) {
		super();
		this.nome = nome;
		this.ra = ra;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.email = email;
		this.municipio = municipio;
		this.uf = uf;
		this.codCurso = codCurso;
	}
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}
}
