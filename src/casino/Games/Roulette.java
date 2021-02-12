
package casino.Games;

import java.util.Random;
import java.util.Scanner;


public class Roulette {
    
    public static int roulette(){
        Scanner input = new Scanner(System.in);
        System.out.println("What do you want to bet on?\n1)number\n2)colour");
        int choice=input.nextInt();
        
        int number;
        int colour;
        int multiplier;
        
        Random random = new Random();
        int roll = random.nextInt(37);
        
        if(choice==1){
            System.out.println("What number? (0-36");
            number=input.nextInt();
            if (number==roll){
                System.out.println("You win!");
                multiplier=35;
            }else{
                System.out.println(roll+" - You lose!");
                multiplier=-1;
            }
        }else if (choice==2){
            System.out.println("What colour? (0 - red or 1 - black");
            colour=input.nextInt();
            if((roll%2==colour)&(roll!=0)){
                System.out.println("You win");
                multiplier=1;
            }else{
                System.out.println("You lost");
                multiplier=-1;
            }
        }else{
            System.out.println("no bet");
            multiplier=0;
        }
        
        return multiplier;
    }
}
