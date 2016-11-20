
import tester.*;
import java.util.Scanner;
/**
 * Testing class Testerino.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Testerino  
{
    // Instance variables go here, typically examples to test.
    // For example, if you're testing the Date class, you might say
    // private Date myBirthday = new Date(1964, 1, 27);
    // private Date millennium = new Date(2001, 1, 1);

    /**
     * Run all test methods in the class.
     */
    public static void testEverything ()
    {
        Tester.run (new Testerino());
    }

    /**
     * A sample testing method
     * 
     * @param  t   the Tester to use
     */
    public void testSomething (Tester t)
    {
        // put your code here, e.g.
        // t.checkExpect (this.myBirthday.getYear(), 1964);
        // t.checkExpect (new Date(1941,12,7).addDays(10),
        //           new Date(1941,12,17));
        ListGames gamelist = new ListGames();
        int itemcount = 6;
        gamelist.initializer(itemcount);
        
        t.checkExpect(gamelist.binary("things"), "stuff");
        t.checkExpect(gamelist.binary("stuff"), "stuff");
        t.checkExpect(gamelist.binary("Bloodborne"), "Your item was found [4, Bloodborne, 2015, From Software, Sony Computer Entertainment, 60.00, PS4]");
        t.checkExpect(gamelist.binary("Killing Floor 2"), "Your item was found [5, Killing Floor 2,  2015,  Tripwire Interactive,  Iceberg Interactive,  30.00,  PC]");
    }
}
