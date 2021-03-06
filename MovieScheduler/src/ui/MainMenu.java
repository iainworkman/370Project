package ui;

import businessobjects.Equipment;
import businessobjects.Scene;
import businessobjects.Volunteer;
import database.JdbcDatabase;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import moviescheduler.MovieSchedulerController;

/**
 *
 * @author Iain Workman, Ryan La Forge, John Mason, Matthew Galbraith
 */
public class MainMenu extends javax.swing.JFrame {

    private final MovieSchedulerController controller;

    /**
     *
     * @param controller::MovieSchedulerController ~ The controller for the
     * system
     */
    public MainMenu(MovieSchedulerController controller) {
        initComponents();
        this.controller = controller;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        SchedulePanel schedulePanel = new SchedulePanel(controller);
        scheduleTabPanel.add(schedulePanel, BorderLayout.CENTER);

       ResourcePanel resourcePanel = new ResourcePanel(controller);
        resourceTabPanel.add(resourcePanel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        mainPanel = new javax.swing.JPanel();
        mainTab = new javax.swing.JTabbedPane();
        resourceTabPanel = new javax.swing.JPanel();
        scheduleTabPanel = new javax.swing.JPanel();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movie Scheduler");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        mainPanel.setBorder(new javax.swing.border.MatteBorder(null));

        resourceTabPanel.setLayout(new java.awt.BorderLayout());
        mainTab.addTab("Resources", resourceTabPanel);

        scheduleTabPanel.setLayout(new java.awt.BorderLayout());
        mainTab.addTab("Schedule", scheduleTabPanel);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTab)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTab)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(925, 574));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
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


                JOptionPane.showMessageDialog(null, "Could not load main"
                        + " menu.");

            }
        });
    }

    // Private Member Variables
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label label1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JPanel resourceTabPanel;
    private javax.swing.JPanel scheduleTabPanel;
    // End of variables declaration//GEN-END:variables
}
