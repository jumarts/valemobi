package br.com.valemobi.vale;

import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.valemobi.vale.bd.ConexaoBdMobi;

@ManagedBean(name="CadastroConsulta")
public class FormulariosEpesquisasManagedBean {
	private FormularioCadastroBean formularioCadastroBean = new FormularioCadastroBean();
	
	public String cadastraCadastrar() throws Exception {
        
        ConexaoBdMobi con = new ConexaoBdMobi();        
        
        
        if (con.insertCadastro(formularioCadastroBean)) {
             FacesContext.getCurrentInstance().addMessage(
                       null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!", "Operação Realizada com sucesso!"));
        } else {
             FacesContext.getCurrentInstance().addMessage(
                       null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!", "Erro ao Executar Operação!"));

        }
        con.closeConnection();
        
        
        
  return "";
}
	
	
	 public List<FormularioCadastroBean> getUsuarios() throws SQLException {
		   
		 ConexaoBdMobi con = new ConexaoBdMobi();
         List<FormularioCadastroBean>formularioCadastroBeans = con.listCadastro();
    
         return formularioCadastroBeans;
    }
    
    public FormularioCadastroBean getFormulario() {
         return formularioCadastroBean;
    }
    
    public void setUsuario(FormularioCadastroBean formularioCadastroBean) {
         this.formularioCadastroBean = formularioCadastroBean;
    }

}
