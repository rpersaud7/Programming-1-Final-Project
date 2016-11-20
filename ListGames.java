import java.util.*;
import java.io.*;
/**
 * Write a description of class ListGames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListGames
{
    List<Item> itemlist;
    String userresponse;
    /**
     * intializes the itemlist with an empty list
     * creates a scanner to be used 
     * initializes userresponse so that the main method may check for if it is possible for the program 
     * to run or not depending on the initializer method
     */
    public ListGames()
    {
        this.itemlist = new ArrayList<Item>();   
        this.userresponse = "nope";
    }
    
    /**
     * Reads from a file and fills in the itemlist or tells the main method to end the program if none is found
     * @param - itemcount - the amount of items the user has provided inside of the file
     * 
     */
    public void initializer(int itemcount)
    {
        try
        {
            Scanner fileRead = new Scanner(new File("programmingspreasheet.csv")).useDelimiter(",");
            while(itemcount > 0)
            {
                itemlist.add(new Item(fileRead));
                fileRead.nextLine();
                itemcount--;            
            }
            userresponse = "yes";
        }
        catch(FileNotFoundException e)
        {
            System.out.println("No file found please try again.");
            userresponse = "nope";
        }
    }

    /**
     * Shows the unique values of a certain category of the games
     * @return - returns the Set of uniques to be printed to the screen in main
     * @param - the category of unique things to be displayed
     */
    public Set<String> showunique(int category)
    {
        Set<String> uniques = new HashSet<String>();
        for(int count = 0; count <= itemlist.size()-1; count++)
        {
            uniques.add(itemlist.get(count).item.get(category));
        }
        return (uniques);
    }
    
    /**
     *  Shows the count of developers
     * @return - returns the map of uniques to be printed to the screen in main
     *
     */
    public Map<String,Integer> devcount()
    {
        Map<String, Integer> countofuniques = new TreeMap<String, Integer>(); 
        for(int count = 0; count <= itemlist.size()-1; count++)
        {
            if(countofuniques.get(itemlist.get(count).item.get(3)) == null)
            {
                countofuniques.put(itemlist.get(count).item.get(3) , 1);
            }
            else
            {
                int tally = countofuniques.get(itemlist.get(count).item.get(3));
                countofuniques.put(itemlist.get(count).item.get(3) , tally + 1);
            }
        }
        return (countofuniques);
    }

    /**
     * creates a map of unique publishers and their count
     * @return - returns the map of uniques to be printed to the screen in main
     * 
     */
    public Map<String,Integer> pubcount()
    {
        Map<String, Integer> countofuniques = new TreeMap<String, Integer>(); 
        for(int count = 0; count <= itemlist.size()-1; count++)
        {
            if(countofuniques.get(itemlist.get(count).item.get(4)) == null)
            {
                countofuniques.put(itemlist.get(count).item.get(4) , 1);
            }
            else
            {
                int tally = countofuniques.get(itemlist.get(count).item.get(4));
                countofuniques.put(itemlist.get(count).item.get(4) , tally + 1);
            }
        }
        return (countofuniques);
    }
    
    /**
     *  Preforms a binary search utilizing the binarySearch method
     * @return - returns the item if found and if not found tells the user what they searched for was not found
     * @param - searchy - what the user is searching for 
     *
     */
    public String binary(String searchy)
    {
        int indexofItem = binarySearch(searchy, 0 , itemlist.size()-1);

        if(indexofItem >= 0)
        {
            return "Your item was found " + itemlist.get(indexofItem).item;
        }
        else
        {
            return "No item called " + searchy + " was found.";
        }
    }

    public int binarySearch(String searchy, int min, int max)
    {
        Collections.sort(itemlist, new ItemFirstNameSorter());
        if(min > max)
        {
            return -1;
        }

        int mid = (max - min) / 2 + min;
        String midfirstname = itemlist.get(mid).getName();
        int compareit = midfirstname.compareTo(searchy);
        if(compareit == 0)
        {
            return mid;
        }
        else if(compareit > 0)
        {
            return binarySearch(searchy, min, mid-1);
        }
        else
        {
            return binarySearch(searchy, mid+1,max);
        }
    }
}
