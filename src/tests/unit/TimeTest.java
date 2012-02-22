package tests.unit;

import ita23.managerframework.time.TimeManager;
import org.junit.Before;
import org.junit.Test;
import tests.mocks.TimeListenerMock;

import java.util.Date;

import static org.junit.Assert.assertTrue;

/**
 * @author Fabian Bottler
 * @version 1.0
 */
public class TimeTest {
   private  TimeListenerMock time;
    @Before
    public void setUp(){
       time = new TimeListenerMock();
        TimeManager.INSTANCE.addTimeListener(time);
    }

    @Test
    public void testWeek() throws Exception {
            boolean test =false;
        System.out.println("Week begin");
        System.out.println(new Date());
        while (!test){
            if(time.getTweek()==48){
                System.out.println("Week :"+ time.getTweek());
                System.out.println(new Date());
                test=true;
            }
        }System.out.println("Week end");
        assertTrue(time.getTweek()==48);
    }

    @Test
     public void testMonth() throws Exception {
        boolean test =false;
        System.out.println("month begin");
        System.out.println(new Date());
        while (!test){
            if(time.getTmonth()==12){
                System.out.println("Month :"+ time.getTmonth());
                System.out.println(new Date());
                test=true;
            }
        }
        System.out.println("month end");
        assertTrue(time.getTmonth()==12);
    }

    @Test
    public void testYear() throws Exception {
        boolean test =false;
        System.out.println("Year begin");
        System.out.println(new Date());
        while (!test){
            if(time.getTyear()==1){
                System.out.println("Year :"+ time.getTyear());
                System.out.println(new Date());
                test=true;
            }

        }
        System.out.println("year end");
        assertTrue(time.getTyear()==1);
    }

}
