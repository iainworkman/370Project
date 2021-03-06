package ui;

import actions.DeleteSceneFilmingDateAction;
import businessobjects.Scene;
import businessobjects.SceneFilmingDate;
import businessobjects.Script;
import businessobjects.TimeInterval;
import database.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import moviescheduler.MovieSchedulerController;

/**
 * A class which represents the scene panel for display in the MainMenu
 * @author Iain Workman
 */
public class SchedulePanel extends javax.swing.JPanel
{

    // Constructor
    /**
     * Creates new instance of a SchedulePanel
     */
    public SchedulePanel(MovieSchedulerController controller)
    {
        this.controller = controller;
        initComponents();
                sceneListView = new BusinessObjectListView<>(controller.getScript().getScenes());
        sceneListViewScrollPane.setViewportView(sceneListView);


        JPopupMenu sceneListViewPopupMenu = new JPopupMenu();
        JMenuItem scheduleSceneMenuItem = new JMenuItem("Schedule Scene...");

        sceneListView.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if (SwingUtilities.isRightMouseButton(e))
                {

                    int indexUnderPointer
                            = sceneListView.locationToIndex(e.getPoint());

                    if (!sceneListView.getCellBounds(indexUnderPointer,
                            indexUnderPointer).contains(e.getPoint()))
                    {
                        sceneListView.clearSelection();
                    } 
                    else
                    {

                        sceneListView.setSelectedIndex(indexUnderPointer);

                        sceneListViewPopupMenu.show(
                                sceneListView, e.getX(), e.getY());
                    }
                }
                super.mousePressed(e);
            }
        });
        scheduleSceneMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Scene selectedScene = sceneListView.getSelectedValue();
                SceneFilmingDate filmingDate =
                        controller.getScript().getSchedule().getScenesFilmingDate(selectedScene);
                
                if(filmingDate == null)
                {
                    
                    filmingDate = new SceneFilmingDate();
                    filmingDate.setScene(selectedScene);
                    GregorianCalendar start = new GregorianCalendar();
                    start.add(Calendar.DAY_OF_WEEK, 1);
                    start.set(Calendar.HOUR_OF_DAY, 9);
                    
                    GregorianCalendar end = new GregorianCalendar();
                    end.add(Calendar.DAY_OF_WEEK, 1);
                    end.set(Calendar.HOUR_OF_DAY, 11);
                    
                    filmingDate.setSceneShootingInterval(
                        new TimeInterval(start, end));
                    filmingDate.setHasChanged(false);
                }
                
                SceneFilmingDateForm editFilmingDate = new
                    SceneFilmingDateForm(controller.getScript(), filmingDate, controller.getDatabase());
                editFilmingDate.setVisible(true);
            }
        });
        sceneListViewPopupMenu.add(scheduleSceneMenuItem);
        //sceneListView.setComponentPopupMenu(sceneListViewPopupMenu);

        sceneListViewPopupMenu.addPopupMenuListener(new PopupMenuListener()
        {
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
                if (selectedScene == null)
                {
                    return;
                }

                scheduleSceneMenuItem.setText("Schedule "
                        + sceneListView.getSelectedValue().toString());
            }
        });
        ScheduleCalendar scheduleCalendar = new ScheduleCalendar();
        scheduleCalendar.setSchedule(controller.getScript().getSchedule());
        scheduleCalendar.addDeleteActionListener(
                new DeleteFilmingDateActionListener(){

            @Override
            public void deleteActionPerformed(DeleteFilmingDateEvent e) {
                deleteSceneFilmingDate(e.getSceneFilmingDate());
            }
                
        });
        calendarPanel.add(scheduleCalendar);
    }

    // Private Methods
    
    private void deleteSceneFilmingDate(SceneFilmingDate sceneFilmingDate)
    {
        
        controller.deleteBusinessObject(sceneFilmingDate);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidePanel = new javax.swing.JPanel();
        sceneListViewScrollPane = new javax.swing.JScrollPane();
        sceneListViewLabel = new javax.swing.JLabel();
        launchConflictButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        calendarPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        sceneListViewLabel.setText("Scenes");

        launchConflictButton.setText("Conflicts");
        launchConflictButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                launchConflictButtonMouseClicked(evt);
            }
        });
        launchConflictButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchConflictButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sceneListViewScrollPane)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addComponent(sceneListViewLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(launchConflictButton)
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sceneListViewLabel)
                    .addComponent(launchConflictButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sceneListViewScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(sidePanel, java.awt.BorderLayout.LINE_START);

        calendarPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calendarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calendarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void launchConflictButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchConflictButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_launchConflictButtonActionPerformed

    private void launchConflictButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_launchConflictButtonMouseClicked
        JFrame conflictFrame;
        conflictFrame = new ConflictResolution(controller.getScript());
    }//GEN-LAST:event_launchConflictButtonMouseClicked

    // Private Member Variables
    private BusinessObjectListView<Scene> sceneListView;
    private final MovieSchedulerController controller;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel calendarPanel;
    private javax.swing.JButton launchConflictButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel sceneListViewLabel;
    private javax.swing.JScrollPane sceneListViewScrollPane;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}
