package casino.Games;

import java.util.Random;

public class Slots {

    public static int slots() {
        Random random = new Random();
        int slot1 = random.nextInt(7) + 1;
        int slot2 = random.nextInt(7) + 1;
        int slot3 = random.nextInt(7) + 1;
        int multiplier;
        System.out.println(slot1+"-"+slot2+"-"+slot3);
        if (slot1 == slot2 & slot1 == slot3) {
            System.out.println("You win with multiplier "+slot1);
            multiplier=slot1;
        }else{
            System.out.println("You lose");
            multiplier=-1;
        }
        return multiplier;
    }
}
