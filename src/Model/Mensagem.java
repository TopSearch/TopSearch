// PACOTE
package Model;

public class Mensagem {

    // DECLARA AS VARIAVEIS
    private int id;
    private int idUsuario;
    private String status;
    private String mensagem1;
    private String mensagem2;
    private String mensagem3;
    private String mensagem4;
    private String mensagem5;

    // GETS E SETS...
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMensagem1() {
        return mensagem1;
    }

    public void setMensagem1(String mensagem1) {
        this.mensagem1 = mensagem1;
    }

    public String getMensagem2() {
        return mensagem2;
    }

    public void setMensagem2(String mensagem2) {
        this.mensagem2 = mensagem2;
    }

    public String getMensagem3() {
        return mensagem3;
    }

    public void setMensagem3(String mensagem3) {
        this.mensagem3 = mensagem3;
    }

    public String getMensagem4() {
        return mensagem4;
    }

    public void setMensagem4(String mensagem4) {
        this.mensagem4 = mensagem4;
    }

    public String getMensagem5() {
        return mensagem5;
    }

    public void setMensagem5(String mensagem5) {
        this.mensagem5 = mensagem5;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
