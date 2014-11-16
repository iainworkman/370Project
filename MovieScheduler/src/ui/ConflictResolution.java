/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.JOptionPane;
import actions.LoadScriptAction;
import businessobjects.Scene;
import businessobjects.SceneFilmingDate;
import businessobjects.Script;

/**
 *
 * @author Mitchell
 */
public class ConflictResolution extends javax.swing.JFrame {

    /**
     * Creates new form ConflictResolution
     */
    public ConflictResolution(Script script) {
        initComponents();
         if (script == null)
        {
            throw new RuntimeException("Cannot add a null Script to a "
                    + "ConflictResolution");
        }
        this.script = script;
        conflictSceneListView = new BusinessObjectListView<>(script.schedule().scheduleConflicts());
        System.out.println(conflictSceneListView);
        conflictSceneScrollPane.setViewportView(conflictSceneListView);
        this.setVisible(true);
        
    }

    ConflictResolution() {
        throw new UnsupportedOperationException("Unsupported without script"); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        conflictSceneScrollPane = new javax.swing.JScrollPane();
        conflictSceneListPane = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        conflictVolunteerLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        conflictConflictLabel = new javax.swing.JLabel();
        conflictEditSceneButton = new javax.swing.JButton();
        conflictIgnoreButton = new javax.swing.JButton();
        conflictContactAllButton = new javax.swing.JButton();
        conflictCancel = new javax.swing.JButton();
        conflictInternalFrame = new javax.swing.JInternalFrame();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setName("conflict"); // NOI18N

        conflictSceneListPane.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "4-3", "1-4", "2-5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        conflictSceneListPane.setName("conflictListSelect"); // NOI18N
        conflictSceneListPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conflictSceneListPaneMouseClicked(evt);
            }
        });
        conflictSceneScrollPane.setViewportView(conflictSceneListPane);

        jLabel1.setText("Scene:");

        conflictVolunteerLabel.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        conflictVolunteerLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        conflictVolunteerLabel.setName("volunteerListLabel"); // NOI18N

        jLabel3.setText("Volunteers/Equipment");

        jLabel4.setText("Conflict:");

        conflictConflictLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        conflictConflictLabel.setName(""); // NOI18N

        conflictEditSceneButton.setText("Edit Scene");
        conflictEditSceneButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conflictEditSceneButtonMouseClicked(evt);
            }
        });

        conflictIgnoreButton.setText("Ignore");
        conflictIgnoreButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conflictIgnoreButtonMouseClicked(evt);
            }
        });

        conflictContactAllButton.setText("Contact All");

        conflictCancel.setText("Cancel");

        conflictInternalFrame.setVisible(false);

        javax.swing.GroupLayout conflictInternalFrameLayout = new javax.swing.GroupLayout(conflictInternalFrame.getContentPane());
        conflictInternalFrame.getContentPane().setLayout(conflictInternalFrameLayout);
        conflictInternalFrameLayout.setHorizontalGroup(
            conflictInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        conflictInternalFrameLayout.setVerticalGroup(
            conflictInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(conflictSceneScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(110, 110, 110)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(conflictVolunteerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(conflictContactAllButton, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(conflictConflictLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(conflictCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(conflictEditSceneButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(conflictIgnoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(conflictInternalFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(conflictSceneScrollPane)
                    .addComponent(conflictVolunteerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(conflictConflictLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conflictEditSceneButton)
                    .addComponent(conflictIgnoreButton)
                    .addComponent(conflictContactAllButton)
                    .addComponent(conflictCancel))
                .addGap(30, 30, 30))
            .addComponent(conflictInternalFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conflictIgnoreButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conflictIgnoreButtonMouseClicked
        int ignoreResult;
        ignoreResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to ignore?",
                "Conflict",
                JOptionPane.YES_NO_OPTION);
        if(ignoreResult == 1){
        }
        else {
            ignoreCurrentConflict();
        }
              
    }//GEN-LAST:event_conflictIgnoreButtonMouseClicked

    private void conflictEditSceneButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conflictEditSceneButtonMouseClicked
       /*
        focus away from window
        Go to scene editing window    
        */
    }//GEN-LAST:event_conflictEditSceneButtonMouseClicked

    private void conflictSceneListPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conflictSceneListPaneMouseClicked
        SceneFilmingDate selectedScene = this.conflictSceneListView.getSelectedValue();
        conflictVolunteerLabel.setText(selectedScene.toString());
    }//GEN-LAST:event_conflictSceneListPaneMouseClicked

    private Boolean ignoreCurrentConflict(){
        //conflictSceneListPane.getSelectedValue().
        return false;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ConflictResolution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConflictResolution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConflictResolution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConflictResolution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConflictResolution().setVisible(true);
            }
        });
    }
    //Private Variables
    private BusinessObjectListView<SceneFilmingDate> conflictSceneListView;
    private Script script;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton conflictCancel;
    private javax.swing.JLabel conflictConflictLabel;
    private javax.swing.JButton conflictContactAllButton;
    private javax.swing.JButton conflictEditSceneButton;
    private javax.swing.JButton conflictIgnoreButton;
    private javax.swing.JInternalFrame conflictInternalFrame;
    private javax.swing.JList conflictSceneListPane;
    private javax.swing.JScrollPane conflictSceneScrollPane;
    private javax.swing.JLabel conflictVolunteerLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
