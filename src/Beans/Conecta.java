package Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conecta {

    // FUNÇÃO QUE ABRE A CONEXÃO COM O BANCO DE DADOS MYSQL, LOCALIZADO NO SERVIDOR DA FASTERNET (WIDEWAY)
    public static Connection abreConexao() {
        // CAMINHO
        String url = "jdbc:mysql://s1.mysql.wideway.net.br:3306/topsearch_273";
        // USUARIO
        String user = "felipe_273";
        // SENHA
        String password = "tcc2014";

        // TENTANDO CONECTAR
        try {
            // SE CONECTAR RETORNA A CONEXÃO
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // CASO CONTRÁRIO, INFORMA ERRO E RETORNA EM BRANCO
            JOptionPane.showMessageDialog(null, "Erro: Não foi possível conectar ao banco de dados!");
            e.printStackTrace();
            return null;
        }
    }
}
