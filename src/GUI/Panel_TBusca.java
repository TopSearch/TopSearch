// PACOTE
package GUI;

// IMPORTA AS CLASSES
import Beans.MensagemDAO;
import Model.Funcoes;
import Model.Mensagem;
import Model.Usuario;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

public class Panel_TBusca extends javax.swing.JPanel {

    // DECLARA AS VARIAVEIS 
    private Twitter t;
    private User eu;
    private String palavra_chave;
    private Usuario usuarioLogado;
    private Image foto;
    private String urlfoto, urlfoto2;
    private JPanel pane;
    private JLabel novaFoto;
    private JTextArea msg;
    private JLabel profile;
    private Status status;
    private String s1 = "", s2 = "", s3 = "", temp = "";
    private int i = 0, qtd_favorites_user = 0, qtd_friends = 0, qtd_follow = 0, qtd_retweets = 0, qtd_view = 0, qtd_favorites_tweet = 0;
    private QueryResult resultadoBusca = null;
    private List<Status> listaTweets;
    private Query query;
    private Iterator<Status> itTweets;
    private Integer qtdTw;

    // CONSTRUTOR
    public Panel_TBusca(Twitter t, User eu, String palavra_chave, Usuario usuarioLogado, String s1, String s2, String s3) {
        this.t = t;
        this.eu = eu;
        this.palavra_chave = palavra_chave;
        this.usuarioLogado = usuarioLogado;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.qtdTw = 0;
        initComponents();
        recuperarDados();
    }

    // FUNÇÃO A QUAL INICIA A TELA PRINCIPAL
    public void recuperarDados() {
        // SETA A URL DA FOTO DO PERFIL DO TWITTER DO USUÁRIO LOGADO 
        urlfoto = String.valueOf(this.eu.getProfileImageURL().toString());
        // SETA NO LABEL A URL DA FOTO
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
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja interagir com os tweets encontrados?");
            // SE FOR SIM
            if (resposta == JOptionPane.YES_OPTION) {
                // OBTEM A LISTA DE RESULTADOS
                listaTweets = resultadoBusca.getTweets();
                // OBTEM A LISTA DE RESULTADOS CRIANDO UMA LISTA DO TIPO ITERATOR
                itTweets = listaTweets.iterator();
                // ZERA O CONTADOR DE TWEETS.
                i = 0;
                qtd_favorites_user = 0;
                qtd_friends = 0;
                qtd_follow = 0;
                qtd_retweets = 0;
                qtd_view = 0;
                qtd_favorites_tweet = 0;

                // ENQUANTO EXISTIR OBJETOS NA LISTA
                while (itTweets.hasNext()) {
                    // INCREMENTA CONTADOR
                    i++;
                    // O OBJETO STATUS (TWEET) OBTEM UM DOS OBJETOS DA LISTA
                    status = (Status) itTweets.next();

                    // É GERADO UMA VARIAVEL RANDOMICA, O QUAL CONTA DE 0 A 4 (CINCO)
                    // E FICA RESPONSÁVEL EM SORTEAR UMA DAS CINCO MENSAGENS CADASTRADAS
                    Random gerador = new Random();
                    // GERA O NUMERO RANDOMICO
                    int j = gerador.nextInt(4);
                    // VARIAVEL PARA OBTER A MENSAGEM SORTEADA
                    String interacao;
                    // OBJETO O QUAL É RESPONSÁVEL EM REALIZAR UM TWEET OU RETWEET
                    StatusUpdate st = new StatusUpdate(null);
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
                    }// SENÃO
                    else {
                        // OBTEM A QUINTA MENSAGEM
                        interacao = msg2.getMensagem5();
                    }
                    // RETWEETA OU TWEET SE REFERENCIANDO O USUARIO DO POST ORIGINAL, ATRAVÉS DA TAG @
                    st = new StatusUpdate("@" + status.getUser().getScreenName() + " " + interacao);
                    // EXECUTA A RESPOSTA
                    st.inReplyToStatusId(status.getId());
                    // EM CASO DE SUCESSO
                    try {
                        t.updateStatus(st);
                        // CHAMA O MÉTODO UPDATE STATUS QUE EFETIVA A INTERAÇÃO
                        // PRINTA NO CONSOLE (DEBUG) PARA VERIFICAR OS IDS DO TWEET
                        System.out.println(status.getId());
                        System.out.println(status.getInReplyToStatusId());
                        System.out.println(status.getInReplyToUserId());
                        System.out.println(status.getUser());
                    } // EM CASO DE ERRO
                    catch (TwitterException ex) {
                        // O ERRO 403, INDICA QUE O POST JÁ FOI REALIZADO A INTERAÇÃO COM AQUELA MENSAGEM
                        if (ex.getStatusCode() == 403) {
                            JOptionPane.showMessageDialog(null, "Mensagem " + i + " - Interação Executada Anteriormente");
                        }
                        ex.printStackTrace();
                    }
                }
            }
        }// SE NÃO ESTIVER HABILITADO A INTERAÇÃO, APRESENTA A MENSAGEM
        else {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a Interação Automática,\npois ela se encontra Desativada. Favor verifique!", "Interação Automática Desativada", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // RESPONSÁVEL POR OBTER AS MENSAGENS RESULTANTES DA BUSCA REALIZADA
    public void carregaTimeline() {
        try {
            // SETA O CONTADOR IGUAL A ZERO
            i = 0;
            // REMOVE TODOS OS TWEETS DO PANEL
            jP_Tweets.removeAll();

            // EXECUTA A BUSCA PASSANDO A PALAVRA CHAVE DIGITADA
            query = new Query(palavra_chave);
            // EM CASO DE REALIZAR UMA BUSCA AVANÇADA, E O PARÂMETRO LINGUA FOR DIFERENTE DE ZERO
            if (!s1.equals("")) {
                query.setLang(s1);
            }
            // EM CASO DE REALIZAR UMA BUSCA AVANÇADA, E O PARÂMETRO DESDE FOR DIFERENTE DE ZERO
            if (!s2.equals("")) {
                temp = s2.substring(6, 10) + "-" + s2.substring(3, 5) + "-" + s2.substring(0, 2);
                query.setSince(temp);
            }
            // EM CASO DE REALIZAR UMA BUSCA AVANÇADA, E O PARÂMETRO QUANTIDADE FOR DIFERENTE DE ZERO
            if (!s3.equals("")) {
                query.setCount(Integer.parseInt(s3));
            } else {
                // SENÃO, SETA O PADRÃO FIXO DE 50 POSTS À SEREM ENCONTRADOS.
                query.setCount(25);
            }
            // MOSTRA O NOME DO USUARIO LOGADO NO PERFIL DO TWITTER E O NICK DO TWITTER.
            lbUsuarioTwitter.setText(eu.getName() + " - @" + eu.getScreenName());
            // MOSTRA A PALAVRA CHAVE DIGITADA ANTERIORMENTE
            lbResultadoBusca.setText("Palavra-chave: \"" + palavra_chave + "\"");

            // OBTEM OS RESULTADOS DA BUSCA
            resultadoBusca = t.search(query);
            // OBTEM A LISTA DE RESULTADOS
            listaTweets = resultadoBusca.getTweets();
            // OBTEM A LISTA DE RESULTADOS CRIANDO UMA LISTA DO TIPO ITERATOR
            itTweets = listaTweets.iterator();
            // QUANDO NÃO POSSUI NENHUM RESULTADO
            if (!itTweets.hasNext()) {
                // APRESENTA A MENSAGEM
                JOptionPane.showMessageDialog(null, "TWITTER: Nenhum resultado foi obtido\ncom o(s) critério(s) definido(s).", "Nenhum resultado", JOptionPane.ERROR_MESSAGE);
                // REMOVE OS TWEETS ANTERIORES
                jP_Tweets.removeAll();
            }
            // ENQUANTO EXISTIR OBJETOS NA LISTA
            while (itTweets.hasNext()) {
                // INCREMENTA CONTADOR DE TWEETS
                i++;
                // PEGA O PROXIMO TWEET (STATUS)
                status = (Status) itTweets.next();

                // CRIA UM PANEL
                pane = new JPanel(new FlowLayout(FlowLayout.LEFT));
                // CRIA SETA LINHA PARA O PANEL
                pane.setBorder(new LineBorder(Color.black, 1));
                // SETA O TAMANHO DO PANEL
                pane.setSize(370, 100);

                // OBTEM A URL DA FOTO DO PERFIL DO TWITTER
                urlfoto2 = String.valueOf(status.getUser().getProfileImageURL().toString());
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

                // CAMPO RESPONSÁVEL POR APRESENTAR AS INFORMAÇÕES AO PASSAR O MOUSE NA IMAGEM DO USUARIO DO TWEET
                String hint = "<HTML>";
                hint += "<h3><marquee>Informação referente este Post</h3>" + "<BR>";
                qtd_view += status.getUser().getListedCount() + 1;
                hint += "<B>Quantidade de visualizações deste Post: </B>" + status.getUser().getListedCount() + 1 + "<BR>";
                qtd_favorites_tweet += status.getFavoriteCount();
                hint += "<B>Quantidade de favoritos deste Post: </B>" + status.getFavoriteCount() + "<BR>";
                if (status.getRetweetedStatus() != null) {
                    qtd_retweets += status.getRetweetCount();
                    hint += "<B>Quantidade de Retweets: </B>" + status.getRetweetCount() + "<BR>";
                    hint += "<B>- Nome do usuário Post principal: </B>" + status.getRetweetedStatus().getUser().getName() + "- @" + status.getRetweetedStatus().getUser().getScreenName() + "<BR>";
                    hint += "<B>- Post principal criado em: </B> " + (status.getRetweetedStatus().getCreatedAt().getDay() + 1) + "/" + (status.getRetweetedStatus().getCreatedAt().getMonth() + 1) + "/" + (1900 + status.getRetweetedStatus().getCreatedAt().getYear()) + " " + status.getRetweetedStatus().getCreatedAt().getHours() + ":" + status.getRetweetedStatus().getCreatedAt().getMinutes() + ":" + status.getRetweetedStatus().getCreatedAt().getSeconds() + "<BR>";
                } else {
                    hint += "<B>Post sem Retweets </B><BR />";
                }

                hint += "<h3><marquee>Informação referente ao usuário do Tweet</h3>" + "<BR>";
                hint += "<B>Nome do usuário: </B>" + status.getUser().getName() + " - @" + status.getUser().getScreenName() + "<BR>";
                hint += "<B>Usuário do Twitter deste: </B> " + (status.getUser().getCreatedAt().getDay() + 1) + "/" + (status.getUser().getCreatedAt().getMonth() + 1) + "/" + (1900 + status.getUser().getCreatedAt().getYear()) + "<BR>";
                qtd_follow += status.getUser().getFollowersCount();
                hint += "<B>Quantidade de seguidores: </B>" + status.getUser().getFollowersCount() + "<BR>";
                qtd_friends += status.getUser().getFriendsCount();
                hint += "<B>Quantidade de amigos: </B>" + status.getUser().getFriendsCount() + "<BR>";
                qtd_favorites_user += status.getUser().getFavouritesCount();
                hint += "<B>Quantidade de favoritos: </B>" + status.getUser().getFavouritesCount() + "<BR>";

                if (status.getUser().getLang() != null) {
                    Funcoes f1 = new Funcoes();

                    hint += "<B>Língua do usuário: </B>" + f1.verificaLingua(status.getUser().getLang()) + "<BR>";
                } else {
                    hint += "<B>Sem Língua definida pelo usuário</B><BR />";
                }
                if (!status.getUser().getLocation().isEmpty()) {
                    hint += "<B>Localização: </B>" + status.getUser().getLocation() + "<BR>";
                } else {
                    hint += "<B>Localização não disponível</B><BR />";
                }
                String retweet = "";
                if (status.isRetweetedByMe()) {
                    retweet = "<font color=\"Green\">SIM</font>";
                } else {
                    retweet = "<font color=\"Red\">NÃO</font>";
                }
                hint += "<B>Já <I>retweetei: </I></B>" + retweet;
                hint += "</HTML>";

                // JOGA TODO O CONTEUDO DO HINT NO HINT DA FOTO
                novaFoto.setToolTipText(hint);
                // APRESENTA O NOME DO USUARIO POSTADO. NO LABEL CRIADO
                profile = new JLabel();
                profile.setText(status.getUser().getName());
                // SETA A LOCALIZAÇÃO DO LABEL
                profile.setLocation(0, 0);

                // CRIA UM TEXTAREA (2 LINHAS, 25 COLUNAS COM A MENSAGEM DO TWEET ENCONTRADO
                msg = new JTextArea(2, 25);
                // TRAVA A EDIÇÃO
                msg.setEditable(false);
                // OBTEM A MENSAGEM DO STATUS E SETA NO TEXTAREA CRIADO
                msg.setText(status.getCreatedAt().getDate() + "/" + (status.getCreatedAt().getMonth() + 1) + "/" + (status.getCreatedAt().getYear() + 1900) + " - " + status.getCreatedAt().getHours() + ":" + status.getCreatedAt().getMinutes() + ":" + status.getCreatedAt().getSeconds() + " " + status.getText());
                // SETA HABILITADO A QUEBRA DE LINHA AUTOMATICA
                msg.setLineWrap(true);
                // ADICIONA A FOTO E A MENSAGEM NO PANEL
                pane.add(novaFoto);
                pane.add(msg);
                // ADICIONA O PANEL NO JANEL SECUNDÁRIO
                jP_Tweets.add(pane);

            }
            // MOSTRA A QUANTIDADE DE TWEETS CARREGADOS
            jL_Novos.setText(i + " tweets carregados");
            // SETA A LOCALIZAÇÃO DA BARRA DE ROLAGEM
            jScrollPane2.getVerticalScrollBar().setValue(0);
        } // EM CASO DE ERRO
        catch (TwitterException ex) {
            // APRESENTA A MENSAGEM
            JOptionPane.showMessageDialog(this, "Erro recuperando a busca: " + ex.getMessage());
            ex.printStackTrace();
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
        lbUsuarioTwitter = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 204, 255));
        setMaximumSize(new java.awt.Dimension(395, 617));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btInteragir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icone_interagir.png"))); // NOI18N
        btInteragir.setText("   Interagir com os Tweets");
        btInteragir.setToolTipText("Interagir com os tweets encontrados");
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

        jScrollPane2.setBackground(new java.awt.Color(0, 204, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados da Busca"));

        jP_Tweets.setBackground(new java.awt.Color(0, 204, 255));
        jP_Tweets.setLayout(new javax.swing.BoxLayout(jP_Tweets, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(jP_Tweets);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 97, 368, 451));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        label1.setText("Busca no Twitter");
        add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 368, -1));

        lbUsuarioTwitter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbUsuarioTwitter.setText("usuarioTwitter");
        add(lbUsuarioTwitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 43, -1, -1));

        jButton1.setText("Resumo da Busca");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 584, 150, 34));
    }// </editor-fold>//GEN-END:initComponents

    private void btInteragirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInteragirActionPerformed
        interageMsg();
    }//GEN-LAST:event_btInteragirActionPerformed
// BOTÃO RESUMO DA BUSCA
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // APRESENTA ALGUMAS INFORMAÇÕES GERAIS DA BUSCA REALIZADA
        String mensg = "";
        mensg += "Posts encontrados: " + listaTweets.size();
        if (qtd_retweets != 0) {
            mensg += "\nQuantidade Total de Retweets: " + qtd_retweets;
        }
        if (qtd_favorites_tweet != 0) {
            mensg += "\nQuantidade de Favoritos dos Tweets: " + qtd_favorites_tweet;
        }
        if (qtd_view != 0) {
            mensg += "\nQuantidade de Visualizações dos Tweets: " + qtd_view;
        }
        if (qtd_follow != 0) {
            mensg += "\nQuantidade de Seguidores dos Usuários: " + qtd_follow;
        }
        if (qtd_friends != 0) {
            mensg += "\nQuantidade de Amigos dos Usuários: " + qtd_friends;
        }
        if (qtd_favorites_user != 0) {
            mensg += "\nQuantidade de Favoritos dos Usuários: " + qtd_favorites_user;
        }

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
    private javax.swing.JLabel lbUsuarioTwitter;
    // End of variables declaration//GEN-END:variables
}
