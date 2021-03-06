package moviescheduler;

import database.JdbcDatabase;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.sql.SQLException;
import actions.LoadScriptAction;
import businessobjects.*;
import database.Database;
import static moviescheduler.MovieScheduler.script;

/**
 * Class which holds the main entry point function for the MovieScheduler system
 *
 * @author Iain Workman, Ryan La Forge, John Mason
 */
public class MovieScheduler {

protected static boolean initializedProperly;
protected static ArrayList<String> errorsEncountered;
protected static Script script;
protected static Database database;
    protected static void initializeDatabase()
    {
        
        // initialze sub systems. If fail any of the required inits, then
        // initializedProperly is set to false
        initializedProperly = true;
        // Each time an init action fails, add an error message to this list
        errorsEncountered = new ArrayList<>();

        // Attempt initialization of database driver
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            initializedProperly = false;
            errorsEncountered.add("Could not load database driver with "
                    + "message: " + ex.toString());
        }

        // Attempt connect to database
        final JdbcDatabase database;
        try {
            database = new JdbcDatabase(
                    "jdbc:postgresql://edjo.usask.ca/cmpt370_group06",
                    "cmpt370_group06",
                    "Raptorjesusisawesome55775");
        } catch (SQLException ex) {
            System.out.println("Failed to connection to db with message: "
                    + ex.getMessage());
            return;
        }

        MovieScheduler.database = database;
    }

protected static void initializeScript()
{
    // Attempt to load a script
        LoadScriptAction loadScriptAction = new LoadScriptAction(database);
        loadScriptAction.run();

        if (!loadScriptAction.wasSuccessful()) {
            initializedProperly = false;
            errorsEncountered.add(loadScriptAction.lastErrorMessage());
        }

        script = (Script) loadScriptAction.getBusinessObject();
}

    /**
     * Main entry point for the GUI of the movie scheduler system.
     *
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) 
    {
        MovieScheduler.initializeDatabase();
        MovieScheduler.initializeScript();
        MovieSchedulerController controller = new MovieSchedulerController(script,database);
        
        if (script == null && initializedProperly) {
            // No errors were encountered, but we didn't find a script, must
            // be the first time loading. Display the start menu.
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    controller.displayStartMenu();     
                }
            });
        } else if (initializedProperly) {
            // Script was found, show it in the main menu
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    controller.displayMainMenu();
                }
            });

        } else {
            // One of this inits failed. Display an error message and exit
            JOptionPane.showMessageDialog(null, "Could not load the system,"
                    + " with errors:\n" + errorsEncountered.toString(),
                    "Error Loading System!", 0);
        } 
    }
}
