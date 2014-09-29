// PACOTE
package GUI;

// IMPORTA AS CLASSES
import Beans.LoginDAO;
import Model.Usuario;
import facebook4j.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

// CLASSE FRAME_LOGIN, EXTENDENDO O JFRAME, O QUAL UTILIZAMOS PARA CRIAÇÃO DA INTERFACE GRÁFICA
public class Frame_Login extends javax.swing.JFrame {

    // CLASSE QUE ESPECIFICA AS OPERAÇÕES A SEREM EXECUTADAS QUANDO O FRAME_LOGIN FOR CHAMADO
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                // CRIA O OBJETO DESTA CLASSE
                Frame_Login l = new Frame_Login();
                // LOCALIZA O MESMO NO CENTRO (VERTICAL E HORIZONTAL)
                l.setLocationRelativeTo(null);
                // SETA VISIBILIDADE
                l.setVisible(true);
                //URL url = this.getClass().getResource("/Imagens/favicon.png");
                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage("/Imagens/favicon.png");
                l.setIconImage(imagemTitulo);
            }
        });
    }

    // CONSTRUTOR
    public Frame_Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        edLogin = new javax.swing.JTextField();
        edSenha = new javax.swing.JPasswordField();
        btLogar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbEsqueceuSuaSenha = new javax.swing.JLabel();
        lbNovoUsuario = new javax.swing.JLabel();
        lbVisitePaginaWeb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Top Search - Busca Social Gratuita");
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Login:");

        jLabel2.setText("Senha:");

        edLogin.setToolTipText("Informe seu Login");
        edLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edLogin.setName(""); // NOI18N
        edLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                edLoginFocusLost(evt);
            }
        });
        edLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edLoginMouseClicked(evt);
            }
        });
        edLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edLoginKeyPressed(evt);
            }
        });

        edSenha.setToolTipText("Informe sua senha");
        edSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                edSenhaFocusLost(evt);
            }
        });
        edSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edSenhaKeyPressed(evt);
            }
        });

        btLogar.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        btLogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logar.png"))); // NOI18N
        btLogar.setText("Logar");
        btLogar.setToolTipText("Logar no TopSearch");
        btLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogarActionPerformed(evt);
            }
        });
        btLogar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btLogarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(edSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btLogar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btLogar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setToolTipText("");

        lbEsqueceuSuaSenha.setText("Esqueceu sua senha?");
        lbEsqueceuSuaSenha.setToolTipText("Abrir página de recuperação de senha");
        lbEsqueceuSuaSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEsqueceuSuaSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEsqueceuSuaSenhaMouseClicked(evt);
            }
        });

        lbNovoUsuario.setText("Novo Usuário?");
        lbNovoUsuario.setToolTipText("Abrir página para realizar um novo cadastro");
        lbNovoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNovoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNovoUsuarioMouseClicked(evt);
            }
        });

        lbVisitePaginaWeb.setText("Visite o Website");
        lbVisitePaginaWeb.setToolTipText("Abrir Página Inicial TopSearch");
        lbVisitePaginaWeb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbVisitePaginaWeb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVisitePaginaWebMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbVisitePaginaWeb)
                .addGap(26, 26, 26)
                .addComponent(lbEsqueceuSuaSenha)
                .addGap(18, 18, 18)
                .addComponent(lbNovoUsuario)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEsqueceuSuaSenha)
                    .addComponent(lbNovoUsuario)
                    .addComponent(lbVisitePaginaWeb))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon("D:\\Documentos\\NetBeansProjects\\TopSearch - Cópia\\src\\Imagens\\logotipo.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // BOTÃO LOGAR
    private void btLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogarActionPerformed
        // CAPTURA AS INFORMAÇÕES DIGITADAS NOS CAMPOS LOGIN E SENHA PELO USUARIO.
        String login = edLogin.getText().trim();
        String senha = edSenha.getText();
        // EM CASO DO LOGIN ESTAR EM BRANCO, MOSTRA MENSAGEM E SETA O FOCO.
        if (login.equals("")) {
            JOptionPane.showMessageDialog(null, "Verifique seu Login");
            edLogin.requestFocus();
        } // EM CASO DA SENHA ESTAR EM BRANCO, MOSTRA MENSAGEM E SETA O FOCO.
        else if (senha.equals("")) {
            JOptionPane.showMessageDialog(null, "Verifique sua Senha");
            edSenha.requestFocus();
        } // CASO CONTRARIO, CONECTA NO BANCO E REALIZA AS VERIFICAÇÕES NECESSÁRIAS
        else {
            try {
                // CRIANDO OS OBJETOS LOGINDAO, E USUARIO
                LoginDAO loginDao = new LoginDAO();
                Usuario usuarioLogin = null;
                // CHAMA A FUNÇÃO PARA LOGAR NO SISTEMA
                usuarioLogin = loginDao.loginSistema(login, senha);
                // SE HOUVER ALGUM RETORNO DIFERENTE DE NULL
                if (usuarioLogin.getSenha() != null) {
                    // CONECTA NA APLICAÇÃO
                    try {
                        // O OBJETO CONFIGURATION BUILDER É UMA CLASSE DA API DO TWITTER, 
                        // O QUAL É RESPONSÁVEL POR SETAR AS INFORMAÇÕES DO APLICATIVO TOPSEARCH
                        // E OS TOKENS DO USUÁRIO PARA UTILIZAR AS INFORMAÇÕES DO SEU PERFIL E DE 
                        // SEUS INTERESSES.
                        ConfigurationBuilder builder = new ConfigurationBuilder();
                        // SETA O TOKEN DO CONSUMER KEY
                        builder.setOAuthConsumerKey("MopMLIoDuSEKkw8yNpqbTacT1");
                        // SETA O TOKEN CONSUMER SECRET
                        builder.setOAuthConsumerSecret("523HOIDiH4Jx1EiikaFUfqI042FId2KmvnG5o5VjN3WFoR3sDY");
                        // CRIO UM OBJETO DO TIPO CONFIGURATION, RESPONSÁVEL EM OBTER AS PERMISSOES 
                        // CEDIDAS PELO USUÁRIO ALÉM DE CONFIGURAÇÕES DE CONEXÃO COM O TWITTER
                        Configuration configuration = builder.build();
                        // O OBJETO TWITTER FACTORY É RESPONSÁVEL INSTANCIAR AS CONFIGURAÇÕES PARA 
                        // UTILIZAÇÃO DAS FUNÇÕES DISPONÍVEIS PELA API.
                        TwitterFactory factory = new TwitterFactory(configuration);

                        // O OBJETO TWITTER, OBTEM OS DADOS DO FACTORY
                        Twitter twitter = factory.getSingleton();
                        // SETA OS TOKENS DO APLICATIVO
                        twitter.setOAuthConsumer("MopMLIoDuSEKkw8yNpqbTacT1", "523HOIDiH4Jx1EiikaFUfqI042FId2KmvnG5o5VjN3WFoR3sDY");
                        // CHAMA O METODO PARA REQUISITAR OS TOKENS DA API
                        RequestToken requestToken = twitter.getOAuthRequestToken();
                        // CRIA O OBJETO ACCESS TOKEN
                        AccessToken accessToken = null;
                        //SETO UM OBJETO BUFFERED READER PARA OBTER OS RESULTADOS NA CONEXÃO SOCKET
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        // SE RETORNAREM NULL OU MENOR QUE 43
                        while (null == accessToken && usuarioLogin.getTw_oauth_token().length() < 43) {
                            try {
                                // ABRE BROWSER SOLICITANDO O PIN
                                java.awt.Desktop.getDesktop().browse(new java.net.URI(requestToken.getAuthenticationURL()));
                            } // SENÃO TRATA OS ERROS
                            catch (URISyntaxException ex) {
                                ex.getMessage();
                            } catch (IOException ex) {
                                ex.getMessage();
                            }
                            // SOLICITA O PIN PARA O USUARIO DIGITAR (DIGITOS NUMERICOS)
                            String pin = (String) JOptionPane.showInputDialog(null, "Digite o PIN");
                            try {
                                // SE O PIN DIGITADO FOR MAIOR QUE ZERO SOLICITA O ACCESS TOKEN
                                if (pin.length() > 0) {
                                    accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                                } // SENÃO AGUARDA E RETORNA PARA O METODO 
                                else {
                                    accessToken = twitter.getOAuthAccessToken();
                                }

                            } // TRATA ERROS DA AUTENTICAÇÃO
                            catch (TwitterException te) {
                                if (401 == te.getStatusCode()) {
                                    // ERRO 401, É RETORNADO QUANDO NÃO FOI POSSIVEL OBTER O TOKEN DE ACESSO, 
                                    // POR QUESTÕES DE CONEXÃO, PIN ERRADO, OU TOKENS DA APLICAÇÃO NÃO CONFERE 
                                    // COM O USUARIO.
                                    JOptionPane.showMessageDialog(null, "Não foi possível obter o Token de Acesso!");
                                } else {
                                    // CASO SEJA OUTROS ERROS, MOSTRA O ERRO.
                                    te.printStackTrace();
                                }
                            }
                        }
                        // CRIA UM OBJETO CONFIGURATION BUILDER, RESPONSAVEL POR AUTENTICAR COM A REDE SOCIAL TWITTER
                        ConfigurationBuilder cb = new ConfigurationBuilder();
                        // SE O TOKEN DO BANCO FOR MENOR QUE 43
                        if (usuarioLogin.getTw_oauth_token().length() < 43) {
                            // É ATUALIZADO OS TOKENS OBTIDOS ANTERIORMENTE, NO BANCO DE DADOS.
                            LoginDAO l = new LoginDAO();
                            l.atualizaTokens(accessToken.getToken(), accessToken.getTokenSecret(), usuarioLogin.getId());
                            // E ABRE A CONEXÃO COM O TWITTER
                            cb.setDebugEnabled(true)
                                    .setOAuthConsumerKey("MopMLIoDuSEKkw8yNpqbTacT1")
                                    .setOAuthConsumerSecret("523HOIDiH4Jx1EiikaFUfqI042FId2KmvnG5o5VjN3WFoR3sDY")
                                    .setOAuthAccessToken("" + accessToken.getToken() + "")
                                    .setOAuthAccessTokenSecret("" + accessToken.getTokenSecret() + "");
                        } else {
                            // SENÃO É OBTIDO OS TOKENS QUE JÁ ESTÃO SALVOS NO BANCO DE DADOS E ABRE A CONEXÃO COM O TWITTER
                            cb.setDebugEnabled(true)
                                    .setOAuthConsumerKey("MopMLIoDuSEKkw8yNpqbTacT1")
                                    .setOAuthConsumerSecret("523HOIDiH4Jx1EiikaFUfqI042FId2KmvnG5o5VjN3WFoR3sDY")
                                    .setOAuthAccessToken("" + usuarioLogin.getTw_oauth_token() + "")
                                    .setOAuthAccessTokenSecret("" + usuarioLogin.getTw_oauth_token_secret() + "");
                        }
                        // É CRIADO UM OBJETO TWITTER, RETORNANDO AS FUNÇÕES QUE O USUARIO AUTENTICADO LIBEROU.
                        Twitter t = new TwitterFactory(cb.build()).getInstance();
                        // CRIA O OBJETIVO USER PARA OBTER AS CREDENCIAIS UTILIZADAS PELO USUARIO NECESSÁRIAS 
                        // PARA QUALQUER INTERAÇÃO DO SISTEMA.
                        User u = t.verifyCredentials();

                        //FACEBOOK
                        // CRIA UM OBJETO CONFIGURATION BUILDER, RESPONSAVEL POR AUTENTICAR COM A REDE SOCIAL FACEBOOK
                        facebook4j.conf.ConfigurationBuilder cb2 = new facebook4j.conf.ConfigurationBuilder();
                        cb2.setDebugEnabled(true)
                                .setOAuthAppId("259565147585327")
                                .setOAuthAppSecret("508310ba4bdfa584e4f961262099de6c")
                                .setOAuthAccessToken(usuarioLogin.getFb_access_token())
                                .setOAuthPermissions("public_profile, basic_info, read_stream, read_mailbox, read_page_mailboxes, rsvp_event, email, read_insights, manage_notifications, read_friendlists, manage_pages, publish_actions, user_birthday, user_religion_politics, user_relationships, user_relationship_details, user_hometown, user_location, user_likes, user_activities, user_interests, user_education_history, user_work_history, user_website, user_groups, user_events, user_photos, user_videos, user_friends, user_about_me, user_status, user_games_activity, user_tagged_places, user_actions.books, user_actions.music, user_actions.video, user_actions.news");
                        //.setOAuthPermissions("public_profile, read_stream, read_mailbox, read_page_mailboxes, rsvp_event, email, read_insights, manage_notifications, read_friendlists, manage_pages, publish_actions");

                        // É CRIADO UM OBJETO FACEBOOK FACTORY, RETORNANDO AS FUNÇÕES QUE O USUARIO AUTENTICADO LIBEROU.
                        FacebookFactory ff = new FacebookFactory(cb2.build());
                        // CRIA O OBJETIVO FACEBOOK PARA OBTER A INSTANCIA AUTENTICADA
                        Facebook f = ff.getInstance();
                        // CRIA O OBJETIVO USER PARA OBTER AS CREDENCIAIS UTILIZADAS PELO USUARIO NECESSÁRIAS 
                        // PARA QUALQUER INTERAÇÃO DO SISTEMA.
                        facebook4j.User uf = new facebook4j.User() {

                            @Override
                            public String getId() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public String getName() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public String getFirstName() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public String getMiddleName() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public String getLastName() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public String getGender() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public Locale getLocale() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public List<IdNameEntity> getLanguages() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public URL getLink() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public String getUsername() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public String getThirdPartyId() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public Boolean isInstalled() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public Double getTimezone() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public Date getUpdatedTime() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public Boolean isVerified() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public String getBio() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public String getBirthday() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public Cover getCover() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public List<facebook4j.User.Education> getEducation() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public String getEmail() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public IdNameEntity getHometown() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public List<String> getInterestedIn() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public IdNameEntity getLocation() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public String getPolitical() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public List<IdNameEntity> getFavoriteAthletes() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public List<IdNameEntity> getFavoriteTeams() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public Picture getPicture() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public String getQuotes() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public String getRelationshipStatus() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public String getReligion() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public IdNameEntity getSignificantOther() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public facebook4j.User.VideoUploadLimits getVideoUploadLimits() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public URL getWebsite() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public List<facebook4j.User.Work> getWork() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }
                        };
                        // SETA O USUARIO LOGADO NO OBJETO DO TIPO USER, PARA OBTER INFORMAÇÕES DO USUARIO DO FACEBOOK
                        uf = f.getMe();

                        // INSTANCIA A TELA INICIAL
                        Frame_TelaInicial ti = new Frame_TelaInicial(t, u, usuarioLogin, f, uf);
                        // LOCALIZAÇÃO CENTRALIZADA
                        ti.setLocationRelativeTo(null);
                        // SETA O FOCO PARA A TELA INICIAL
                        ti.setVisible(true);
                        // FECHA A TELA DO LOGIN
                        this.dispose();

                        // EXIBE MENSAGEM DE BOAS VINDAS
                        JOptionPane.showMessageDialog(null, "Seja bem vindo " + usuarioLogin.getNome() + " " + usuarioLogin.getSobrenome() + "!", "Logado no TopSearch", JOptionPane.INFORMATION_MESSAGE);
                    } // EM CASO ERRO, TRATA OS EXCEPTIONS
                    catch (TwitterException e) {
                        e.printStackTrace();
                        if (e.getStatusCode() == 401) {
                            // ERRO 401, RETORNA USUARIO OU SENHA INVÁLIDOS COM O TWITTER, SENDO
                            // NECESSÁRIO A OBTENÇÃO DOS TOKENS NOVAMENTE
                            // EXIBE MENSAGEM DE ERRO, LIMPA OS CAMPOS, E SETA O FOCO NO CAMPO LOGIN
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(this, "Usuário e/ou senha inválidos!");
                            edLogin.setText(null);
                            edSenha.setText(null);
                            edLogin.requestFocus();
                        }
                    } // TRATA OS ERROS
                    catch (IllegalStateException ex) {
                        ex.getMessage();
                    } catch (FacebookException ex) {
                        if (ex.getErrorCode() == 190) {
                            JOptionPane.showMessageDialog(null, "Token do Facebook expirou!");
                        }
                        ex.getMessage();
                    }
                } // EM CASO DE ERRO DE AUTENTICAÇÃO COM A APLICAÇÃO
                else {
                    // MOSTRA MENSAGEM DE ERRO, LIMPA OS CAMPOS E SETA O FOCO NO CAMPO LOGIN
                    JOptionPane.showMessageDialog(null, "Usuário e/ou Senha Inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
                    edLogin.setText(null);
                    edSenha.setText(null);
                    edLogin.requestFocus();
                }
            } // EM CASO DE ERRO DE AUTENTICAÇÃO COM A APLICAÇÃO
            catch (NullPointerException e) {
                // MOSTRA MENSAGEM DE ERRO, LIMPA OS CAMPOS E SETA O FOCO NO CAMPO LOGIN
                JOptionPane.showMessageDialog(null, "Usuário e/ou Senha Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                edLogin.setText(null);
                edSenha.setText(null);
                edLogin.requestFocus();
            }
        }
    }//GEN-LAST:event_btLogarActionPerformed
    // LINK PARA ESQUECEU SUA SENHA
    private void lbEsqueceuSuaSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEsqueceuSuaSenhaMouseClicked
        try {
            // ABRE BROWSER NO LINK
            java.awt.Desktop.getDesktop().browse(new java.net.URI("http://www.topsearch.com.br/esqueci"));
        } // TRATA OS ERROS EM CASO DE EXISTENCIA
        catch (URISyntaxException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_lbEsqueceuSuaSenhaMouseClicked
    // LINK PARA NOVO USUÁRIO
    private void lbNovoUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNovoUsuarioMouseClicked
        try {
            // ABRE BROWSER NO LINK
            java.awt.Desktop.getDesktop().browse(new java.net.URI("http://www.topsearch.com.br/cadastro"));
        } // TRATA OS ERROS EM CASO DE EXISTENCIA
        catch (URISyntaxException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_lbNovoUsuarioMouseClicked

    // AO ABRIR A TELA, SETA O FOCO PARA O CAMPO LOGIN
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        edLogin.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    // QUANDO PRESSIONADO ENTER NO CAMPO LOGIN SETA O FOCO PARA SENHA
    private void edLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            edSenha.requestFocus();
        }
    }//GEN-LAST:event_edLoginKeyPressed

    // QUANDO PRESSIONADO ENTER NO BOTÃO LOGAR CHAMA A AÇÃO DO BOTÃO
    private void btLogarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btLogarKeyPressed
        if (evt.getKeyCode() == 10) {
            btLogarActionPerformed(null);
        }
    }//GEN-LAST:event_btLogarKeyPressed

    // QUANDO PRESSIONADO ENTER NO CAMPO SENHA SETA O FOCO PARA O BOTÃO
    private void edSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edSenhaKeyPressed
        if (evt.getKeyCode() == 10) {
            btLogar.requestFocus();
        }
    }//GEN-LAST:event_edSenhaKeyPressed

    // QUANDO SAIR DO CAMPO LOGIN, SETA O FOCO NO CAMPO SENHA
    private void edLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edLoginFocusLost
        edSenha.requestFocus();
    }//GEN-LAST:event_edLoginFocusLost

    // QUANDO SAIR DO CAMPO SENHA, SETA O FOCO PARA O BOTÃO
    private void edSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edSenhaFocusLost
        btLogar.requestFocus();
    }//GEN-LAST:event_edSenhaFocusLost

    // LINK PARA VISITE O WEBSITE
    private void lbVisitePaginaWebMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVisitePaginaWebMouseClicked
        try {
            // ABRE BROWSER NO LINK
            java.awt.Desktop.getDesktop().browse(new java.net.URI("http://www.topsearch.com.br/"));
        } // TRATA OS ERROS EM CASO DE EXISTENCIA
        catch (URISyntaxException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_lbVisitePaginaWebMouseClicked

    // FORÇA O FOCO NO CAMPO LOGIN AO CLICAR NO CAMPO
    private void edLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edLoginMouseClicked
        edLogin.requestFocus();
    }//GEN-LAST:event_edLoginMouseClicked

    public static void main() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        } catch (InstantiationException ex) {
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            ex.getMessage();
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            ex.getMessage();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogar;
    private javax.swing.JTextField edLogin;
    private javax.swing.JPasswordField edSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbEsqueceuSuaSenha;
    private javax.swing.JLabel lbNovoUsuario;
    private javax.swing.JLabel lbVisitePaginaWeb;
    // End of variables declaration//GEN-END:variables
}
