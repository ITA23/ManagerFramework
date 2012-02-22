package tests.mocks;

import ita23.managerframework.time.TimeListener;

/**
 * @author Fabian Bottler
 * @version 1.0
 */
public class TimeListenerMock implements TimeListener {

    private int tmonth =0;
    private int tweek =0;
    private int tyear =0;
    private int tday = 0;

    @Override
    public void dayOver() {
        tday++;
        System.out.println("yearOver NR."+ tday);
    }

    @Override
    public void weekOver() {
        tweek++;
        System.out.println("weekOver NR."+ tweek);
    }

    @Override
    public void monthOver() {
        tmonth++;
        System.out.println("monthOver NR."+ tmonth);
    }

    @Override
    public void yearOver() {
        tyear++;
        System.out.println("yearOver NR."+ tyear);
    }
    
    public int getTmonth(){
        return tmonth;
    }
    public int getTweek(){
        return tweek;
    }
    public int getTyear(){
        return tyear;
    }
}
