package BordTennis;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnector {
    Tournament tournament = new Tournament();
    Connection connection = null;

    public void createConnection(ArrayList<Team> teamList) {
        String JdbcUrl = "jdbc:mysql://localhost/BordfodboldHold?" + "autoReconnect=true&useSSL=false";
        String username = "root";
        String password = "NY9hcW7DAZ!+-qg1:]G6";

        try {

            connection = DriverManager.getConnection(JdbcUrl, username, password);
            System.out.println("Try");
            insertTeamToDB(teamList);
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLexception");
        }

        System.out.println("Database Connected");
    }

    public void insertTeamToDB(ArrayList<Team> teamList) {
        String name;
        int score;
        int goals;

        for (Team t : teamList) {
            name = t.teamName;
            score = t.totalTournamentPoints;
            goals = t.goalPoints;

            String insertTeam = "INSERT INTO team (name, score, goals) VALUES (?,?,?)";
            try {
                PreparedStatement query1 = connection.prepareStatement(insertTeam);
                query1.setString(1, name);
                query1.setString(2, String.valueOf(score));
                query1.setString(3, String.valueOf(goals));
                var query1Result = query1.executeUpdate();
                System.out.println("Query1Result: " + query1Result);
            } catch (SQLException a) {
                a.printStackTrace();
            }
        }
    }


}

