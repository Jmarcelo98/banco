package model.entities;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

	private String nomeCompleto;
	private String CPF;
	private String email;
	private String telefone;
	private Date dataNascimento;
	
	public Cliente() {
		 
	}
	
	public Cliente(String nomeCompleto, String cPF, String email, String telefone, Date dataNascimento) {
		this.nomeCompleto = nomeCompleto;
		CPF = cPF;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
	}

	public String getNome_completo() {
		return nomeCompleto;
	}

	public void setNome_completo(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
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

	public Date getData_Nascimento() {
		return dataNascimento;
	}

	public void setData_Nascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
