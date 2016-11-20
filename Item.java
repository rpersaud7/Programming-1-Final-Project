import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;
/**
 * This class contains as well as is able to set the information for an item
 * @author Mathew Mallory and Ronald Persaud
 * 3/9/15
 * @version version3.0
 */
public class Item
{
    List<String> item = new ArrayList<String>();
    /**
     * This class contains the documentation of an item including information required to organize it. 
     * This constructor creates an ArrayList to hold all of the information about the item read from a file.  
     */
    public Item(Scanner fileRead)
    {
        for(int count = 1; count <= 7; count++)
        {
            item.add(fileRead.next());
        }
    }
    
    /**
     * Adds user's input to the list
     */
    public void addToList(String userin)
    {
        item.add(userin);
    }

    /**
     * Changes what the user specifies in the list to what they input
     */
    public void changeToList(String usertochange, String userchange)
    {
        item.set((item.indexOf(usertochange)), userchange);
    }

    /**
     * Deletes what the user specifies in the list 
     */
    public void deleteInList(String userin)
    {
        item.remove(userin);
    }

    /**
     *  Displays item to the screen
     */
    public void viewItem()
    {
        System.out.println(item);
    }
    
    /**
     *  Gets the name of the item
     */
    public String getName()
    {
        return item.get(1);
    }
     
}
