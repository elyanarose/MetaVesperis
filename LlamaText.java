package app;
import java.util.Scanner;
public class LlamaText {
/*
Llama constructor prints a Llama
*/
  private String name;
    public LlamaText(){
        System.out.println(" _/\\\n/O |\n\\  |\n | |\n | |\n |  \\_\n |||  \\\n |||_\\ |\n LLl  Ll");
        setName();
        System.out.println(name);
    }

/*
       Method sets name of Llama
        */

    public void setName(){
        Scanner in = new Scanner(System.in);
        boolean active = true;
        System.out.println("Give a name to the Llama:");
        while (active){
            if(in.hasNext()){
                name = in.next();
                active = false;
            }
            else{
                System.out.println("You NEED to give a name to the Llama:");
            }
        }
    }
    public String toString(){
        return name;
    }
}