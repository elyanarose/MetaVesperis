package app;
import java.util.Random;

public class Equation{
    private int answer;
    private String problem;
    private static final String[] operations = {"+","-","x","/"};
    private static final int RANGE_OF_FUNCTIONS = 100;
   /* public static void main(String[] args) {
        for (int i = 0; i < 25; i++) {
            System.out.println(new Equation());
        }
    }*/

    /*
Equation constructor
Creates a new random equation with a random operation
the answer to the equation produced must be in the range: [-100,100]
*/
    public Equation(){
        Random generator = new Random();
        int x = generator.nextInt(11);
        int y = generator.nextInt(11);
        int o = generator.nextInt(3);
        if (operations[o].equals("+")){
            answer = x+y;
        }
        else if (operations[o].equals("-")){
            answer = x-y;
        }
        else if (operations[o].equals("x")){
            answer = x*y;
        }
        //Else it is division
        else {
            while (y==0){
                y = generator.nextInt(11);
            }
            if (x%y == 0){
                answer = x/y;
            }
            else {
                x = x - (x % y);
                answer = x / y;
            }
        }
        problem = x + " "+ operations[o]+ " "+y+ " = ";
        assert answer <= RANGE_OF_FUNCTIONS && answer >= (-1)*RANGE_OF_FUNCTIONS;


    }

    /*
Method to check if user guessed the write the value for the equation
@param int guess, the answer to the equation that the user guessed and entered
@return true if guess was correct, false otherwise
@throws IllegalArgumentException if the guess was out of the range of values for the equations

*/
    public boolean checkAnswer(int guess){
        if (guess > RANGE_OF_FUNCTIONS || guess < (-1)*RANGE_OF_FUNCTIONS){
            throw new IllegalArgumentException("The guess was out of the range of the equations");
        }
        if (guess == answer) return true;
        else return false;
    }
    /*
    Method to get answer of equation
    @return int answer Answer to equation
    */

    public int getAnswer(){

        return answer;
    }
    /*
   Method to get String of problem
   @return String problem
   */
    public String getProblem(){
        return problem;
    }
    /*
   Method to get equation
   @return String of equation
   */
    public String toString(){
        return problem+answer;
    }

}
