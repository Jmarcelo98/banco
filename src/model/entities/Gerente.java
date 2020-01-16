package model.entities;

import java.io.Serializable;
import java.util.Random;

public class Gerente implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomeCompleto;
	private String matricula;
	private String email;
	private String telefone;
	private Integer setorResponsavel;
	
	Random random = new Random();

	public String getNome_completo() {
		return nomeCompleto;
	}

	public void setNome_completo(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getSetorResponsavel() {
		return setorResponsavel;
	}

	public void setSetorResponsavel(Integer setorResponsavel) {
		this.setorResponsavel = setorResponsavel;
	}

	public void gerarMatriculaGerente() {

		String inicioMatriculaGerente = "F";

		for (int i = 0; i < 7; i++) {

			Integer matricula = random.nextInt(9);
			inicioMatriculaGerente = inicioMatriculaGerente + matricula;
		}

		String concatenar = inicioMatriculaGerente;
		setMatricula(concatenar);
		
	}
	
}
