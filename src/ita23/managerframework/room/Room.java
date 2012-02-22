package ita23.managerframework.room;

/**
 * This interface represents a room
 * @author Rafael Marques
 * @version 1.0
 */
public interface Room {
    /**
     * Returns the price of this room.
     * @return price to buy the room
     */
    public int getPrice();

    /**
     * Returns the maximum amount of {@code Employees}
     * this room can have
     * @return Maximum Amount of Employees
     */
    public int maxAmountOfEmployees();

}
