package app;

public class Player {
    private String name;
    private int score = 0;
    /*
    Player constructor
    @param nm The name of the player to be created
    @throws IllegalArgumentException if the number of characters in nm > 16
     */
    public Player(String nm){
        if( nm.length()>16){
            throw new IllegalArgumentException("A player name with more than 16 characters was entered");
        }
        name = nm;
    }
    /*
Method to set score contained in player object
@param scr The score of the Player to be stored
*/
    public void setScore(int scr){
        score = scr;
    }

    /*
Method to get score contained in player object
@returns score The score of the Player
 */
    public int getScore(){
        return score;
    }
    /*
 Method to get player's name
 @returns name The name of the Player
  */
    public String getName(){ return name;}
    /*
Method to return Player
@returns the Player name and score in String
*/
    public String toString(){
        return name+"| score: "+score;
    }

}