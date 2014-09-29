// PACOTE
package GUI;

// IMPORTA AS CLASSES
import Beans.MensagemDAO;
import Model.Mensagem;
import Model.Usuario;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.User;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Panel_FBusca extends javax.swing.JPanel {

    // DECLARA AS VARIAVEIS 
    private Facebook f;
    private User uf;
    private String palavra_chave;
    private Usuario usuarioLogado;
    private Image foto;
    private String urlfoto, urlfoto2;
    private JPanel pane;
    private JLabel novaFoto;
    private JTextArea msg;
    private JLabel profile;
    private Post status6;
    private String s1 = "", s2 = "", s3 = "", temp = "";
    private int i6 = 0;
    private ResponseList<Post> resultadoBusca6 = null;
    private List<Post> listaPosts;
    private String query;
    private Iterator<Post> itPosts;

// CONSTRUTOR
    public Panel_FBusca(Facebook f, User uf, String palavra_chave, Usuario usuarioLogado, String s1, String s2, String s3) throws FacebookException {
        this.f = f;
        this.uf = uf;
        this.palavra_chave = palavra_chave;
        this.usuarioLogado = usuarioLogado;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        initComponents();
        recuperarDados();
    }

    // FUNÇÃO A QUAL INICIA A TELA PRINCIPAL
    public void recuperarDados() throws FacebookException {
        // SETA A URL DA FOTO DO PERFIL DO FACEBOOK DO USUÁRIO LOGADO 
        urlfoto = String.valueOf(f.getPictureURL());
        //SETA NO LABEL A URL DA FOTO
        jL_Foto.setIcon(new javax.swing.JLabel() {
            @Override
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                            new java.net.URL(urlfoto)
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        // CHAMA FUNÇÃO CARREGA TIMELINE
        carregaTimeline();
    }

    // FUNÇÃO RESPONSÁVEL POR INTERAGIR COM OS POSTS ENCONTRADOS
    public void interageMsg() {
        // INSTANCIA UM OBJETO DA CLASSE MENSAGEM
        Mensagem msg2 = new Mensagem();
        // INSTANCIA UM OBJETO DA CLASSE MENSAGEM DAO
        MensagemDAO msgDao = new MensagemDAO();
        // CARREGA AS MENSAGENS DO USUARIO LOGADO
        msg2 = msgDao.obterMensagens(usuarioLogado);
        // SE O STATUS DA MENSAGEM FOR IGUAL A S, OU SEJA, O USUARIO POSSUI CONFIGURADO
        // AS INTERAÇÕES AUTOMÁTICAS
        if (msg2.getStatus().equals("S")) {
            // FAZ UMA PERGUNTA COM 2 OPÇÕES (S/N), SE O USUARIO DESEJA INTERAGIR
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja interagir com os posts encontrados?");
            // SE FOR SIM
            if (resposta == JOptionPane.YES_OPTION) {
                // VERIFICA SE POSSUI ELEMENTOS NA LISTA DE RESULTADOS DA BUSCA, SE TIVER
                if (resultadoBusca6.size() != 0) {
                    // OBTEM A LISTA DE RESULTADOS
                    listaPosts = resultadoBusca6;
                    // OBTEM A LISTA DE RESULTADOS CRIANDO UMA LISTA DO TIPO ITERATOR
                    itPosts = listaPosts.iterator();
                    // ENQUANTO EXISTIR OBJETOS NA LISTA
                    while (itPosts.hasNext()) {
                        // O OBJETO STATUS (POST) OBTEM UM DOS OBJETOS DA LISTA
                        status6 = (Post) itPosts.next();
                        // É GERADO UMA VARIAVEL RANDOMICA, O QUAL CONTA DE 0 A 4 (CINCO) E FICA RESPONSÁVEL EM SORTEAR UMA DAS CINCO MENSAGENS CADASTRADAS
                        Random gerador = new Random();
                        // GERA O NUMERO RANDOMICO
                        int j = gerador.nextInt(4);
                        // VARIAVEL PARA OBTER A MENSAGEM SORTEADA
                        String interacao;
                        // SE O NUMERO RANDOMICO FOR IGUAL A ZERO
                        if (j == 0) {
                            // OBTEM A PRIMEIRA MENSAGEM
                            interacao = msg2.getMensagem1();
                        }// SENÃO, NUMERO RANDOMICO FOR IGUAL A UM
                        else if (j == 1) {
                            // OBTEM A SEGUNDA MENSAGEM
                            interacao = msg2.getMensagem2();
                        }// SENÃO, NUMERO RANDOMICO FOR IGUAL A DOIS
                        else if (j == 2) {
                            // OBTEM A TERCEIRA MENSAGEM
                            interacao = msg2.getMensagem3();
                        }// SENÃO, NUMERO RANDOMICO FOR IGUAL A TRES
                        else if (j == 3) {
                            // OBTEM A QUARTA MENSAGEM
                            interacao = msg2.getMensagem4();
                        } // SENÃO
                        else {
                            // OBTEM A QUINTA MENSAGEM
                            interacao = msg2.getMensagem5();
                        }

                        try {
                            // MÉTODO PARA COMENTAR UM POST, PASSANDO O ID DO POST E A MENSAGEM DO COMENTÁRIO
                            f.commentPost(status6.getId(), interacao);
                            // MARCA UM CURTIR NO POST
                            f.likePost(status6.getId());
                        } // EM CASO DE ERRO, MOSTRA
                        catch (FacebookException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            } // SE NÃO ESTIVER HABILITADO A INTERAÇÃO, APRESENTA A MENSAGEM
            else {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar a Interação Automática,\npois ela se encontra Desativada. Favor verifique!", "Interação Automática Desativada", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // CASO NÃO TENHA NENHUM DADO NA LISTA, MOSTRA MENSAGEM:
            JOptionPane.showMessageDialog(null, "Não existe nenhum post encontrado");
        }
    }

    public Locale retornaLocale(String sigla) {
        Locale locale = null;
        sigla = sigla.trim();
        if (sigla.equals("qe")) {
            locale = Locale.CANADA.CANADA_FRENCH;
        } else if (sigla.equals("zh")) {
            locale = Locale.CHINA.CHINESE.TRADITIONAL_CHINESE.SIMPLIFIED_CHINESE;
        } else if (sigla.equals("en")) {
            locale = Locale.ENGLISH.US;
        } else if (sigla.equals("us")) {
            locale = Locale.ENGLISH.US;
        } else if (sigla.equals("fr")) {
            locale = Locale.FRANCE.FRENCH;
        } else if (sigla.equals("de")) {
            locale = Locale.GERMANY.GERMAN;
        } else if (sigla.equals("it")) {
            locale = Locale.ITALY.ITALIAN;
        } else if (sigla.equals("ja")) {
            locale = Locale.JAPAN.JAPANESE;
        } else if (sigla.equals("kp")) {
            locale = Locale.KOREA.KOREAN;
        } else if (sigla.equals("kr")) {
            locale = Locale.KOREA.KOREAN;
        } else if (sigla.equals("tw")) {
            locale = Locale.TAIWAN;
        } else if (sigla.equals("uk")) {
            locale = Locale.UK;
        } else if (sigla.equals("us")) {
            locale = Locale.US;
        } else {
            locale = null;
        }
        return locale;
    }

// RESPONSÁVEL POR OBTER AS MENSAGENS RESULTANTES DA BUSCA REALIZADA
    public void carregaTimeline() {
        try {
            // SETA O CONTADOR IGUAL A ZERO
            i6 = 0;
            // REMOVE TODOS OS POSTS DO PANEL
            jP_Tweets.removeAll();

            // EXECUTA A BUSCA PASSANDO ALGUNS FITLROS
            // BUSCA A PALAVRA CHAVE DIGITADA
            query = palavra_chave;

            Reading red = new Reading();
            // EM CASO DE REALIZAR UMA BUSCA AVANÇADA, E O PARÂMETRO LINGUA FOR DIFERENTE DE ZERO
            if (!s1.equals("")) {
                // OBTEM O RETORNO NO OBJETO DO TIPO LOCALE
                if (retornaLocale(s1) != null) {
                    // SETA O FILTRO NO OBJETO READING
                    red.locale(retornaLocale(s1));
                }
            }
            // EM CASO DE REALIZAR UMA BUSCA AVANÇADA, E O PARÂMETRO DATA FOR DIFERENTE DE ZERO
            if (!s2.equals("")) {
                // CONVERTE A DATA OBTIDA NO CAMPO EM DATA EM BANCO DE DADOS
                temp = s2.substring(6, 10) + "-" + s2.substring(3, 5) + "-" + s2.substring(0, 2);
                // SETA O FILTRO NO OBJETO READING
                red.since(temp);
            }
            // EM CASO DE REALIZAR UMA BUSCA AVANÇADA, E O PARÂMETRO QTDE DE POSTS FOR DIFERENTE DE ZERO
            if (s3.isEmpty() || s3.equals("")) {
                // SETA O FILTRO NO OBJETO READING
                s3 = "25";
            }
            // SETA O FILTRO NO OBJETO READING
            red.limit(Integer.parseInt(s3));

            // MOSTRA O NOME DO USUARIO LOGADO NO PERFIL DO TWITTER E O NICK DO TWITTER.
            lbUsuarioFacebook.setText(uf.getName() + " - " + uf.getUsername());
            // MOSTRA A PALAVRA CHAVE DIGITADA ANTERIORMENTE
            lbResultadoBusca.setText("Palavra-chave: \"" + palavra_chave + "\"");

            // OBTEM OS RESULTADOS DA BUSCA
            resultadoBusca6 = f.searchPosts(palavra_chave, red);
            // OBTEM A LISTA DE RESULTADOS
            listaPosts = resultadoBusca6;
            // OBTEM A LISTA DE RESULTADOS CRIANDO UMA LISTA DO TIPO ITERATOR
            itPosts = listaPosts.iterator();

            // QUANDO NÃO POSSUI NENHUM RESULTADO
            if (resultadoBusca6.size() == 0) {
                // MOSTRA MENSAGEM DE ERRO:
                JOptionPane.showMessageDialog(null, "FACEBOOK: Nenhum resultado foi obtido\ncom o(s) critério(s) definido(s).", "Nenhum resultado", JOptionPane.ERROR_MESSAGE);
                jP_Tweets.removeAll();
            }

            // SE EXISTIR RESULTADOS DA BUSCA
            if (resultadoBusca6.size() != 0) {
                // ENQUANTO EXISTIR OBJETOS NA LISTA
                while (itPosts.hasNext() && i6 <= Integer.parseInt(s3)) {
                    // INCREMENTA CONTADOR DE POSTS
                    i6++;
                    // PEGO O PROXIMO POST (STATUS)
                    status6 = itPosts.next();
                    // CRIA UM PANEL
                    pane = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    // CRIA SETA LINHA PARA O PANEL
                    pane.setBorder(new LineBorder(Color.black, 1));
                    // SETA O TAMANHO DO PANEL
                    pane.setSize(370, 100);

                    // OBTEM A URL DA FOTO DO PERFIL DO TWITTER
                    urlfoto2 = f.getPictureURL(status6.getFrom().getId()).toString();
                    // CRIA UM LABEL RECEBENDO UMA FOTO
                    novaFoto = new JLabel();
                    // SETA A URL DA FOTO NO LABEL
                    novaFoto.setIcon(new javax.swing.JLabel() {
                        public javax.swing.Icon getIcon() {
                            try {
                                return new javax.swing.ImageIcon(
                                        new java.net.URL(urlfoto2));
                            } catch (java.net.MalformedURLException e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                    }.getIcon());

                    // CAMPO RESPONSÁVEL POR APRESENTAR AS INFORMAÇÕES AO PASSAR O MOUSE NA IMAGEM DO USUARIO DO POST
                    String hint = "<HTML>";
                    hint += "<h3><marquee>Informação referente este Post</h3>" + "<BR>";
                    hint += "<B>Quantidade de Curtidas deste Post: </B>" + status6.getLikes().size() + "<BR>";
                    hint += "<B>Quantidade de Comentários deste Post: </B>" + status6.getComments().size() + "<BR>";
                    if (status6.getStatusType() != null) {
                        hint += "<B>Tipo deste Post: </B>" + status6.getStatusType() + "<BR>";
                    }
                    hint += "<B>Criado em: </B> " + (status6.getCreatedTime().getDate()) + "/" + (status6.getCreatedTime().getMonth() + 1) + "/" + (status6.getCreatedTime().getYear() + 1900) + " - " + status6.getCreatedTime().getHours() + ":" + status6.getCreatedTime().getMinutes() + ":" + status6.getCreatedTime().getSeconds() + "<BR>";
                    hint += "<B>Última Atualização: </B> " + (status6.getUpdatedTime().getDate()) + "/" + (status6.getUpdatedTime().getMonth() + 1) + "/" + (status6.getUpdatedTime().getYear() + 1900) + " - " + status6.getUpdatedTime().getHours() + ":" + status6.getUpdatedTime().getMinutes() + ":" + status6.getUpdatedTime().getSeconds() + "<BR>";
                    if (status6.getSharesCount() != null) {
                        hint += "<B>Quantidade de Compartilhamentos: </B>" + status6.getSharesCount() + "<BR>";
                    }

                    hint += "<h3><marquee>Informação referente ao usuário do Usuário</h3>" + "<BR>";
                    hint += "<B>Nome do Usuário: </B>" + status6.getFrom().getName() + "<BR>";;
                    try {
                        if (f.getUser(status6.getFrom().getId()).getUpdatedTime() != null) {
                            hint += "<B>Última Atualização: </B> " + (f.getUser(status6.getFrom().getId()).getUpdatedTime().getDate()) + "/" + (f.getUser(status6.getFrom().getId()).getUpdatedTime().getMonth() + 1) + "/" + (f.getUser(status6.getFrom().getId()).getUpdatedTime().getYear() + 1900) + "<BR>";
                        }
                        if (f.getUser(status6.getFrom().getId()).getGender() != null) {
                            String sexo = f.getUser(status6.getFrom().getId()).getGender();
                            if (sexo.equals("female")) {
                                sexo = "Feminino";
                                hint += "<B>Sexo: </B>" + sexo + "<BR>";
                            } else if (sexo.equals("male")) {
                                sexo = "Masculino";
                                hint += "<B>Sexo: </B>" + sexo + "<BR>";
                            } else {
                                hint += "";
                            }
                        }
                        if (f.getUser(status6.getFrom().getId()).getLocale().getDisplayCountry() != null) {
                            hint += "<B>País: </B>" + f.getUser(status6.getFrom().getId()).getLocale().getDisplayCountry() + "<BR>";
                        }
                        if (f.getUser(status6.getFrom().getId()).getLocale().getDisplayLanguage() != null) {
                            hint += "<B>Língua: </B>" + f.getUser(status6.getFrom().getId()).getLocale().getDisplayLanguage() + "<BR>";
                        }
                        hint += "</HTML>";
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    // JOGA TODO O CONTEUDO DO HINT NO HINT DA FOTO
                    novaFoto.setToolTipText(hint);
                    // APRESENTA O NOME DO USUARIO POSTADO. NO LABEL CRIADO
                    profile = new JLabel();
                    profile.setText(status6.getName());
                    profile.setLocation(0, 0);

                    // CRIA VARIAVEL PARA ARMAZENAR A MENSAGEM DO POST
                    String msg_post = "";
                    // SE TIVER MENSAGEM NO COMENTÁRIO, OU SEJA, QUANDO NÃO FOR UMA FOTO OU VIDEO
                    if (status6.getMessage() != null) {
                        // VERIFICO O TIPO DO POST
                        // SE FOR UM VIDEO OU UM LINK
                        if (status6.getType().equals("video") || status6.getType().equals("link")) {
                            // MOSTRA MENSAGEM:
                            msg_post += "Link: " + status6.getMessage() + "\n";
                        } else {
                            // SENÃO, MOSTRA A MENSAGEM DO COMENTÁRIO
                            msg_post += " " + status6.getMessage();
                        }
                    }
                    // PEGA A DESCRIÇÃO DO POST, SE EXISTIR
                    if (status6.getDescription() != null) {
                        // CONCATENA, NA VARIAVEL A DESCRIÇÃO DO POST
                        msg_post += " " + status6.getDescription();
                    }

                    // CRIA UM TEXTAREA (2 LINHAS, 25 COLUNAS COM A MENSAGEM DO TWEET ENCONTRADO
                    msg = new JTextArea(2, 25);
                    // TRAVA A EDIÇÃO
                    msg.setEditable(false);
                    // OBTEM A MENSAGEM E SETA NO TEXTAREA CRIADO
                    msg.setText(" " + msg_post);
                    // SETA HABILITADO A QUEBRA DE LINHA AUTOMATICA
                    msg.setLineWrap(true);

                    // ADICIONA A FOTO E A MENSAGEM NO PANEL
                    pane.add(novaFoto);
                    pane.add(msg);
                    // ADICIONA O PANEL NO JANEL SECUNDÁRIO
                    jP_Tweets.add(pane);
                }
            }
            // MOSTRA A QUANTIDADE DE POSTS CARREGADOS
            jL_Novos.setText((i6) + " posts carregados");
            // SETA A LOCALIZAÇÃO DA BARRA DE ROLAGEM
            jScrollPane2.getVerticalScrollBar().setValue(0);
        }// EM CASO DE ERRO, MOSTRA O ERRO E A MENSAGEM
        catch (FacebookException ex) {
            ex.printStackTrace();
            System.out.println("ERRO : " + ex.getErrorCode());
            JOptionPane.showMessageDialog(this, "Erro recuperando a busca: " + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btInteragir = new javax.swing.JButton();
        jL_Foto = new javax.swing.JLabel();
        lbResultadoBusca = new javax.swing.JLabel();
        jL_Novos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jP_Tweets = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        lbUsuarioFacebook = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 255));
        setMaximumSize(new java.awt.Dimension(395, 617));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btInteragir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icone_interagir.png"))); // NOI18N
        btInteragir.setText("   Interagir com os Posts");
        btInteragir.setToolTipText("Interagir com os posts encontrados");
        btInteragir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInteragirActionPerformed(evt);
            }
        });
        add(btInteragir, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 584, 210, 34));

        jL_Foto.setBackground(new java.awt.Color(102, 204, 255));
        jL_Foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jL_Foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 43, 48, 48));

        lbResultadoBusca.setText("Palavra-Chave:");
        add(lbResultadoBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 77, -1, -1));
        add(jL_Novos, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 549, 362, 29));

        jScrollPane2.setBackground(new java.awt.Color(0, 153, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados da Busca"));

        jP_Tweets.setBackground(new java.awt.Color(0, 153, 255));
        jP_Tweets.setLayout(new javax.swing.BoxLayout(jP_Tweets, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(jP_Tweets);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 97, 368, 451));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(0, 153, 255));
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        label1.setText("Busca no Facebook");
        add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 368, -1));

        lbUsuarioFacebook.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbUsuarioFacebook.setText("usuarioFacebook");
        add(lbUsuarioFacebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 43, -1, -1));

        jButton1.setText("Resumo da Busca");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 584, 150, 34));
    }// </editor-fold>//GEN-END:initComponents

    // AO CLICAR NO BOTÃO INTERAGIR, CHAMA FUNÇÃO INTERAGE MSG()
    private void btInteragirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInteragirActionPerformed
        interageMsg();
    }//GEN-LAST:event_btInteragirActionPerformed

    // BOTÃO RESUMO DA BUSCA
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // APRESENTA ALGUMAS INFORMAÇÕES GERAIS DA BUSCA REALIZADA
        String mensg = "";
        mensg += "Posts encontrados: " + resultadoBusca6.size();
        mensg += "\nQuantidade de Posts com a Palavra-Chave Pesquisada: " + listaPosts.size();
        JOptionPane.showMessageDialog(null, mensg);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btInteragir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jL_Foto;
    private javax.swing.JLabel jL_Novos;
    private javax.swing.JPanel jP_Tweets;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private javax.swing.JLabel lbResultadoBusca;
    private javax.swing.JLabel lbUsuarioFacebook;
    // End of variables declaration//GEN-END:variables
}
