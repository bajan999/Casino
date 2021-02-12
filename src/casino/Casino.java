
package casino;

import casino.Games.HigherLower;
import casino.Games.Roulette;
import casino.Games.Slots;
import java.util.Scanner;



public class Casino {
    
    public static String playerName;
    public static int coins;
    
    public static void mainMenu(){
        System.out.println("What do you want to do?\n1)check money\n2)higher lower\n3)roulette\n4)slot machine\nother)nothing");
        Scanner input = new Scanner(System.in);
        int choice=input.nextInt();
        if (choice==1){
            System.out.println("You have "+coins+" coins");
        }else if (choice==2){
            System.out.println("How much will you bet?");
            int bet=input.nextInt();
            if(bet>coins){
                bet=coins;
            }
            int result = HigherLower.higherLower();
            if (result==1) {
                coins=coins+bet;
            }else if (result==2){
                coins=coins-bet;
            }else{
                
            }
        }else if (choice==3){
            System.out.println("How much will you bet?");
            int bet=input.nextInt();
            if(bet>coins|bet<0){
                bet=coins;
            }
            int multiplier = Roulette.roulette();
            coins=coins+(bet*multiplier);
        }else if (choice==4){
            System.out.println("How much will you bet?");
            int bet=input.nextInt();
            if(bet>coins|bet<0){
                bet=coins;
            }
            int multiplier = Slots.slots();
            coins=coins+(bet*multiplier);
        }else{
            
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Input your name");
        playerName = input.next();
        coins=1000;                        //couldn't get the object to be global
        
        
        boolean continues = true;
        
        while (continues==true&coins>0){
            mainMenu();
            System.out.println("Do you want to continue? - y/n (will default to n if out of money)");
            String answer=input.next();
            if (answer.equals("y")) {
                
            }else{
                System.out.println("bye");
                continues=false;
            }
        }
        System.out.println("Goodbye");
    }
    
}
