package teamsb.mtglifeapp;

/**
 * Created by Adam on 4/10/2015.
 */
public class Player {
    private String name;
    private int life;
    private boolean turn;
    private Player whoseTurn;
    private int infectCounter;

    private final static int DEFAULT_LIFE_TOTAL = 20;

    public Player(String name){
        this.name = name;
        life = DEFAULT_LIFE_TOTAL;
        turn = false;
        whoseTurn = null;
        infectCounter = 0;
    }

    public Player(String name, int life)
    {
        this.name = name;
        this.life = life;
        turn = false;
        whoseTurn = null;
        infectCounter = 0;
    }

    public void addLife(int toAdd){
        life += toAdd;
    }

    public void subLife(int toSub){
        life -= toSub;
    }

    public void addInfect(int toAdd){
        subLife(toAdd);
        infectCounter += toAdd;
    }

    public void subtractInfect(int toSub){
        infectCounter -= toSub;
        life += toSub;
    }
}