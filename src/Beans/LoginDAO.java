package Beans;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    //DECLARA OBJETO PARA CONEXÃO
    private static Connection conn = null;
    //DECLARA OBJETO PARA EXECUTAR SQLS NO BANCO
    private static PreparedStatement pst = null;

    // CONSTRUTOR
    public LoginDAO() {
        conn = Conecta.abreConexao();
    }

    // FUNÇÃO PARA LOGAR NO SISTEMA, PASSANDO DOIS PARAMETROS (LOGIN E SENHA)
    public static Usuario loginSistema(String login, String senha) {
        // INSTRUÇÃO SQL
        String sql = "SELECT id, login, senha, nome, sobrenome, email, ddd, telefone, tw_oauth_token, tw_oauth_token_secret, fb_access_token FROM usuario WHERE login = ? and senha = ?";
        // INSTANCIA UM OBJETO USUARIO
        Usuario usuario = new Usuario();
        try {
            pst = conn.prepareStatement(sql);
            // SETA OS PARAMETROS CONFORME A ORDEM ABAIXO NA STRING SUBSTITUINDO OS INTERROGAÇÕES
            pst.setString(1, login);
            pst.setString(2, senha);
            // CRIA O OBJETO RESULTSET, COM OS RESULTADOS DO SQL
            ResultSet rs = pst.executeQuery();
            // ENQUANTO EXISTIR RESULTADOS, ARMAZENA NO OBJETO USUARIO.
            while (rs.next()) {
                usuario.setId(rs.getInt(1));
                usuario.setLogin(rs.getString(2));
                usuario.setSenha(rs.getString(3));
                usuario.setNome(rs.getString(4));
                usuario.setSobrenome(rs.getString(5));
                usuario.setEmail(rs.getString(6));
                usuario.setDdd(rs.getString(7));
                usuario.setTelefone(rs.getString(8));
                usuario.setTw_oauth_token(rs.getString(9));
                usuario.setTw_oauth_token_secret(rs.getString(10));
                usuario.setFb_access_token(rs.getString(11));
            }
            // RETORNA O USUARIO
            return usuario;
        } catch (SQLException f) {
            f.printStackTrace();
            return null;
        }
    }

    // FUNÇÃO PARA ATUALIZAR AS INFORMAÇÕES DOS TOKENS NO BANCO MYSQL, PASSANDO OS PARAMETROS, TOKEN, TOKEN_SECRET E ID DO USUARIO
    public void atualizaTokens(String token, String token_secret, Integer id) {
        String sql = "UPDATE usuario SET tw_oauth_token = ?, tw_oauth_token_secret = ? WHERE id = ?";
        try {
            pst = conn.prepareStatement(sql);
            // SETA OS PARAMETROS CONFORME A ORDEM ABAIXO NA STRING SUBSTITUINDO OS INTERROGAÇÕES
            pst.setString(1, token);
            pst.setString(2, token_secret);
            pst.setInt(3, id);
            // EXECUTA SQL
            pst.execute();
        } catch (SQLException f) {
            f.printStackTrace();
        }
    }
}
