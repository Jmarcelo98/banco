package model.entities;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

	private String nome_completo;
	private String CPF;
	private String email;
	private String telefone;
	private Date data_Nascimento;
	
	public Cliente() {
		 
	}
	
	public Cliente(String nome_completo, String cPF, String email, String telefone, Date data_Nascimento) {
		this.nome_completo = nome_completo;
		CPF = cPF;
		this.email = email;
		this.telefone = telefone;
		this.data_Nascimento = data_Nascimento;
	}

	public String getNome_completo() {
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
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
		return data_Nascimento;
	}

	public void setData_Nascimento(Date data_Nascimento) {
		this.data_Nascimento = data_Nascimento;
	}

}
