// PACOTE
package GUI;

// IMPORTA AS CLASSES
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.User;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Panel_FTimeline extends javax.swing.JPanel {

    // DECLARA AS VARIAVEIS
    private Facebook f;
    private User eu;
    Image foto;
    String urlfoto, urlfoto2;

    // CONSTRUTOR
    public Panel_FTimeline(Facebook f, User eu) throws FacebookException {
        this.f = f;
        this.eu = eu;
        initComponents();
        recuperarDados();
    }

    // FUNÇÃO A QUAL INICIA O PANEL
    private void recuperarDados() throws FacebookException {
        // SETA A URL DA FOTO DO PERFIL DO FACEBOOK DO USUÁRIO LOGADO 
        urlfoto = String.valueOf(f.getPictureURL());

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

        // CARREGA O ÚLTIMO POST
        String ultimo = f.getStatuses().get(0).getMessage();
        jL_Ultimo.setToolTipText(ultimo);
        
        // CORTA O TEXTO DO ULTIMO POST
        if (ultimo.length() > 50) {
            ultimo = ultimo.substring(0, 50) + "...";
        }
        jL_Ultimo.setText(ultimo);

        // CHAMA FUNÇÃO CARREGA TIMELINE
        carregaTimeline();
    }

    // FUNÇÃO RESPONSÁVEL POR CARREGAR OS TWEETS DA TIMELINE
    public void carregaTimeline() {
        try {
            // DECLARA AS VARIAVEIS
            JPanel pane;
            JLabel novaFoto;
            JTextArea msg;
            ResponseList<Post> feed;
            feed = f.getHome();
            // SETA O CONTADOR IGUAL A ZERO
            int i = 0;
            System.out.println(feed.size());
            // REMOVE TODOS OS TWEETS DO PANEL
            jP_Tweets.removeAll();

            // ENQUANTO TIVER POSTS NA LISTA FEED
            for (Post p : feed) {
                // INCREMENTA CONTADOR DE POSTS 
                i++;
                // CRIA PANEL PARA ARMAZENAR OS POSTS, ALINHADO A DIREITA
                pane = new JPanel(new FlowLayout(FlowLayout.LEFT));
                // COLOCA BORDA NO PANEL
                pane.setBorder(new LineBorder(Color.black, 1));
                // SETA UM TAMANHO
                pane.setSize(370, 50);
                // COR DE FUNDO 
                pane.setForeground(Color.yellow);
                //SETA A URL DA FOTO DO PERFIL DO USUARIO QUE POSTOU
                urlfoto2 = f.getPictureURL(p.getFrom().getId()).toString();
                // SETA NO LABEL A URL DA FOTO
                novaFoto = new JLabel();
                novaFoto.setIcon(new javax.swing.JLabel() {
                    public javax.swing.Icon getIcon() {
                        try {
                            return new javax.swing.ImageIcon(
                                    new java.net.URL(urlfoto2)
                            );
                        } catch (java.net.MalformedURLException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                }.getIcon());

                // CRIA TEXTAREA PARA A MENSAGEM DO POST (2 LINHAS, 25 COLUNAS)
                msg = new JTextArea(2, 25);
                // TRAVA A EDIÇÃO
                msg.setEditable(false);
                // SETA O TEXTO DO OBJETO
                msg.setText(p.getMessage());
                // ATIVA QUEBRA DE LINHA
                msg.setLineWrap(true);

                // ADICIONA A FOTO E A MENSAGEM NO PANEL
                pane.add(novaFoto);
                pane.add(msg);
                // SE NÃO EXISTIR MENSAGEM
                if (p.getMessage() == null) {
                    //DECREMENTA CONTADOR DE POST
                    i--;
                } // SENÃO
                else {
                    jP_Tweets.add(pane);
                }
            }
            // MOSTRA A QUANTIDADE DE POSTS CARREGADOS
            jL_Novos.setText(i + " posts carregados");
        } // EM CASO DE ERRO, MOSTRA ERRO
        catch (FacebookException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro recuperando a Feed de Notícias: " + ex.getMessage());
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

        jL_Foto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTA_Status = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jL_Restantes = new javax.swing.JLabel();
        jL_Ultimo = new javax.swing.JLabel();
        jL_Novos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jP_Tweets = new javax.swing.JPanel();
        label1 = new java.awt.Label();

        setBackground(new java.awt.Color(0, 153, 255));
        setMaximumSize(new java.awt.Dimension(398, 610));

        jL_Foto.setBackground(new java.awt.Color(102, 153, 255));
        jL_Foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTA_Status.setBackground(new java.awt.Color(102, 153, 255));
        jTA_Status.setColumns(20);
        jTA_Status.setLineWrap(true);
        jTA_Status.setRows(2);
        jTA_Status.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTA_StatusCaretUpdate(evt);
            }
        });
        jTA_Status.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTA_StatusKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTA_Status);

        jLabel1.setText("Ultimo Post:");

        jL_Restantes.setText("1000");

        jL_Ultimo.setAutoscrolls(true);
        jL_Ultimo.setMaximumSize(new java.awt.Dimension(270, 0));
        jL_Ultimo.setMinimumSize(new java.awt.Dimension(270, 14));

        jScrollPane2.setBackground(new java.awt.Color(102, 153, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ultimos Posts"));

        jP_Tweets.setBackground(new java.awt.Color(0, 153, 255));
        jP_Tweets.setLayout(new javax.swing.BoxLayout(jP_Tweets, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(jP_Tweets);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(0, 153, 255));
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        label1.setText("Facebook");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jL_Ultimo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jL_Restantes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jL_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jL_Novos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jL_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jL_Ultimo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_Restantes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jL_Novos, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // AO MODIFICAR O TEXTAREA DE UM NOVO POST
    private void jTA_StatusCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTA_StatusCaretUpdate
        // CONTADOR É DECREMENTADO A CADA CARACTERE INSERIDO NO TEXTAREA
        jL_Restantes.setText(String.valueOf(1000 - jTA_Status.getText().length()));
    }//GEN-LAST:event_jTA_StatusCaretUpdate

    // AO PRESSIONAR QUALQUER TECLA NO TEXTAREA NOVO TWEET
    private void jTA_StatusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTA_StatusKeyTyped
        // SE A QTDE DE CARACTERES FOR MAIOR OU IGUAL A 1000
        if (jTA_Status.getText().length() >= 1000) {
            // LIMPA ULTIMO CARACTERE DIGITADO
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
        // QUANDO PRESSIONADO ENTER
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            try {
                // SE O NOVO TWEET ESTIVER EM BRANCO
                if (jTA_Status.getText().isEmpty()) {
                    // MOSTRA MENSAGEM
                    JOptionPane.showMessageDialog(null, "Digite algum texto");
                } //SENAO
                else {
                    // SE NOVO TWEET FOR IGUAL AO ULTIMO
                    if (jL_Ultimo.getText().equals(jTA_Status.getText())) {
                        // MOSTRA MENSAGEM E SETA O FOCO E SELECIONA TUDO DO CAMPO NOVO TWEET
                        JOptionPane.showMessageDialog(null, "Post duplicado!\nFavor verifique seu texto");
                        jTA_Status.requestFocus();
                        jTA_Status.selectAll();
                    } //SENAO
                    else {
                        try {
                            // REALIZA A INTERAÇÃO COM O FACEBOOK
                            f.postStatusMessage(jTA_Status.getText());
                            // SETA O CAMPO ULTIMO POST IGUAL AO DIGITADO
                            jL_Ultimo.setText(jTA_Status.getText());
                            // LIMPA O TEXTAREA NOVO POST
                            jTA_Status.setText("");

                            // CARREGA TIMELINE NOVAMENTE
                            //carregaTimeline();
                        } // EM CASO DE ERROS
                        catch (FacebookException e) {
                            // MOSTRA ERRO
                            e.printStackTrace();
                        }
                    }
                }
            } // EM CASO DE ERROS
            catch (Exception ex) {
                // MOSTRA ERRO
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao atualizar o seu status: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jTA_StatusKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jL_Foto;
    private javax.swing.JLabel jL_Novos;
    private javax.swing.JLabel jL_Restantes;
    private javax.swing.JLabel jL_Ultimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jP_Tweets;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTA_Status;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
