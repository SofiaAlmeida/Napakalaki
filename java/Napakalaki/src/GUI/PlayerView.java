package GUI;
import NapakalakiGame.CultistPlayer;
import NapakalakiGame.Napakalaki;
import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class PlayerView extends javax.swing.JPanel {
    Player playerModel;
    Napakalaki napakalakiModel;
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
        this.treasureSteal.setVisible(false);
        this.cultist.setVisible(false);
        //No se permite pulsar el botón antes de combatir 
        this.stealTreasure.enableInputMethods(false);
        this.discardAll.enableInputMethods(false);
        this.discardTreasures.enableInputMethods(false);
    }
    
    /**
     * Activa los botones 
     * 
     * Llamar a esta función después de combatir
     * REVIEW: ¿HABRÍA QUE CREAR OTRA PARA DESACTIVARLOS?
     */
    public void enableButtons() {
        this.stealTreasure.enableInputMethods(true);
        this.discardAll.enableInputMethods(true);
        this.discardTreasures.enableInputMethods(true);
    }
    
    /**
     * 
     * Muestra la lista en el panel ambos pasados como parámetro
     * @param aPanel Panel donde mostrar la lista
     * @param aList Lista a mostrar
     */
    private void fillTreasurePanel(JPanel aPanel, ArrayList<Treasure> aList) {
        //Elimina la información anterior
        aPanel.removeAll();
        //Recorremos la lista y añadimos cada una de las vistas para cada tesoro
        for (Treasure t : aList){
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure(t);
            aTreasureView.setVisible(true);
            aPanel.add(aTreasureView);            
        }
        aPanel.repaint();
        aPanel.revalidate();
    }
    
    /**
     * 
     * Modificador de player, actualiza su vista
     * @param aPlayer jugador del que queremos hacer la vista
     */
    public void setPlayer(Player aPlayer) {
        playerModel = aPlayer;
        this.name.setText(playerModel.getName());
        this.level.setText("Nivel: " + playerModel.getLevels());
        this.combatLevel.setText("Nivel de combate: " + playerModel.getCombatLevel());
        this.enemy.setText("Enemigo: " + playerModel.getEnemy().getName());
        fillTreasurePanel(visibleTreasures, playerModel.getVisibleTreasures());
        fillTreasurePanel(hiddenTreasures, playerModel.getHiddenTreasures());
        if (playerModel instanceof CultistPlayer){
            this.cultist.setText("Sectario");
            this.cultist.setVisible(true);
        }
        
        repaint();
        revalidate();
    }
    
    /**
     * 
     * Modificador de napakalakiModel
     * @param aNapakalaki 
     */
    public void setNapakalaki(Napakalaki aNapakalaki) {
        napakalakiModel = aNapakalaki;
    }

    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            if (tv.isSelected())
                output.add(tv.getTreasure());
        }
        
        return output;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        name = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        combatLevel = new javax.swing.JLabel();
        enemy = new javax.swing.JLabel();
        stealTreasure = new javax.swing.JButton();
        makeVisible = new javax.swing.JButton();
        discardTreasures = new javax.swing.JButton();
        discardAll = new javax.swing.JButton();
        cultist = new javax.swing.JLabel();
        treasureSteal = new GUI.TreasureView();
        visibleTreasures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Player", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);

        name.setFont(new java.awt.Font("Khmer OS", 0, 15)); // NOI18N
        name.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        name.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        level.setFont(new java.awt.Font("Khmer OS", 0, 15)); // NOI18N
        level.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        level.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        combatLevel.setFont(new java.awt.Font("Khmer OS", 0, 15)); // NOI18N
        combatLevel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        combatLevel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        enemy.setFont(new java.awt.Font("Khmer OS", 0, 15)); // NOI18N
        enemy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        enemy.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        stealTreasure.setBackground(new java.awt.Color(249, 159, 235));
        stealTreasure.setFont(new java.awt.Font("Khmer OS", 1, 12)); // NOI18N
        stealTreasure.setText("Steal Treasure\n");
        stealTreasure.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        stealTreasure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stealTreasureActionPerformed(evt);
            }
        });

        makeVisible.setBackground(new java.awt.Color(250, 158, 235));
        makeVisible.setFont(new java.awt.Font("Khmer OS", 1, 12)); // NOI18N
        makeVisible.setText("Make Visible");
        makeVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleActionPerformed(evt);
            }
        });

        discardTreasures.setBackground(new java.awt.Color(249, 159, 236));
        discardTreasures.setFont(new java.awt.Font("Khmer OS", 1, 12)); // NOI18N
        discardTreasures.setText("Discard Treasure");
        discardTreasures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardTreasuresActionPerformed(evt);
            }
        });

        discardAll.setBackground(new java.awt.Color(249, 159, 236));
        discardAll.setFont(new java.awt.Font("Khmer OS", 1, 12)); // NOI18N
        discardAll.setText("Discard All Treasures");
        discardAll.setToolTipText("\n");
        discardAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardAllActionPerformed(evt);
            }
        });

        cultist.setFont(new java.awt.Font("Khmer OS", 0, 15)); // NOI18N
        cultist.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        treasureSteal.setBackground(new java.awt.Color(117, 125, 207));

        visibleTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Visible Treasure\n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hidden Treasures\n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stealTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(makeVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(discardTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(discardAll, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combatLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enemy, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cultist, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(treasureSteal, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combatLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enemy, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cultist, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(treasureSteal, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(discardTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(stealTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(discardAll, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(makeVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 
     * Hace visible los tesoros seleccionados por el jugador
     * @param evt 
     */
    private void makeVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        napakalakiModel.makeTreasuresVisible(selHidden);
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_makeVisibleActionPerformed

    /**
     * Roba un tesoro de su enemigo
     * @param evt 
     */
    private void stealTreasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stealTreasureActionPerformed
        Treasure t = playerModel.stealTreasure();
        if (t != null){
            treasureSteal.setTreasure(t); //PROBAAAAAAAAR
            treasureSteal.setVisible(true);
        }
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_stealTreasureActionPerformed

    /**
     * 
     * Descarta los tesoros del jugador seleccionados
     * @param evt 
     */
    private void discardTreasuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardTreasuresActionPerformed
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreasures);
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        
        napakalakiModel.discardVisibleTreasures(selVisible);
        napakalakiModel.discardHiddenTreasures(selHidden);
        
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_discardTreasuresActionPerformed

    /**
     * 
     * Descarta todos los tesoros del jugador
     * @param evt 
     */
    private void discardAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardAllActionPerformed
        playerModel.discardAllTreasures();
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_discardAllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel combatLevel;
    private javax.swing.JLabel cultist;
    private javax.swing.JButton discardAll;
    private javax.swing.JButton discardTreasures;
    private javax.swing.JLabel enemy;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel level;
    private javax.swing.JButton makeVisible;
    private javax.swing.JLabel name;
    private javax.swing.JButton stealTreasure;
    private GUI.TreasureView treasureSteal;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
