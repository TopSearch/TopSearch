// PACOTE
package Model;

public class Usuario {

    // DECLARA AS VARIAVEIS
    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String ddd;
    private String telefone;
    private String login;
    private String senha;
    private String tw_oauth_token;
    private String tw_oauth_token_secret;
    private String fb_access_token;

    // GETS E SETS...
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTw_oauth_token() {
        return tw_oauth_token;
    }

    public void setTw_oauth_token(String tw_oauth_token) {
        this.tw_oauth_token = tw_oauth_token;
    }

    public String getTw_oauth_token_secret() {
        return tw_oauth_token_secret;
    }

    public void setTw_oauth_token_secret(String tw_oauth_token_secret) {
        this.tw_oauth_token_secret = tw_oauth_token_secret;
    }

    public String getFb_access_token() {
        return fb_access_token;
    }

    public void setFb_access_token(String fb_access_token) {
        this.fb_access_token = fb_access_token;
    }
}
