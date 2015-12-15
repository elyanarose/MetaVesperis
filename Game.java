package app;

import java.util.Scanner;
public class Game{
    public Player player;
    private Scanner input = new Scanner(System.in);
    public Game() {
    }
    /*
       Code to prompt and answer simple equations
        */
    public Player playGame(){
        boolean step = false;
        System.out.println("First, Enter your Player Name (Must be less that 16 Characters): ");
        do{
            if(input.hasNext()){
                player = new Player(input.next());
                step = true;
            }
            else{
                System.out.println("please, enter your name");
            }
        } while(!step);
        LlamaText llama = new LlamaText();
        System.out.println("OOOO "+llama+" IS IN DANGER OOOO \nHE NEEDS TO BE RESCUED!\nRescue "+llama+" from certain death within a volcano by answering 8 equations\nBe aware that "+llama+" will die if you answer 3 questions wrong.\nTHE LLAMA HAS A NAME.\nIT'S "+llama);
        int score = 0;
        int wrong = 0;
        do {
            Equation eq = new Equation();
            System.out.print(eq.getProblem());
            boolean active = true;
            while (active) {
                if (input.hasNextInt()) {
                    if (eq.checkAnswer(input.nextInt())) {
                        System.out.println("Correct!");
                        score++;
                        active = false;
                        if (score == 8){
                            System.out.println("YOU SAVED "+llama);
                        }

                    } else {
                        wrong++;
                        System.out.println("Wrong!");
                        active = false;
                        if (wrong == 3){
                            System.out.println(llama+" perished...");
                        }
                    }
                }
                else {
                    System.out.println("You did not input an integer. Try again:"+"\n"+eq.getProblem());
                    input.nextLine();
                }
            }
        }
        while ((score < 8) && (wrong < 3));
        player.setScore(score-wrong);
        return player;



    }
    /*
           Code to play game again if the user enters yes.
            */
    public void playAgain() {
        boolean active = true;
        while (active) {
            System.out.println("Play again?");
            System.out.print("Enter either 'yes' or 'no' : ");
            if(input.hasNext()){
                String answer = input.next();
                if(answer.equals("no")){
                    active = false;
                }
                else if (answer.equals("yes")){
                    Main.scr.addPlayer(playGame());}
                else{
                    System.out.println("You did not say 'yes' or 'no'");
                }
            }
        }
    }
}
