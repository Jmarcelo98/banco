package model.entities;

import java.io.Serializable;

public class ContaEspecial implements Serializable {

	private static final long serialVersionUID = 1L;

	private double auxiliar = getSalarioTitular();

	final double limiteAcimaDeQuatroMil = 1800;
	final double jurosDeQuatroMil = (auxiliar * 0.20) + auxiliar; // 20% ao mês

	final double limiteAcimaDeSeteMil = 2400;
	final double jurosDeSeteMil = (auxiliar * 0.18) + auxiliar; // 18% ao mês

	final double limiteAcimaDeDezMil = 3000;
	final double jurosDeDezMil = (auxiliar * 0.15) + auxiliar; // 15% ao mês

	final double limiteAcimaDeQuinze = 4500;
	final double jurosDeQuinze = (auxiliar * 0.12) + auxiliar; // 12% ao mês

	private String nomeTitular;
	private String cpfTitular;
	private String rgTitular;
	private double salarioTitular;
	private double limiteCreditoTitular;
	private String enderecoTitular;
	private String numeroTitular;
	private String completoTitular;
	private String cidadeTitular;
	private String ufTitular;

	public ContaEspecial() {

	}

	public ContaEspecial(String nomeTitular, String cpfTitular, String rgTitular, double salarioTitular,
			double limiteCreditoTitular, String enderecoTitular, String numeroTitular, String completoTitular,
			String cidadeTitular, String ufTitular) {
		super();
		this.nomeTitular = nomeTitular;
		this.cpfTitular = cpfTitular;
		this.rgTitular = rgTitular;
		this.salarioTitular = salarioTitular;
		this.limiteCreditoTitular = limiteCreditoTitular;
		this.enderecoTitular = enderecoTitular;
		this.numeroTitular = numeroTitular;
		this.completoTitular = completoTitular;
		this.cidadeTitular = cidadeTitular;
		this.ufTitular = ufTitular;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getCpfTitular() {
		return cpfTitular;
	}

	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}

	public String getRgTitular() {
		return rgTitular;
	}

	public void setRgTitular(String rgTitular) {
		this.rgTitular = rgTitular;
	}

	public double getSalarioTitular() {
		return salarioTitular;
	}

	public void setSalarioTitular(double salarioTitular) {
		this.salarioTitular = salarioTitular;
	}

	public double getLimiteCreditoTitular() {
		return limiteCreditoTitular;
	}

	public String getEnderecoTitular() {
		return enderecoTitular;
	}

	public void setEnderecoTitular(String enderecoTitular) {
		this.enderecoTitular = enderecoTitular;
	}

	public String getNumeroTitular() {
		return numeroTitular;
	}

	public void setNumeroTitular(String numeroTitular) {
		this.numeroTitular = numeroTitular;
	}

	public String getCompletoTitular() {
		return completoTitular;
	}

	public void setCompletoTitular(String completoTitular) {
		this.completoTitular = completoTitular;
	}

	public String getCidadeTitular() {
		return cidadeTitular;
	}

	public void setCidadeTitular(String cidadeTitular) {
		this.cidadeTitular = cidadeTitular;
	}

	public String getUfTitular() {
		return ufTitular;
	}

	public void setUfTitular(String ufTitular) {
		this.ufTitular = ufTitular;
	}

}
