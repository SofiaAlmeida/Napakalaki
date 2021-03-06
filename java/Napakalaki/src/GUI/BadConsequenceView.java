package GUI;

import NapakalakiGame.BadConsequence;
import NapakalakiGame.DeathBadConsequence;
import NapakalakiGame.NumericBadConsequence;
import NapakalakiGame.SpecificBadConsequence;
import NapakalakiGame.Treasure;
import NapakalakiGame.TreasureKind;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class BadConsequenceView extends javax.swing.JPanel {
    BadConsequence bcModel;
    
    /**
     * Creates new form BadConsequenceView
     */
    public BadConsequenceView() {
        initComponents();
    }
    
    public void setBadConsequence(BadConsequence bc){
        bcModel = bc;
        this.death.setVisible(false);
        if (bcModel instanceof NumericBadConsequence) {
            // Este caso es el utilizado también para los DeathBadConsequence
            this.visibleTreasures.setText("<html>" + 
                        ((NumericBadConsequence) bcModel).getNVisibleTreasures());
            this.hiddenTreasures.setText("<html>" + 
                        ((NumericBadConsequence) bcModel).getNHiddenTreasures());
        }
        else if (bcModel instanceof SpecificBadConsequence) {
            this.visibleTreasures.setText(
                       ((SpecificBadConsequence) bcModel).getSpecificVisibleTreasures().toString());
            this.hiddenTreasures.setText( 
                       ((SpecificBadConsequence) bcModel).getSpecificHiddenTreasures().toString());
        }
        if (bcModel instanceof DeathBadConsequence) {
            this.death.setVisible(true);
        }
        
        repaint();
    }
      
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        visibleTreasures = new javax.swing.JLabel();
        hiddenTreasures = new javax.swing.JLabel();
        death = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bad Consequence\n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        setMaximumSize(new java.awt.Dimension(336, 204));
        setMinimumSize(new java.awt.Dimension(336, 204));
        setPreferredSize(new java.awt.Dimension(336, 204));
        setLayout(null);

        visibleTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder("Visible Treasures"));
        add(visibleTreasures);
        visibleTreasures.setBounds(17, 29, 300, 54);

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder("Hidden Treasures"));
        add(hiddenTreasures);
        hiddenTreasures.setBounds(17, 133, 304, 52);

        death.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        death.setText("¡¡¡MUERTO!!!");
        death.setMaximumSize(new java.awt.Dimension(8, 21));
        death.setMinimumSize(new java.awt.Dimension(8, 21));
        add(death);
        death.setBounds(17, 89, 300, 32);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel death;
    private javax.swing.JLabel hiddenTreasures;
    private javax.swing.JLabel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
