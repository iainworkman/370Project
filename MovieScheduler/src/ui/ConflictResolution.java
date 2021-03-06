package ui;

import businessobjects.Scene;
import javax.swing.JOptionPane;
import businessobjects.SceneFilmingDate;
import businessobjects.Script;
import businessobjects.Volunteer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

/**
 *
 * @author Mitchell Corbett
 */
public class ConflictResolution extends javax.swing.JFrame {

    /**
     * Creates new form ConflictResolution
     */
    public ConflictResolution(Script script) {
        initComponents();
        if (script == null) {
            throw new RuntimeException("Cannot add a null Script to a "
                    + "ConflictResolution");
        }
        this.script = script;
        refreshScenes();
        this.setVisible(true);
        //adding a mouse listener to load the confilct information
        conflictSceneListView.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int indexUnderPointer
                        = conflictSceneListView.locationToIndex(e.getPoint());

                if (!conflictSceneListView.getCellBounds(indexUnderPointer,
                        indexUnderPointer).contains(e.getPoint())) {
                    conflictSceneListView.clearSelection();
                } else {
                    conflictSceneListView.setSelectedIndex(indexUnderPointer);
                    SceneFilmingDate selectedFilmSceneTime
                            = conflictSceneListView.getSelectedValue();
                    String html1 = "<html><body style='width: ";
                    String html2 = "px'>";
                    String confl = selectedFilmSceneTime.getReasonList().
                            toString();
                    String info = selectedFilmSceneTime.getScene().
                            toDescriptiveString();
                    conflictConflictLabel.setText(html1 + "150" + html2 + confl);
                    conflictVolunteerLabel.setText(html1 + "150" + html2 + info);
                }

                super.mousePressed(e);
            }
        });

    }

    ConflictResolution() {
        throw new UnsupportedOperationException("Unsupported without script"); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * A function to refresh the scroll pane that shows the scenes in conflict
     */
    private void refreshScenes() {
        conflictSceneListView = new BusinessObjectListView<>(script.getSchedule().getScheduleConflicts());
        conflictSceneScrollPane.setViewportView(conflictSceneListView);
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

        conflictSceneListPane.setName("conflictListSelect"); // NOI18N
        conflictSceneListPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conflictSceneListPaneMouseClicked(evt);
            }
        });
        conflictSceneScrollPane.setViewportView(conflictSceneListPane);

        jLabel1.setText("Scene:");

        conflictVolunteerLabel.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        conflictVolunteerLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        conflictVolunteerLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        conflictVolunteerLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        conflictVolunteerLabel.setName("volunteerListLabel"); // NOI18N

        jLabel3.setText("Scene Information:");

        jLabel4.setText("Reason for Conflict:");

        conflictConflictLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        conflictConflictLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
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
        conflictContactAllButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conflictContactAllButtonMouseClicked(evt);
            }
        });
        conflictContactAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conflictContactAllButtonActionPerformed(evt);
            }
        });

        conflictCancel.setText("Cancel");
        conflictCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conflictCancelMouseClicked(evt);
            }
        });

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
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(267, 267, 267)
                            .addComponent(conflictInternalFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGap(17, 17, 17))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(conflictSceneScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(conflictCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(conflictContactAllButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(conflictIgnoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(conflictVolunteerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(40, 40, 40))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(127, 127, 127))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(conflictEditSceneButton)
                            .addComponent(conflictConflictLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(conflictInternalFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(31, 31, 31)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(conflictConflictLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(conflictSceneScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(conflictVolunteerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conflictContactAllButton)
                    .addComponent(conflictEditSceneButton)
                    .addComponent(conflictIgnoreButton)
                    .addComponent(conflictCancel))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conflictIgnoreButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conflictIgnoreButtonMouseClicked
        int ignoreResult;
        ignoreResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to ignore?",
                "Conflict",
                JOptionPane.YES_NO_OPTION);
        if (ignoreResult == 1) {
        } else {
            JOptionPane.showMessageDialog(this, "Ignore executed: " + ignoreCurrentConflict().toString());
            refreshScenes();
        }

    }//GEN-LAST:event_conflictIgnoreButtonMouseClicked

    private void conflictEditSceneButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conflictEditSceneButtonMouseClicked
        this.toBack();
    }//GEN-LAST:event_conflictEditSceneButtonMouseClicked

    private void conflictSceneListPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conflictSceneListPaneMouseClicked
        SceneFilmingDate selectedFilmSceneTime = this.conflictSceneListView.getSelectedValue();
        conflictConflictLabel.setText(selectedFilmSceneTime.getReasonList().toString());
        conflictVolunteerLabel.setText(selectedFilmSceneTime.getScene().toDescriptiveString());
    }//GEN-LAST:event_conflictSceneListPaneMouseClicked

    private void conflictContactAllButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conflictContactAllButtonMouseClicked
        this.sendEmails();
    }//GEN-LAST:event_conflictContactAllButtonMouseClicked

    /**
     * sends e-mails to the volunteers in the selected scene
     *
     * @return a boolean confirming the success of the email
     */
    private boolean sendEmails() {
       if (conflictSceneListView.getSelectedValue() == null)
       {
           JOptionPane.showConfirmDialog(this, "No scene has been selected.");
       }
       else if (!(((Scene) conflictSceneListView.getSelectedValue().getScene()).hasVolunteers())) {
            JOptionPane.showConfirmDialog(this, "This scene has no volunteers associated with it.");
        } else {
            SceneFilmingDate selectedFilmSceneTime = this.conflictSceneListView.getSelectedValue();
            if (selectedFilmSceneTime == null) {
                JOptionPane.showConfirmDialog(this, "Please select a scene!");
                return true;
            }
            Iterator<Volunteer> volunteerIter = selectedFilmSceneTime.getScene().volunteerIterator();

            String emailList = "";
            // Comma separated list of emails for the below code
            while (volunteerIter.hasNext()) {
                Volunteer currentVolunteer = volunteerIter.next();
                emailList = emailList + currentVolunteer.getEmail() + ",";
            }
            System.out.println(emailList);

            /* 
             * The following code is modified for use here from
             * http://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
             */
            final String username = JOptionPane.showInputDialog(this,
                    "Please enter your gmail.");
            final String password = showPasswordDialog();
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(emailList));
                message.setSubject("Filming Conflict");
                String conflictMessage = "Hello team. We are unable to schedule a scene "
                        + "due to scheduling conflicts. Please see the information about "
                        + "the conflict below. \n \n" + selectedFilmSceneTime.getScene().toDescriptiveString()
                        + " And the reason for conflict: "
                        + selectedFilmSceneTime.getReasonList().toString();

                message.setText(conflictMessage);

                Transport.send(message);
                return true;

            } catch (MessagingException e) {
                System.out.println(e.getMessage());
                Object[] options = {"Try again",
                    "Show Emails",
                    "Cancel"};

                int choice = JOptionPane.showOptionDialog(this, "An error has occured "
                        + "in sending your message. What would you like to do?", "Error",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, options, options[2]);
                if (choice == 0) {
                    sendEmails();
                    return true;
                }
                if (choice == 1) {
                    showEmails(emailList);
                    return false;
                }
                //choice == 2 isn't needed since it's defined as the cancel op
            }
        }

        return false;
    }

    /**
     * A function to show the user the list of e-mails so they can copy it.
     *
     * @param emailList
     */
    private void showEmails(String emailList) {
        JOptionPane.showMessageDialog(null, new JTextArea(emailList));
    }

    /**
     * A function to show a dialog to take in the password securely.
     *
     * @return a string containing the password.
     */
    private String showPasswordDialog() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter a password:");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "Password",
                JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        System.out.println(option);
        if (option == 0) // pressing OK button
        {
            char[] cPassword = pass.getPassword();
            String password = new String(cPassword);
            return password;
        }
        if (option == 1)
        {
            this.setVisible(false);
            this.dispose();
        }
        return null;
    }

    private void conflictCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conflictCancelMouseClicked
        this.dispose();
    }//GEN-LAST:event_conflictCancelMouseClicked

    private void conflictContactAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conflictContactAllButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conflictContactAllButtonActionPerformed

    /**
     * a function to set ignore to true in a conflict.
     * @return a boolean describing the success of the ignore
     */
    private Boolean ignoreCurrentConflict() {
        SceneFilmingDate selectedFilmSceneTime = this.conflictSceneListView.getSelectedValue();
        selectedFilmSceneTime.ignoreConflict(true);
        return true;
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
