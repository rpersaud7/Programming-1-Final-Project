import java.util.Comparator;
/**
 * Write a description of class GameFirstNameSorter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemFirstNameSorter implements Comparator<Item>
{
    public int compare(Item i1, Item i2)
    {
        String firstgamename = i1.getName();
        String secondgamename = i2.getName();
        return firstgamename.compareTo(secondgamename);
    }
}
