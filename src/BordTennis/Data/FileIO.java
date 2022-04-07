package BordTennis.Data;

import BordTennis.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO implements IO {
    ArrayList<Player> players = new ArrayList<>();
    File gameData = new File("src/BordTennis/Data/GameData");

    public boolean isDataAvailable() {
        if (gameData != null) {
            return true;
        }

        return false;
    }

    @Override
    public ArrayList<String> readGameData() {
        File file = new File("src/BordTennis/Data/TeamData");
        ArrayList<String> data = new ArrayList<>();

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                data.add(scan.nextLine());
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }


    @Override
    public ArrayList<String> readTeamData(String path) {
        return null;
    }

    @Override
    public ArrayList<String> readTournamentData(String path) {
        return null;
    }

    @Override
    public void saveGameData(String path) {

    }

    @Override
    public void saveTeamData(String path) {

    }

    @Override
    public void saveTournamentData(String path) {

    }
}
