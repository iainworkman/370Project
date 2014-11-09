/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import businessobjects.Script;
import businessobjects.Volunteer;
import businessobjects.Scene;
import database.Database;
import database.JdbcDatabase;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
/**
 *
 * @author iain
 */
public class MainMenu extends javax.swing.JFrame{
    private final Script theScript;
    private final Database database;
    private final BusinessObjectListView<Scene> sceneListView;
    /**
     * 
     * @param theScript the script currently in use by the system. 
     * @throws SQLException 
     */
    public MainMenu(Script theScript, Database database) throws SQLException {
        initComponents();
        this.database = database;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.theScript = theScript;
        this.setMaximumSize(new Dimension(1000,600));
        this.setMinimumSize(new Dimension(1000,600));
        
        
     //   theScript.addVolunteer(new Volunteer("kyle", "west", "raeagaeg", "phonenumber"));
         volunteerComboBox.removeAllItems();
        if (theScript.hasVolunteers())
        {
           
            Iterator<Volunteer> iter = theScript.volunteerIterator();
            while (iter.hasNext())
            {
                volunteerComboBox.addItem(iter.next());
            }
            
        }
        else
        {
            String noVolunteers;
            noVolunteers = "No volunteers currently in script";
            volunteerComboBox.addItem(noVolunteers);
        }
        /*
         * Add some test scenes to the script. Needs to be removed as soon
         * as there a proper scene loading structure has been implemented
         */
        theScript.scenes().add(new Scene("Test1name", "Test1desc"));
        theScript.scenes().add(new Scene("Test2name", "Test2desc"));
        theScript.scenes().add(new Scene("Test3name", "Test3desc"));
        
        sceneListView = new BusinessObjectListView<>(theScript.scenes());
        sceneListScrollPane.setViewportView(sceneListView);
        
        JPopupMenu sceneListViewPopupMenu = new JPopupMenu();
        JMenuItem scheduleSceneMenuItem = new JMenuItem("Schedule Scene...");
        
        sceneListView.addMouseListener( new MouseAdapter()
        {
                public void mousePressed(MouseEvent e)
                {
                        if ( SwingUtilities.isRightMouseButton(e) )
                        {
                            System.out.println("Pointer at (" + e.getPoint().x + ", " + e.getPoint().y + ")");
                            int indexUnderPointer =
                                    sceneListView.locationToIndex(e.getPoint());
                            System.out.println("Selected index is " + indexUnderPointer);                            
                            if(sceneListView.getCellBounds(indexUnderPointer, 
                                    indexUnderPointer).contains(e.getPoint()))
                            {
                                sceneListView.clearSelection();                                
                            }
                            else
                            {
                                sceneListView.setSelectedIndex(indexUnderPointer);

                                sceneListViewPopupMenu.show(
                                        sceneListView, e.getX() , e.getY());
                            }
                        }
                        super.mousePressed(e);
                }
        });
        scheduleSceneMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                // Stub for user clicking "Schedule Scene..." in context menu
            }
        });
        sceneListViewPopupMenu.add(scheduleSceneMenuItem);
        //sceneListView.setComponentPopupMenu(sceneListViewPopupMenu);
        
        sceneListViewPopupMenu.addPopupMenuListener(new PopupMenuListener(){
            public void popupMenuCanceled(PopupMenuEvent e)
            {
                //No action taken when menu is canceled
            }
            
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
            {
                //No action taken before menu becomes invisible
            }
            
            public void popupMenuWillBecomeVisible(PopupMenuEvent e)
            {
                Scene selectedScene = sceneListView.getSelectedValue();
                if(selectedScene == null)
                    return;
                           
                scheduleSceneMenuItem.setText("Schedule " + 
                        sceneListView.getSelectedValue().toString());
            }
        });
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
        scriptTabPanel = new javax.swing.JPanel();
        scriptContentPanel = new javax.swing.JPanel();
        volunteerPanel = new javax.swing.JPanel();
        volunteerSectionLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        volunteerFirstNameField = new javax.swing.JTextField();
        volunteerLastNameField = new javax.swing.JTextField();
        volunteerPhoneNumberField = new javax.swing.JTextField();
        volunteerEmailField = new javax.swing.JTextField();
        viewAvailabilitiesButton = new javax.swing.JButton();
        addVolunteerButton = new javax.swing.JButton();
        editVolunteerButton = new javax.swing.JButton();
        removeVolunteerButton = new javax.swing.JButton();
        volunteerComboBox = new javax.swing.JComboBox();
        equipmentPanel = new javax.swing.JPanel();
        equipmentSectionLabel = new javax.swing.JLabel();
        equipmentTypeLabel = new javax.swing.JLabel();
        stockLabel = new javax.swing.JLabel();
        equipmentViewAdditionalInformationButton = new javax.swing.JButton();
        equipmentIsRentalCheckbox = new javax.swing.JCheckBox();
        equipmentComboBox = new javax.swing.JComboBox();
        addEquipmentButton = new javax.swing.JButton();
        editEquipmentButton = new javax.swing.JButton();
        removeEquipmentButton = new javax.swing.JButton();
        equipmentTypeField = new javax.swing.JTextField();
        equipmentStockField = new javax.swing.JTextField();
        scenePanel = new javax.swing.JPanel();
        sceneNameLabel = new javax.swing.JLabel();
        sceneDescriptionLabel = new javax.swing.JLabel();
        sceneDescriptionScrollPane = new javax.swing.JScrollPane();
        sceneDescriptionField = new javax.swing.JTextArea();
        sceneComboBox = new javax.swing.JComboBox();
        sceneIsScheduledCheckBox = new javax.swing.JCheckBox();
        sceneIsCompleteCheckBox = new javax.swing.JCheckBox();
        addSceneButton = new javax.swing.JButton();
        editSceneButton = new javax.swing.JButton();
        removeSceneButton = new javax.swing.JButton();
        sceneNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        sceneViewRequirementsButton = new javax.swing.JButton();
        scheduleTabPanel = new javax.swing.JPanel();
        sideScenePanel = new javax.swing.JPanel();
        sceneListLabel = new javax.swing.JLabel();
        sceneListScrollPane = new javax.swing.JScrollPane();
        mainScenePanel = new javax.swing.JPanel();

        label1.setText("label1");

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        mainPanel.setBorder(new javax.swing.border.MatteBorder(null));

        scriptContentPanel.setLayout(new java.awt.GridLayout(1, 3));

        volunteerSectionLabel.setText("Volunteer");

        firstNameLabel.setText("First Name:");

        lastNameLabel.setText("Last Name:");

        phoneNumberLabel.setText("Phone Number:");

        emailLabel.setText("Email:");

        volunteerFirstNameField.setText("first name here");
        volunteerFirstNameField.setFocusable(false);
        volunteerFirstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volunteerFirstNameFieldActionPerformed(evt);
            }
        });

        volunteerLastNameField.setText("last name here");
        volunteerLastNameField.setFocusable(false);

        volunteerPhoneNumberField.setText("phone number here");
        volunteerPhoneNumberField.setFocusable(false);

        volunteerEmailField.setText("email here");
        volunteerEmailField.setFocusable(false);

        viewAvailabilitiesButton.setText("View Availabilities");

        addVolunteerButton.setText("Add Volunteer");
        addVolunteerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVolunteerButtonActionPerformed(evt);
            }
        });

        editVolunteerButton.setText("Edit Volunteer");

        removeVolunteerButton.setText("Remove Volunteer");

        volunteerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        volunteerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volunteerComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout volunteerPanelLayout = new javax.swing.GroupLayout(volunteerPanel);
        volunteerPanel.setLayout(volunteerPanelLayout);
        volunteerPanelLayout.setHorizontalGroup(
            volunteerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(volunteerPanelLayout.createSequentialGroup()
                .addGroup(volunteerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(volunteerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(volunteerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(volunteerPanelLayout.createSequentialGroup()
                                .addGroup(volunteerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(volunteerSectionLabel)
                                    .addComponent(firstNameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(volunteerFirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(volunteerPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(volunteerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(volunteerPanelLayout.createSequentialGroup()
                                        .addComponent(emailLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(volunteerEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(volunteerPanelLayout.createSequentialGroup()
                                        .addComponent(lastNameLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(volunteerLastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(volunteerPanelLayout.createSequentialGroup()
                                        .addComponent(phoneNumberLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(volunteerPhoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(volunteerPanelLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(viewAvailabilitiesButton))
                    .addGroup(volunteerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addVolunteerButton))
                    .addGroup(volunteerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(editVolunteerButton))
                    .addGroup(volunteerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(removeVolunteerButton))
                    .addGroup(volunteerPanelLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(volunteerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        volunteerPanelLayout.setVerticalGroup(
            volunteerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(volunteerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(volunteerSectionLabel)
                .addGap(14, 14, 14)
                .addGroup(volunteerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(volunteerFirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(volunteerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(volunteerLastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(volunteerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberLabel)
                    .addComponent(volunteerPhoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(volunteerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(volunteerEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(viewAvailabilitiesButton)
                .addGap(18, 18, 18)
                .addComponent(volunteerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addVolunteerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editVolunteerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeVolunteerButton))
        );

        scriptContentPanel.add(volunteerPanel);

        equipmentSectionLabel.setText("Equipment");

        equipmentTypeLabel.setText("Type:");

        stockLabel.setText("Stock:");

        equipmentViewAdditionalInformationButton.setText("View Additional Information");

        equipmentIsRentalCheckbox.setText("Rental");
        equipmentIsRentalCheckbox.setFocusable(false);

        equipmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addEquipmentButton.setText("Add Equipment");

        editEquipmentButton.setText("Edit Equipment");

        removeEquipmentButton.setText("Remove Equipment");

        equipmentTypeField.setText("type here");
        equipmentTypeField.setFocusable(false);

        equipmentStockField.setText("Stock here");
        equipmentStockField.setFocusable(false);

        javax.swing.GroupLayout equipmentPanelLayout = new javax.swing.GroupLayout(equipmentPanel);
        equipmentPanel.setLayout(equipmentPanelLayout);
        equipmentPanelLayout.setHorizontalGroup(
            equipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(equipmentPanelLayout.createSequentialGroup()
                .addGroup(equipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(equipmentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(equipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(equipmentSectionLabel)
                            .addComponent(equipmentIsRentalCheckbox)
                            .addGroup(equipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, equipmentPanelLayout.createSequentialGroup()
                                    .addComponent(equipmentTypeLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(equipmentTypeField))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, equipmentPanelLayout.createSequentialGroup()
                                    .addComponent(stockLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(equipmentStockField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(equipmentPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(equipmentViewAdditionalInformationButton))
                    .addGroup(equipmentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(equipmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(equipmentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addEquipmentButton))
                    .addGroup(equipmentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(editEquipmentButton))
                    .addGroup(equipmentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(removeEquipmentButton)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        equipmentPanelLayout.setVerticalGroup(
            equipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(equipmentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(equipmentSectionLabel)
                .addGap(18, 18, 18)
                .addGroup(equipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(equipmentTypeLabel)
                    .addComponent(equipmentTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(equipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockLabel)
                    .addComponent(equipmentStockField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(equipmentIsRentalCheckbox)
                .addGap(23, 23, 23)
                .addComponent(equipmentViewAdditionalInformationButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(equipmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addEquipmentButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editEquipmentButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeEquipmentButton)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        scriptContentPanel.add(equipmentPanel);

        sceneNameLabel.setText("Name:");

        sceneDescriptionLabel.setText("Description");

        sceneDescriptionField.setColumns(20);
        sceneDescriptionField.setRows(5);
        sceneDescriptionField.setText("Scene description here.");
        sceneDescriptionField.setFocusable(false);
        sceneDescriptionScrollPane.setViewportView(sceneDescriptionField);

        sceneComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        sceneComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sceneComboBoxActionPerformed(evt);
            }
        });

        sceneIsScheduledCheckBox.setText("Scheduled");
        sceneIsScheduledCheckBox.setFocusable(false);

        sceneIsCompleteCheckBox.setText("Completed");
        sceneIsCompleteCheckBox.setFocusable(false);

        addSceneButton.setText("Add Scene");

        editSceneButton.setText("Edit Scene");

        removeSceneButton.setText("remove Scene");

        sceneNameField.setText("Scene name here");
        sceneNameField.setFocusable(false);

        jLabel3.setText("Scenes");

        sceneViewRequirementsButton.setText("View Requirements");

        javax.swing.GroupLayout scenePanelLayout = new javax.swing.GroupLayout(scenePanel);
        scenePanel.setLayout(scenePanelLayout);
        scenePanelLayout.setHorizontalGroup(
            scenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scenePanelLayout.createSequentialGroup()
                .addGroup(scenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, scenePanelLayout.createSequentialGroup()
                        .addGroup(scenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sceneDescriptionLabel)
                            .addComponent(jLabel3)
                            .addGroup(scenePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(scenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sceneIsCompleteCheckBox)
                                    .addComponent(sceneIsScheduledCheckBox)
                                    .addComponent(addSceneButton)
                                    .addComponent(editSceneButton)
                                    .addComponent(removeSceneButton))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, scenePanelLayout.createSequentialGroup()
                        .addComponent(sceneNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(sceneNameField))
                    .addGroup(scenePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(scenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sceneDescriptionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(sceneViewRequirementsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(scenePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sceneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        scenePanelLayout.setVerticalGroup(
            scenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scenePanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(scenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sceneNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sceneNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sceneDescriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sceneDescriptionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(sceneIsScheduledCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sceneIsCompleteCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sceneViewRequirementsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sceneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addSceneButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editSceneButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeSceneButton))
        );

        scriptContentPanel.add(scenePanel);

        javax.swing.GroupLayout scriptTabPanelLayout = new javax.swing.GroupLayout(scriptTabPanel);
        scriptTabPanel.setLayout(scriptTabPanelLayout);
        scriptTabPanelLayout.setHorizontalGroup(
            scriptTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scriptTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scriptContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        scriptTabPanelLayout.setVerticalGroup(
            scriptTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scriptTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scriptContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTab.addTab("Script", scriptTabPanel);

        scheduleTabPanel.setLayout(new java.awt.BorderLayout());

        sideScenePanel.setMaximumSize(new java.awt.Dimension(150, 32767));
        sideScenePanel.setPreferredSize(new java.awt.Dimension(150, 610));

        sceneListLabel.setText("Scenes");

        javax.swing.GroupLayout sideScenePanelLayout = new javax.swing.GroupLayout(sideScenePanel);
        sideScenePanel.setLayout(sideScenePanelLayout);
        sideScenePanelLayout.setHorizontalGroup(
            sideScenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideScenePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sideScenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sideScenePanelLayout.createSequentialGroup()
                        .addComponent(sceneListLabel)
                        .addGap(0, 75, Short.MAX_VALUE))
                    .addComponent(sceneListScrollPane))
                .addContainerGap())
        );
        sideScenePanelLayout.setVerticalGroup(
            sideScenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideScenePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sceneListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sceneListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );

        scheduleTabPanel.add(sideScenePanel, java.awt.BorderLayout.LINE_START);
        scheduleTabPanel.add(mainScenePanel, java.awt.BorderLayout.CENTER);

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
                .addComponent(mainTab, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
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

    private void sceneComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sceneComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sceneComboBoxActionPerformed

    private void addVolunteerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVolunteerButtonActionPerformed
    {                                         
    
                this.setVisible(false);
                this.dispose();
                VolunteerForm volunteerForm = new VolunteerForm(theScript, database);
                volunteerForm.setVisible(true);
                this.repaint();
    }                       // TODO add your handling code here:
    }//GEN-LAST:event_addVolunteerButtonActionPerformed

    private void volunteerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volunteerComboBoxActionPerformed
       
        
       if (volunteerComboBox.getSelectedItem() != null && (volunteerComboBox.getSelectedItem() instanceof Volunteer))
       {
              volunteerEmailField.setText( ((Volunteer) volunteerComboBox.getSelectedItem()).getEmail());
         volunteerFirstNameField.setText( ((Volunteer) volunteerComboBox.getSelectedItem()).getFirstName());
          volunteerLastNameField.setText( ((Volunteer) volunteerComboBox.getSelectedItem()).getLastName());
           volunteerPhoneNumberField.setText( ((Volunteer) volunteerComboBox.getSelectedItem()).getPhone());
       
       }
            
    
    }//GEN-LAST:event_volunteerComboBoxActionPerformed

    private void volunteerFirstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volunteerFirstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_volunteerFirstNameFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println("Could not load database driver with "
                        + "message: " + ex.toString());
            return;
        }
        
        JdbcDatabase testDatabase = null;
        try{
            testDatabase = new JdbcDatabase(
                "jdbc:postgresql://edjo.usask.ca/cmpt370_group06",
                "cmpt370_group06",
                "Raptorjesusisawesome55775");
        }
        catch (SQLException ex)
        {
            System.out.println("Failed to connection to db with message: "
                + ex.getMessage());
            return;
        }
                
                try {
                new MainMenu(null, testDatabase).setVisible(true);
                } catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "Could not load main" +
                            " menu.");
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEquipmentButton;
    private javax.swing.JButton addSceneButton;
    private javax.swing.JButton addVolunteerButton;
    private javax.swing.JButton editEquipmentButton;
    private javax.swing.JButton editSceneButton;
    private javax.swing.JButton editVolunteerButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JComboBox equipmentComboBox;
    private javax.swing.JCheckBox equipmentIsRentalCheckbox;
    private javax.swing.JPanel equipmentPanel;
    private javax.swing.JLabel equipmentSectionLabel;
    private javax.swing.JTextField equipmentStockField;
    private javax.swing.JTextField equipmentTypeField;
    private javax.swing.JLabel equipmentTypeLabel;
    private javax.swing.JButton equipmentViewAdditionalInformationButton;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel jLabel3;
    private java.awt.Label label1;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel mainScenePanel;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JButton removeEquipmentButton;
    private javax.swing.JButton removeSceneButton;
    private javax.swing.JButton removeVolunteerButton;
    private javax.swing.JComboBox sceneComboBox;
    private javax.swing.JTextArea sceneDescriptionField;
    private javax.swing.JLabel sceneDescriptionLabel;
    private javax.swing.JScrollPane sceneDescriptionScrollPane;
    private javax.swing.JCheckBox sceneIsCompleteCheckBox;
    private javax.swing.JCheckBox sceneIsScheduledCheckBox;
    private javax.swing.JLabel sceneListLabel;
    private javax.swing.JScrollPane sceneListScrollPane;
    private javax.swing.JTextField sceneNameField;
    private javax.swing.JLabel sceneNameLabel;
    private javax.swing.JPanel scenePanel;
    private javax.swing.JButton sceneViewRequirementsButton;
    private javax.swing.JPanel scheduleTabPanel;
    private javax.swing.JPanel scriptContentPanel;
    private javax.swing.JPanel scriptTabPanel;
    private javax.swing.JPanel sideScenePanel;
    private javax.swing.JLabel stockLabel;
    private javax.swing.JButton viewAvailabilitiesButton;
    private javax.swing.JComboBox volunteerComboBox;
    private javax.swing.JTextField volunteerEmailField;
    private javax.swing.JTextField volunteerFirstNameField;
    private javax.swing.JTextField volunteerLastNameField;
    private javax.swing.JPanel volunteerPanel;
    private javax.swing.JTextField volunteerPhoneNumberField;
    private javax.swing.JLabel volunteerSectionLabel;
    // End of variables declaration//GEN-END:variables
}
