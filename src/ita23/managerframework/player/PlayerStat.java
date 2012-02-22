package ita23.managerframework.player;

import ita23.managerframework.event.EventStats;

import java.util.ArrayList;
import java.util.List;

/**
 * The PlayerStat class is a holder class for the Player stats.</p>
 * This class is a singleton, because we just want one instance of the class.
 * @author Fabian Bottler
 * @version 1.0
 */
public enum PlayerStat{


    /** The instance to work with */
    INSTANCE;
    
    private final static int START_MONEY = 10000;

    /** score is the variable to hold the score of the Player */
    private int scores;

    /** The name is the Name from the Player */
    private String name;

    /** money is the current capital of the player */
    private int money;

    /** investedMoney give us the money, we had invested in e.g. employee and building */
    private int investedMoney;

    /** lossOfMoney give us the money, we had loss in the game */
    private int lossOfMoney;

    /** salaries give us the salaries we had payed. */
    private int salaries;

    /** work Stations give us the maximal workstations. */
    private int workStations;
    
    private int fans;
    
    private List<EventStats> eventStats = new ArrayList<EventStats>();

    /**
     * private constructor of our class
     */
    private PlayerStat() {
        this.money = START_MONEY;
    }

    /**
     * Updated the score of the player
     * @param score to update the scores
     */
    public void updateScores(int score){
        scores+=score;
    }

    /**
     * Get the score from the player
     * @return the current scores of the player
     */
    public int getScores(){
        return scores;
    }

    /**
     * Set the name from the player
     * @param name of the player
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get the name from the player
     * @return the Name from the player.
     */
    public String getName(){
        return name;
    }

    /**
     * Added the earn of the player to the money
     * @param earn the money that the player earned.
     */
    public void earnMoney(int earn){
        money += earn;
    }

    /**
     * There we add all invest you  do ,subtract it from the money and added to the investedMoney
     * @param invest the money of the player
     */
    public void investMoney(int invest){
        investedMoney += invest;
        money-=invest;
    }

    /**
     * In the method we subtract the loss from the money and added it to the lossOfMoney
     * @param loss that have do the player
     */
    public void lossOfCapital(int loss){
        lossOfMoney += loss;
        money-= loss;
    }

    /**
     * This method is for the salaries, its added all salaries and subtract it from the money
     * @param wages that have the player have to pay his employee.
     */
    public void transferSalary(int wages){
        salaries += wages;
        money -= wages;
    }

    /**
     * Get the current Money from the Player
     * @return the current money of the player
     */
    public int getMoney(){
        return money;
    }

    /**
     * Get all the Invested money
     * @return the invested money of the player for the statistic
     */
    public int getInvestedMoney(){
        return investedMoney;
    }

    /**
     * Get all the loss we have made
     * @return the loss of the player for the statistic
     */
    public int getLossOfMoney(){
        return lossOfMoney;
    }

    /**
     * Get all the salaries we have payed
     * @return the salaries that the player had payed for all the employee
     */
    public int getSalaries(){
        return salaries;
    }

    /**
     * In the method we set the maximal workstations
     * @param stations is the number of the work stations for the employees
     */
    public void setWorkStations(int stations){
        workStations +=stations;
    }

    /**
     * Get the maximal workstations
     * @return the maximal work station that the player have.
     */
    public int getWorkStations(){
        return workStations;
    }

    /**
     * Get the fans of the player
     * @return the number of the current fans of the player.
     */
    public int getFans() {
        return fans;
    }

    /**
     * Set or update the fans of the player.
     * @param fans to update the current fans of the player.
     */
    public void setFans(int fans) {
        this.fans += fans;
    }

    /**
     * The eventOver method is called when a event is over, it is called from the class
     * @see ita23.managerframework.event.EventCalculate
     * @param money the money that the player has won at a event.
     * @param fans  the fans that the player has get in the event.
     * @param eventStats all the interested staff of a event  that we need for statistic.
     */
    public void eventOver(int money, int fans,EventStats eventStats ) {
        this.money+= money;
        this.fans+=fans;
        this.eventStats.add(eventStats);
    }
}
