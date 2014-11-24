package ui;

import actions.SaveEquipmentAction;
import businessobjects.*;
import database.Database;
import database.JdbcDatabase;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author John Mason
 */
public class EquipmentForm extends javax.swing.JFrame {

    BusinessObjectList<TimeInterval> availabilityList = new BusinessObjectList();
    private Database database;
    private Script theScript;
    private Equipment equipmentToEdit;

    @Override
    public void setDefaultCloseOperation(int operation) {
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
    }

    /**
     * Creates new form EquipmentForm
     */
    public EquipmentForm(Script theScript, Database database) {
        this.database = database;
        this.theScript = theScript;
        initComponents();
    }
    
    /**
     * Creates a volunteer form and populates it with previous volunteer info
     */    
    public EquipmentForm(Script theScript, Database database, Equipment equipmentToEdit) {
        this.database = database;
        this.theScript = theScript;
        this.equipmentToEdit = equipmentToEdit;
        initComponents();
        PopulateFormForEdit(equipmentToEdit);
    }

    
    //method to populate the form with previously entered information
    private void PopulateFormForEdit(Equipment equipmentToEdit)
    {
        ownerFirstName.setText(equipmentToEdit.getOwnerFirstName());
        ownerLastName.setText(equipmentToEdit.getOwnerLastName());
        ownerEmail.setText(equipmentToEdit.getOwnerEmail());
        equipmentName.setText(equipmentToEdit.getEquipmentName());
        for (TimeInterval availability: equipmentToEdit.getAvailability())
        {
            currentAvailabilities.addItem(availability);
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

        jLabel1 = new javax.swing.JLabel();
        ownerFirstName = new javax.swing.JTextField();
        ownerLastName = new javax.swing.JTextField();
        ownerEmail = new javax.swing.JTextField();
        equipmentName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        start = new javax.swing.JSpinner();
        end = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        currentAvailabilities = new javax.swing.JComboBox();
        add = new javax.swing.JButton();
        submit = new javax.swing.JToggleButton();
        cancel = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Equipment Signup Sheet");

        ownerFirstName.setText("Owner first name");
        ownerFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownerFirstNameActionPerformed(evt);
            }
        });

        ownerLastName.setText("Owner last name");
        ownerLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownerLastNameActionPerformed(evt);
            }
        });

        ownerEmail.setText("Owner email address");

        equipmentName.setText("Equipment name");

        jLabel2.setText("Equipment Availability");

        jLabel3.setText("Start");

        jLabel4.setText("End");

        start.setModel(new javax.swing.SpinnerDateModel());

        end.setModel(new javax.swing.SpinnerDateModel());

        jLabel5.setText("Current Availabilities");

        add.setText("Add Availability");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ownerFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(equipmentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ownerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ownerLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(add))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(currentAvailabilities, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(submit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ownerFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ownerLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ownerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(equipmentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentAvailabilities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(cancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ownerFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ownerFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ownerFirstNameActionPerformed

    private void ownerLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ownerLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ownerLastNameActionPerformed
    /**
     * add an availability to the equipment <TimeInterval> list
     * @param evt 
     */
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        //display the availability in the drop down box currentavailabilities
        currentAvailabilities.addItem(start.getValue() + " to " + end.getValue());

        //parse the values to date values
        Date sDate, eDate;
        sDate = (Date) start.getValue();
        eDate = (Date) end.getValue();

        //initialize the Gregorian dates
        GregorianCalendar startDate = new GregorianCalendar();
        GregorianCalendar endDate = new GregorianCalendar();

        //give the gregorian calendars the times obtained from the date values obtained from the gui
        startDate.setTime(sDate);
        endDate.setTime(eDate);
        TimeInterval timeInterval = new TimeInterval(startDate, endDate);

        availabilityList.add(timeInterval);
        /* 
          
        
         NOTE: month goes from 0-11 everything else is normal
         constructor:
         public GregorianCalendar(int year,
         int month,
         int dayOfMonth,
         int hourOfDay,
         int minute)

           
         
         */
            }//GEN-LAST:event_addActionPerformed

    /**
     * save the equipment to the database
     * open the main menu back up
     * dispose of the current window
     * @param evt 
     */
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed

        //create a new equipment and populate it with all of the information
        Equipment equipment = new Equipment(equipmentName.getText().toString(),
                ownerFirstName.getText().toString(),
                ownerLastName.getText().toString(),
                ownerEmail.getText().toString(),
                availabilityList);

        //create a query to the database that will send the equipment data there
        SaveEquipmentAction saveEquipmentAction;
        if (equipmentToEdit != null)
        {
            saveEquipmentAction = new SaveEquipmentAction(database, equipment, equipmentToEdit.getEquipmentName());
        }
       else
        {
            saveEquipmentAction = new SaveEquipmentAction(database, equipment);
        }
        saveEquipmentAction.run();

        //check to see if the equipment was successfully added to the database
        //if not give an error message
        if (!saveEquipmentAction.wasSuccessful()) {
            System.out.println("fail" + saveEquipmentAction.lastErrorMessage());
        }

        //add the equipment to the script so it appears in the main menu
        theScript.addEquipment(equipment);
        MainMenu mainMenu;

        mainMenu = new MainMenu(theScript, database);
        mainMenu.setVisible(true);

        this.setVisible(false);
            this.dispose();    }//GEN-LAST:event_submitActionPerformed

    /**
     * exit the current menu and go back to the main menu
     * @param evt 
     */
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        MainMenu mainMenu;

        mainMenu = new MainMenu(theScript, database);
        mainMenu.setVisible(true);

        this.setVisible(false);
        this.dispose();       }//GEN-LAST:event_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(VolunteerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VolunteerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VolunteerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VolunteerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Could not load database driver with "
                            + "message: " + ex.toString());
                    return;
                }

                JdbcDatabase testDatabase = null;
                try {
                    testDatabase = new JdbcDatabase(
                            "jdbc:postgresql://edjo.usask.ca/cmpt370_group06",
                            "cmpt370_group06",
                            "Raptorjesusisawesome55775");
                } catch (SQLException ex) {
                    System.out.println("Failed to connection to db with message: "
                            + ex.getMessage());
                    return;
                }
                //new EquipmentForm(theScript, database).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JToggleButton cancel;
    private javax.swing.JComboBox currentAvailabilities;
    private javax.swing.JSpinner end;
    private javax.swing.JTextField equipmentName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField ownerEmail;
    private javax.swing.JTextField ownerFirstName;
    private javax.swing.JTextField ownerLastName;
    private javax.swing.JSpinner start;
    private javax.swing.JToggleButton submit;
    // End of variables declaration//GEN-END:variables
}
