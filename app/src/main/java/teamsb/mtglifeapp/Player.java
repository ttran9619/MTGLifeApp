package teamsb.mtglifeapp;

/**
 * Created by Adam on 4/10/2015.
 */
public class Player {
    private String name;
    private int life;
    private boolean turn;
    private int turnCount;
    private int infectCounter;

    private final static int DEFAULT_LIFE_TOTAL = 20;

    public Player(String name){
        this.name = name;
        life = DEFAULT_LIFE_TOTAL;
        turn = false;
        infectCounter = 0;

    }

    public Player(String name, int life)
    {
        this.name = name;
        this.life = life;
        turn = false;
        turnCount = 0;
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

    public void subInfect(int toSub){
        if(infectCounter!=0){
            life += toSub;
        }
        infectCounter -= toSub;


    }

    public int getLife(){
        return life;
    }

    public void setLife(int toAdd){
        life = toAdd;
    }

    public void setInfect(int toAdd){
        infectCounter = toAdd;
    }

    public boolean getTurnStatus(){
        return turn;
    }

    public void passTurn(){
        turn = false;
    }
    public void takeTurn(){
        turn = true;
    }

    public int getTurnCount(){
        return turnCount;
    }

    public void addTurnCount(){
        turnCount+=1;
    }

    public void subTurnCount(){
        turnCount-=1;
        if(turnCount<0){
            turnCount=0;
        }
    }

    public int getInfectCounter(){
        return infectCounter;
    }

    public String getName(){
        return name;
    }
}