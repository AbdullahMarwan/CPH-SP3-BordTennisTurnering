package BordTennis;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

import static BordTennis.Main.setSaveToDatabase;

public class Gamecontroller {

    public void dataBaseSetup(Tournament tournament, Scanner sc) {
        DBConnector dbConnector = new DBConnector();

        setSaveToDatabase(true);

        System.out.println("This is the current data in the Database");

        dbConnector.setMethodChoiceDB(1);

        dbConnector.createConnection(tournament.teamList);

        System.out.println("To load it press 'L' or start a new 'N'\n");
        String input2 = sc.nextLine().toLowerCase(Locale.ROOT);

        if (input2.equals("l")) { //Load previous DB data
            dbConnector.setMethodChoiceDB(2);
            dbConnector.createConnection(tournament.teamList);
        } else if (input2.equals("n")) { //Clean DB table and start initiliazing new teams
            dbConnector.setMethodChoiceDB(4);
            dbConnector.createConnection(tournament.teamList);
            tournament.initializeTeams();
        }
    }

    public void fileIOSetup(Tournament tournament) throws FileNotFoundException {
        if (tournament.fileIO.isDataAvailable()) {
            tournament.addPlayersFromData();
        } else {
            tournament.initializeTeams();
        }
    }
}
