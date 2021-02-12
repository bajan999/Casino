package casino.Games;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HigherLower {

    
    
    public static ArrayList<Integer> cards1 = new ArrayList<>();
    public static ArrayList<Integer> cards2 = new ArrayList<>();
    public static int p1score = 0;
    public static int p2score = 0;
    public static int p1card = 0;
    public static int p2card = 0;
    public static boolean p1life = true;
    public static boolean p2life = true;

    public static void setTo0() {
        p1score = 0;
        p2score = 0;
        p1card = 0;
        p2card = 0;
        p1life = true;
        p2life = true;
    }

    public static void setDeck1() {
        for (int i = 0; i < 13; i++) {          //cards up to king
            for (int j = 0; j < 4; j++) {
                cards1.add(i + 1);
            }
        }
        cards1.add(0);                           //jokers
        cards1.add(0);
        Collections.shuffle(cards1);             //shuffles
    }

    public static void setDeck2() {
        for (int i = 0; i < 13; i++) {          //cards up to king
            for (int j = 0; j < 4; j++) {
                cards2.add(i + 1);
            }
        }
        cards2.add(0);                           //jokers
        cards2.add(0);
        Collections.shuffle(cards2);             //shuffles
    }

    public static int getUserInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static String getUserString() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public static int checkValues1() {

        String p1Next = p1NextCard();

        System.out.println("The next card is " + p1Next);

        if (cards1.get(p1card) > cards1.get(p1card + 1)) {
            System.out.println("It's lower");
            p1card++;
            return 2;
        } else if (cards1.get(p1card) < cards1.get(p1card + 1)) {
            System.out.println("It's higher");
            p1card++;
            return 1;
        } else {
            System.out.println("They are the same");
            p1card++;
            return 0;
        }
    }

    public static int checkValues2() {

        String p2Next = p2NextCard();

        System.out.println("The next card is " + p2Next);

        if (cards2.get(p2card) > cards2.get(p2card + 1)) {
            System.out.println("It's lower");
            p2card++;
            return 2;
        } else if (cards2.get(p2card) < cards2.get(p2card + 1)) {
            System.out.println("It's higher");
            p2card++;
            return 1;
        } else {
            System.out.println("They are the same");
            p2card++;
            return 0;
        }
    }

    public static void p1play() {
        p1CardOut();
        System.out.println("p1 1) higher or 2) lower?");
        boolean valid = false;
        int choice = 0;
        while (valid == false) {
            choice = getUserInt();
            if (choice == 1 | choice == 2) {
                valid = true;
            } else {
                System.out.println("Invalid choice");
            }
        }
        int results = checkValues1();
        if (results == 0) {
            System.out.println("No points");
        } else if (results == choice) {
            System.out.println("Correct - +1 point");
            p1score++;
        } else {
            System.out.println("Incorrect - game over");
            p1life = false;
        }
        System.out.println("");
    }

    public static void p2play() {
        p2CardOut();

        int choice;
        if (cards2.get(p2card) < 8) {
            System.out.println("CPU says higher");
            choice = 1;
        } else {
            choice = 2;
        }

        int results = checkValues2();
        if (results == 0) {
            System.out.println("No points");
        } else if (results == choice) {
            System.out.println("Correct - +1 point");
            p2score++;
        } else {
            System.out.println("Incorrect - game over");
            p2life = false;
        }

    }

    public static void p1CardOut() {
        if (null == cards1.get(p1card)) {
            System.out.println("p1 card " + cards1.get(p1card));
        } else {
            switch (cards1.get(p1card)) {
                case 0:
                    System.out.println("p1 card Joker");
                    break;
                case 1:
                    System.out.println("p1 card Ace");
                    break;
                case 11:
                    System.out.println("p1 card Jack");
                    break;
                case 12:
                    System.out.println("p1 card queen");
                    break;
                case 13:
                    System.out.println("p1 card king");
                    break;
                default:
                    System.out.println("p1 card " + cards1.get(p1card));
                    break;
            }
        }
    }

    public static void p2CardOut() {
        if (null == cards2.get(p2card)) {
            System.out.println("p2 card " + cards2.get(p2card));
        } else {
            switch (cards2.get(p2card)) {
                case 0:
                    System.out.println("p2 card Joker");
                    break;
                case 1:
                    System.out.println("p2 card Ace");
                    break;
                case 11:
                    System.out.println("p2 card Jack");
                    break;
                case 12:
                    System.out.println("p2 card queen");
                    break;
                case 13:
                    System.out.println("p2 card king");
                    break;
                default:
                    System.out.println("p2 card " + cards2.get(p2card));
                    break;
            }
        }
    }

    public static String p1NextCard() {
        if (null == cards1.get(p1card)) {
            System.out.println("p1 card " + cards1.get(p1card + 1));
        } else {
            switch (cards1.get(p1card + 1)) {
                case 0:
                    return "joker";
                case 1:
                    return "ace";
                case 11:
                    return "jack";
                case 12:
                    return "queen";
                case 13:
                    return "king";
                default:
                    return Integer.toString(cards1.get(p1card + 1));
            }
        }
        return Integer.toString(cards1.get(p1card + 1));
    }

    public static String p2NextCard() {
        if (null == cards2.get(p2card)) {
            System.out.println("p2 card " + cards2.get(p2card + 1));
        } else {
            switch (cards2.get(p2card + 1)) {
                case 0:
                    return "joker";
                case 1:
                    return "ace";
                case 11:
                    return "jack";
                case 12:
                    return "queen";
                case 13:
                    return "king";
                default:
                    return Integer.toString(cards2.get(p2card + 1));
            }
        }
        return Integer.toString(cards2.get(p2card + 1));
    }

    public static int higherLower(){

        setTo0();

        

        setDeck1();
        setDeck2();

        p1CardOut();

        p2CardOut();

        while (p1life == true | p2life == true) {
            if (p1life == true) {
                p1play();
            }
            if (p2life == true) {
                p2play();
            }
        }
        System.out.println("You scored " + p1score);
        System.out.println("CPU scored " + p2score);
        int position;
        if (p1score > p2score) {
            System.out.println("You win");
            position=1;

        } else if (p2score > p1score) {
            System.out.println("CPU wins");
            position=2;

        } else {
            System.out.println("tie");
            position=0;
        }
        return position;
    }

}
