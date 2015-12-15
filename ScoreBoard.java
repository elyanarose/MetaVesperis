package app;

import java.util.ArrayList;
import java.io.*;

public class ScoreBoard {
    /*
     Need to be able to sort and rewrite the scores on the scoreboard
     Need a max-number of scores on Scoreboard (Say 20)
      */
    private ArrayList<Player> board = new ArrayList<>();
    int place;
    boolean append = true;
    /*
    constructs ScoreBoard object
  */
    public ScoreBoard() {
        BufferedReader myReader;
        try {
            myReader = new BufferedReader(new FileReader("scores.csv"));
            String entry;
            String[] playerArray;
            do {
                entry = myReader.readLine();
                if (entry != null) {
                    playerArray = entry.split(",");
                    Player p = new Player(playerArray[0]);
                    int score = Integer.parseInt(playerArray[1]);
                    p.setScore(score);
                    board.add(p);
                }
            } while (entry != null);
            myReader.close();
            place = board.size();
            if(place== 0){{
            place = 1;
            }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Oh NO file not there!");
        } catch (IOException e) {
            System.out.println("Oh NO!");
        }
    }
    /*
Method to add player to ScoreBoard
@param the Player to add to the ScoreBoard
@throws IllegalArgumentException if p is null
*/
    public void addPlayer(Player p) {
        if (p == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        board.add(p);
    }
    public void setScores(){
        FileWriter myWriter;
        try {
            myWriter = new FileWriter("scores.csv",append);
            for(int i = place-1; i<board.size(); i++) {
                myWriter.write(board.get(i).getName()+","+board.get(i).getScore()+"\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Oh NO!");
        }
    }
    public String getScores(){
        sortScores();
        int n = 1;
        String scoreslist = "";
            for (Player pl : board) {
                scoreslist = scoreslist + n + ". "+ pl+"\n";
                n = n+1;
            }
        return scoreslist;
    }
    public void sortScores(){
        int n = board.size();

        if (n>1) {
            for (int i = 0; i < n-1; i++) {
                for (int j = 0; j < n-i-1; j++) {
                    if (board.get(j).getScore() < board.get(j + 1).getScore()) {
                        Player temp = board.get(j);
                        board.remove(j);
                        board.add(j + 1, temp);

                    }
                }


            }
        }

    }

}