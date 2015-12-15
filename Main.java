package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Application {
    private static Game game = new Game();
    public static ScoreBoard scr = new ScoreBoard();
    public Button playgame;
    public Button viewscrs;
    public ImageView background;
    public Text scrboardtitle;
    public ImageView title;
    public Text scores;
    public ImageView llama;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../sample.fxml"));
        primaryStage.setTitle("LLAMAS IN LAVA");
        primaryStage.setScene(new Scene(root, 600, 575));
        primaryStage.show();
        background = new ImageView();
        scrboardtitle = new Text();
        scores = new Text();
        title = new ImageView();
        playgame = new Button();
        viewscrs = new Button();
        llama = new ImageView();
        System.out.println("*******************************************LLAMAS IN LAVA*******************************************");
    }

    public static void main(String[] args) {
        launch(args);

    }

    public void viewScores(){
        title.setOpacity(0.0);
        scrboardtitle.setOpacity(1.0);
        scores.setText(scr.getScores());


    }
    public void play(){
        decisions();
        scr.setScores();
    }
         /*
    Recursive function to prompt user with menu of options until they choose to exit
    @return false boolean value for recursion
    */

        public  boolean decisions(){
            playgame = new Button();
            viewscrs = new Button();
            Scanner in = new Scanner(System.in);
            boolean active = true;
            while(active) {
                int a = -1;
                boolean notsuccess;
                do {
                    try {
                        System.out.println("Enter: \n0-Play Game\n1-ViewScores\n2-Exit");
                        a = in.nextInt();
                        if (a != 0 && a != 1 && a != 2) {
                            throw new IllegalArgumentException("You did not enter 0,1,or 2");
                        }
                        notsuccess = false;
                    }
                    catch (InputMismatchException | IllegalArgumentException e) {
                        System.out.println("You did not enter an integer 0,1, or 2");
                        System.out.println("Try again, Remember, you have to press 2 to Exit:");
                        notsuccess = true;
                        if (in.hasNextLine())
                            in.nextLine();
                    }
                } while(notsuccess);

                if (a == 0 || a == 1) {
                    if (a == 0) {
                        scr.addPlayer(game.playGame());
                        game.playAgain();
                    } else {
                        System.out.println(scr.getScores());
                    }
                    if (!decisions()) {
                        active = false;
                    }
                } else {
                    System.out.println("Thanks for playing!!!!!!");
                    active = false;
                }
            }

            return false;

        }
    }




