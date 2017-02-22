package br.com.valemobi.vale.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.cj.jdbc.PreparedStatement;

import br.com.valemobi.vale.FormularioCadastroBean;

public class ConexaoBdMobi {
	public static String status = "Não conectou...";

	Connection con = null;
    private static final String USUARIO = "root";
    private static final String SENHA = "Acjumarts1010";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/valemobi";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    // Conectar ao banco
    public static Connection abrir() throws Exception {
        // Registrar o driver
        Class.forName(DRIVER);
        // Capturar a conexão
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        // Retorna a conexao aberta
        return conn;


    }
    
    public void closeConnection() throws SQLException {
    	   
        con.close();
   }
    
    
 // cadastral no banco um usuario passado como parametro
    public boolean insertCadastro(FormularioCadastroBean formularioCadastroBean) throws Exception {

        
        

         try {
        	   
        	   con = ConexaoBdMobi.abrir();
        	   Statement st = (Statement) con.createStatement();

               PreparedStatement preparedStatement = (PreparedStatement) con
                         .prepareStatement("insert into cadastro(campoCodigoMercadoria,campoTipo,campoQuantidade,campoPreco,tipoNegocio) values(?,?,?,?,?)");
               preparedStatement.setInt(1, formularioCadastroBean.getCampoCodigoMercadoria());
               preparedStatement.setString(2, formularioCadastroBean.getCampoTipo());
               preparedStatement.setInt(3, formularioCadastroBean.getCampoQuantidade());
               preparedStatement.setDouble(4, formularioCadastroBean.getCampoPreco());
               preparedStatement.setString(5, formularioCadastroBean.getTipoNegocio());
               
               preparedStatement.execute();
               return true;
         } catch (SQLException ex) {
              System.out.println("Deu Problema "+ex);
               return false;

         }
    }
//lista todos os usuarios cadastrados no banco de dados
 public List<FormularioCadastroBean> listCadastro() {

	ArrayList<FormularioCadastroBean> lista = new ArrayList<FormularioCadastroBean>();
	Statement st = null;
    ResultSet rs = null;

    try {
          st = (Statement) con.createStatement();
          String sql = "select * from cadastro";
         rs = st.executeQuery(sql);

          while (rs.next()) {

        	  FormularioCadastroBean formularioCadastroBean = new FormularioCadastroBean();
        	   formularioCadastroBean.setCampoCodigoMercadoria(rs.getInt(1));
        	   formularioCadastroBean.setCampoTipo(rs.getString(2));
        	   formularioCadastroBean.setCampoPreco(rs.getDouble(3));
        	   formularioCadastroBean.setTipoNegocio(rs.getString(4));
               lista.add(formularioCadastroBean);
               
          }

    } catch (SQLException ex) {
    	 System.out.println("Deu Problema "+ex);
     
    } finally {
          try {
               if (rs != null) {
                    rs.close();
               }
               if (st != null) {
                    st.close();
               }
               if (con != null) {
                    con.close();
               }

          } catch (SQLException ex) {
             
          }
    }
    return lista;
}
}
    
