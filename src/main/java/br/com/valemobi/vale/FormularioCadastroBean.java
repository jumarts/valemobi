package br.com.valemobi.vale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="formularioCadastroBean")
@RequestScoped
public class FormularioCadastroBean {
   //Campos dos meus Formularios 
	
	private String campoTipo;
	private String campoNome;
	private int campoQuantidade;
	private double campoPreco;
	private String tipoNegocio;
	
	public FormularioCadastroBean(){
		 
	}
	
	private int campoCodigoMercadoria;
	public int getCampoCodigoMercadoria() {
		return campoCodigoMercadoria;
	}
	public void setCampoCodigoMercadoria(int campoCodigoMercadoria) {
		this.campoCodigoMercadoria = campoCodigoMercadoria;
	}
	public String getCampoTipo() {
		return campoTipo;
	}
	public void setCampoTipo(String campoTipo) {
		this.campoTipo = campoTipo;
	}
	public String getCampoNome() {
		return campoNome;
	}
	public void setCampoNome(String campoNome) {
		this.campoNome = campoNome;
	}
	public int getCampoQuantidade() {
		return campoQuantidade;
	}
	public void setCampoQuantidade(int campoQuantidade) {
		this.campoQuantidade = campoQuantidade;
	}
	public double getCampoPreco() {
		return campoPreco;
	}
	public void setCampoPreco(double campoPreco) {
		this.campoPreco = campoPreco;
	}
	public String getTipoNegocio() {
		return tipoNegocio;
	}
	public void setTipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}
	
	
    
}
