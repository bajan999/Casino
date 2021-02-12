
package casino;

public class Players {
    private String name;
    private int coins;

    public Players(String name, int coins) {
        this.name = name;
        this.coins = coins;
    }

    public String getName() {
        return name;
    }

    public int getCoins() {
        return coins;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
    @Override
    public String toString(){
        return name+", "+coins;
    }
}
