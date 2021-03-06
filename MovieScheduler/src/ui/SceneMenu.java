package ui;

import businessobjects.BusinessObjectList;
import businessobjects.Equipment;
import businessobjects.Scene;
import businessobjects.Volunteer;
import java.awt.Dimension;
import moviescheduler.MovieSchedulerController;


/*
 * This class is the window that is presented to the user when eh or she wishes to add or edit a scene.
 @author Ryan La Forge
 */
public class SceneMenu extends javax.swing.JDialog {

    private final Scene clonedScene;
    private final Scene originalScene;
    private MovieSchedulerController controller;
    BusinessObjectList<Volunteer> currentVolunteerList;
    BusinessObjectList<Equipment> currentEquipmentList;
    BusinessObjectList<Volunteer> availableVolunteerList;
    BusinessObjectList<Equipment> availableEquipmentList;
    // Variables declaration - do not modify                     
    private final BusinessObjectListView availableEquipment;
    private javax.swing.JButton availableToCurrentEquipmentButton;
    private javax.swing.JButton availableToCurrentVolunteerButton;
    private final BusinessObjectListView availableVolunteers;
    private javax.swing.JButton cancelButton;
    private final BusinessObjectListView currentEquipment;
    private javax.swing.JButton currentToAvailableEquipment;
    private javax.swing.JButton currentToAvailableVolunteerButton;
    private final BusinessObjectListView currentVolunteers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveSceneButton;
    private javax.swing.JTextPane sceneDescriptionField;
    private javax.swing.JTextField sceneNameField;
    // End of variables declaration                

    /**
     * Creates new form SceneMenu
     * @param originalScene the original scene from which the sceneToEdit was derived.
     * @param sceneToEdit the scene to edit in which the scene was derived.
     * @param controller the controller for this application
     * @author Ryan La Forge
     */
    public SceneMenu(Scene originalScene, Scene sceneToEdit, MovieSchedulerController controller) {
        this.setModal(true);
        if (sceneToEdit == null)
        {
            this.clonedScene = originalScene;
            this.originalScene = null;
        }
        else
        {
           this.originalScene = originalScene;
           this.clonedScene = sceneToEdit; 
        }
        
        this.controller = controller;
        currentVolunteerList = new BusinessObjectList<Volunteer>();
        currentVolunteerList.addAll(clonedScene.getVolunteers());

        currentEquipmentList = new BusinessObjectList<Equipment>();
        currentEquipmentList.addAll(clonedScene.getEquipment());

        availableVolunteerList = new BusinessObjectList<Volunteer>();
        availableVolunteerList.addAll(controller.getVolunteers());
        availableEquipmentList = new BusinessObjectList<Equipment>();
        availableEquipmentList.addAll(controller.getEquipment());

        availableVolunteers = new BusinessObjectListView(availableVolunteerList);
        //NOTE ALSO THAT THIS NAME MUST CHANGE WHEN DECLARED ELSEWHERE FROM DEFAULT

        currentVolunteers = new BusinessObjectListView(currentVolunteerList);

        availableEquipment = new BusinessObjectListView(availableEquipmentList);

        currentEquipment = new BusinessObjectListView(currentEquipmentList);
        initComponents();
        
        jScrollPane1.setPreferredSize(new Dimension(150, 150));
        jScrollPane2.setPreferredSize(new Dimension(150, 150));
        jScrollPane3.setPreferredSize(new Dimension(150, 150));
        jScrollPane4.setPreferredSize(new Dimension(150, 150));
        /**
        currentEquipment.setPreferredSize(new Dimension(150, 150));
        currentVolunteers.setPreferredSize(new Dimension(150, 150));
        availableEquipment.setPreferredSize(new Dimension(150, 150));
        availableVolunteers.setPreferredSize(new Dimension(150, 150));
**/
        //Make all of the lists proper
        //That is, make sure the current lists have all of the volunteers and equipment currently in the scene
        //and ensure the available equipment and volunteer lists only have ones not listed in the scenes list.
        if (clonedScene != null) {
            sceneNameField.setText(clonedScene.getName());
            sceneDescriptionField.setText(clonedScene.getDescription());

            availableVolunteerList.removeAll(clonedScene.getVolunteers());

            availableEquipmentList.removeAll(clonedScene.getEquipment());
        }
        saveSceneButton.setText("Submit");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        currentToAvailableEquipment = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        currentToAvailableVolunteerButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        availableToCurrentEquipmentButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sceneNameField = new javax.swing.JTextField();
        saveSceneButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        cancelButton = new javax.swing.JButton();
        availableToCurrentVolunteerButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        sceneDescriptionField = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        currentToAvailableEquipment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Alarm-Arrow-Left-icon.png"))); // NOI18N
        currentToAvailableEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentToAvailableEquipmentActionPerformed(evt);
            }
        });

        jLabel3.setText("volunteers in scene");

        currentToAvailableVolunteerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Alarm-Arrow-Left-icon.png"))); // NOI18N
        currentToAvailableVolunteerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentToAvailableVolunteerButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("equipment not in scene");

        availableToCurrentEquipmentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Alarm-Arrow-Right-icon.png"))); // NOI18N
        availableToCurrentEquipmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableToCurrentEquipmentButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("equipment in scene");

        jLabel1.setText("Scene Name:");

        jLabel6.setText("Scene Description");

        sceneNameField.setText("jTextField1");

        saveSceneButton.setText("savescene");
        saveSceneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSceneButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Refresh");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(availableVolunteers);

        jScrollPane2.setViewportView(availableEquipment);

        jScrollPane3.setViewportView(currentEquipment);

        jScrollPane4.setViewportView(currentVolunteers);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        availableToCurrentVolunteerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Alarm-Arrow-Right-icon.png"))); // NOI18N
        availableToCurrentVolunteerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableToCurrentVolunteerButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("volunteers not in scene");

        jScrollPane6.setViewportView(sceneDescriptionField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28))
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel1)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(sceneNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(21, 21, 21)
                                                        .addComponent(cancelButton)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(resetButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(saveSceneButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane1)
                                                        .addComponent(jScrollPane2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(currentToAvailableVolunteerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(availableToCurrentVolunteerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jScrollPane4)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(currentToAvailableEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(availableToCurrentEquipmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jScrollPane3))))))
                                .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(currentToAvailableVolunteerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(availableToCurrentVolunteerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(currentToAvailableEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(availableToCurrentEquipmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(35, 35, 35))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1)
                                                .addComponent(sceneNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(saveSceneButton)
                                .addComponent(resetButton)
                                .addComponent(cancelButton))
                        .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    /**
     * The action that happens when the save button is pressed.
     *
     * @postcon if the scene is valid, it is saved to the database and inserted
     * into the script.
     * @param evt
     */
    private void saveSceneButtonActionPerformed(java.awt.event.ActionEvent evt) {
        clonedScene.setName(sceneNameField.getText());
        clonedScene.setDescription(sceneDescriptionField.getText());
        clonedScene.getVolunteers().clear();
        clonedScene.getEquipment().clear();
        clonedScene.getVolunteers().addAll(currentVolunteerList);
        clonedScene.getEquipment().addAll(currentEquipmentList);

       controller.saveBusinessObject(clonedScene, originalScene);
       this.dispose();
    }

    /**
     * This button is used to switch the volunteers between the two lists.
     *
     * @postcon the selected volunteers are moved to the appropriate list.*
     */
    private void currentToAvailableVolunteerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (!currentVolunteers.isSelectionEmpty()) {
            availableVolunteerList.addAll(currentVolunteers.getSelectedValuesList());

            currentVolunteerList.removeAll(currentVolunteers.getSelectedValuesList());

        }

    }

    /**
     * This button is used to switch the volunteers between the two lists.
     *
     * @postcon the selected volunteers are moved to the appropriate list.*
     */
    private void availableToCurrentVolunteerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (!availableVolunteers.isSelectionEmpty()) {
            currentVolunteerList.addAll(availableVolunteers.getSelectedValuesList());

            availableVolunteerList.removeAll(availableVolunteers.getSelectedValuesList());

        }
    }

    /**
     * This button is used to switch the equipment between the two lists.
     *
     * @postcon the selected equipment are moved to the appropriate list.*
     */
    private void currentToAvailableEquipmentActionPerformed(java.awt.event.ActionEvent evt) {
        if (!currentEquipment.isSelectionEmpty()) {
            availableEquipmentList.addAll(currentEquipment.getSelectedValuesList());

            currentEquipmentList.removeAll(currentEquipment.getSelectedValuesList());

        }

    }

    /**
     * This button is used to switch the equipment between the two lists.
     *
     * @postcon the selected equipment are moved to the appropriate list.*
     */
    private void availableToCurrentEquipmentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (!availableEquipment.isSelectionEmpty()) {
            currentEquipmentList.addAll(availableEquipment.getSelectedValuesList());

            availableEquipmentList.removeAll(availableEquipment.getSelectedValuesList());

        }
    }

    /**
     * Cancels all changes and exists the form. The scene is not saved.*
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        this.setVisible(false);
        this.dispose();
    }

    /**
     * Refreshes the frame allowing the user to see the original, unchanged
     * scene status.
     *
     * @param evt
     */
    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //May replace later with a more effecient way of doing this.
        SceneMenu newSceneMenu;
        this.setVisible(false);
        newSceneMenu = new SceneMenu(originalScene, clonedScene, controller);
        newSceneMenu.setVisible(true);
        this.dispose();

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
            java.util.logging.Logger.getLogger(SceneMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SceneMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SceneMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SceneMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                //SceneMenu dialog = new SceneMenu(new javax.swing.JFrame(), null, null, null);
               // dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                  //  @Override
                  //  public void windowClosing(java.awt.event.WindowEvent e) {
                      //  System.exit(0);
                    //}
                //});
               // dialog.setVisible(true);

            }
        });
    }
}
