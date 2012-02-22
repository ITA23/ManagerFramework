package tests.mocks;

import ita23.managerframework.room.Room;

/**
 * @author Rafael Marques
 * @version 1.0
 * This is the RoomMock for the Room interface
 */
public class RoomMock implements Room {
    
    private int room_price;
    private int room_maxEmp;

    public RoomMock(int price, int maxEmp){
        this.room_price = price;
        this.room_maxEmp = maxEmp;
    }
    
    @Override
    public int getPrice() {
        return this.room_price;
    }

    @Override
    public int maxAmountOfEmployees() {
        return this.room_maxEmp;
    }
}
