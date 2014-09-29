package Beans;

import Model.Mensagem;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MensagemDAO {

    // DECLARA OBJETO PARA CONEXÃO
    private static Connection conn = null;
    // DECLARA OBJETO PARA EXECUTAR SQLS NO BANCO
    private static PreparedStatement pst = null;

    // CONSTRUTOR
    public MensagemDAO() {
        conn = Conecta.abreConexao();
    }

    // FUNÇÃO PARA OBTER AS CINCO MENSAGENS CONFIGURADAS PELO USUARIO
    public static Mensagem obterMensagens(Usuario usuario) {
        // SELECT
        String sql = "SELECT id, status, mensagem1, mensagem2, mensagem3, mensagem4, mensagem5 FROM mensagem WHERE id_usuario = ?";
        // CRIAÇÃO DO OBJETO DO TIPO MENSAGEM
        Mensagem mensagem = new Mensagem();
        try {
            pst = conn.prepareStatement(sql);
            // SETA OS PARAMETROS NO SQL
            pst.setInt(1, usuario.getId());
            // EXECUTA E ARMARZENA NO OBJETO RS DO TIPO RESULTSET
            ResultSet rs = pst.executeQuery();
            // ENQUANTO EXISTIR RESULTADOS, CRIA O OBJETO MENSAGEM
            while (rs.next()) {
                mensagem.setId(rs.getInt(1));
                mensagem.setStatus(rs.getString(2));
                mensagem.setMensagem1(rs.getString(3));
                mensagem.setMensagem2(rs.getString(4));
                mensagem.setMensagem3(rs.getString(5));
                mensagem.setMensagem4(rs.getString(6));
                mensagem.setMensagem5(rs.getString(7));
            }
            // RETORNA A(S) MENSAGEM(NS)
            return mensagem;
        } catch (SQLException f) {
            // SENÃO, MOSTRA ERRO
            f.printStackTrace();
            return null;
        }
    }

    // FUNÇÃO PARA INSERIR MENSAGENS
    public void insereMensagens(Mensagem mensagem) {
        // SQL PARA INSERÇÃO
        String sql = "INSERT INTO mensagem (id_usuario, status, mensagem1, mensagem2, mensagem3, mensagem4, mensagem5) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(sql);
            // SETA OS PARAMETROS NO SQL
            pst.setInt(1, mensagem.getIdUsuario());
            pst.setString(2, mensagem.getStatus());
            pst.setString(3, mensagem.getMensagem1());
            pst.setString(4, mensagem.getMensagem2());
            pst.setString(5, mensagem.getMensagem3());
            pst.setString(6, mensagem.getMensagem4());
            pst.setString(7, mensagem.getMensagem5());
            // EXECUTA
            pst.execute();
            JOptionPane.showMessageDialog(null, "Mensagens cadastradas com sucesso.", "Mensagens Cadastradas", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException f) {
            // EM CASO DE ERRO, MOSTRA MENSAGEM
            f.printStackTrace();
        }
    }

    // FUNÇÃO PARA ATUALIZAR AS MENSAGENS JÁ EXISTENTES NO USUARIO, PASSANDO AS CINCO MENSAGENS E O ID DO USUARIO.
    public void atualizaMensagens(Mensagem mensagem) {
        String sql = "UPDATE mensagem SET status = ?, mensagem1 = ?, mensagem2 = ?, mensagem3 = ?, mensagem4 = ?, mensagem5 = ? WHERE id_usuario = ?";
        try {
            pst = conn.prepareStatement(sql);
            // SETA OS CAMPOS NO SQL
            pst.setString(1, mensagem.getStatus());
            pst.setString(2, mensagem.getMensagem1());
            pst.setString(3, mensagem.getMensagem2());
            pst.setString(4, mensagem.getMensagem3());
            pst.setString(5, mensagem.getMensagem4());
            pst.setString(6, mensagem.getMensagem5());
            pst.setInt(7, mensagem.getIdUsuario());
            // EXECUTA
            pst.execute();
            JOptionPane.showMessageDialog(null, "Mensagens atualizadas com sucesso.", "Mensagens Atualizadas", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException f) {
            // MOSTRA O ERRO SE EXISTIR.
            f.printStackTrace();
        }
    }
}
