package model.entities;

import java.io.Serializable;
import java.util.Random;

import model.services.Matricula;

public class Atendente implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomeCompleto;
	private String matricula;
	private String email;
	private String telefone;
	private String gerenteResponsavel;

	Random random = new Random();

	public Atendente() {
	}

	public Atendente(String nomeCompleto, String matricula, String email, String telefone, String gerenteResponsavel) {
		this.nomeCompleto = nomeCompleto;
		this.matricula = matricula;
		this.email = email;
		this.telefone = telefone;
		this.gerenteResponsavel = gerenteResponsavel;
	}

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

	public String getGerente_responsavel() {
		return gerenteResponsavel;
	}

	public void setGerente_responsavel(String gerenteResponsavel) {
		this.gerenteResponsavel = gerenteResponsavel;
	}

	public String gerarMatriculaAtendente() {

		String inicioMatriculaAtendente = "A" + Matricula.gerarParteInicialMatricula();

		if (Matricula.mesParaMatricula().length() > 1) {

			for (int i = 0; i < 4; i++) {

				Integer matricula = random.nextInt(9);
				inicioMatriculaAtendente = inicioMatriculaAtendente + matricula;
			}
		} else {
			
			for (int i = 0; i < 5; i++) {

				Integer matricula = random.nextInt(9);
				inicioMatriculaAtendente = inicioMatriculaAtendente + matricula;
			}
		}

		String concatenar = inicioMatriculaAtendente;

		setMatricula(concatenar);
		return concatenar;

	}

}
