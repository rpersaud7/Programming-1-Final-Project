import java.io.*;
import java.util.*;
/**
 * Main gives the information given by the user to the item class
 * 
 * @author Mathew Mallory and Ronald Persaud    3/9/15
 * @version version3.0
 */
public class Main
{
    /**
     * @exception thrown when no file is found to be written to 
     */
    public static void main (String[] args)throws FileNotFoundException
    {  
        ListGames gamelist = new ListGames();
        Scanner grabby = new Scanner(System.in);
        String userchoice = "";
        String userin = ""; 
        String usertochange = "";
        int itemselect = 0;
        int itemcount = 6;
        gamelist.initializer(itemcount);
        String userresponse = gamelist.userresponse;
        while(userresponse.equals("yes"))
        {
            System.out.println("");
            System.out.println("Would you like to (a) add (c) change (d) delete (g) show unique values (h) show count of developers");
            System.out.println("(j) show count of publishers (v) view (k) view the items sorted by title (b) search for an item by name (x) exit?");
            userchoice = grabby.next();
            if(userchoice.equals("a") || userchoice.equals("c") || userchoice.equals("d"))
            {
                //allows user to see all items loaded and select which one to preform an action on
                System.out.println("Which item would you like to access?");
                for(int n = 1; n <= itemcount; n++)
                {
                    gamelist.itemlist.get(n-1).viewItem();
                }
                itemselect = grabby.nextInt() - 1; 
            }
            if(userchoice.equals("a"))  //adds a quality to an item in list of items
            {
                System.out.println("Please enter what you would like to add and press enter");
                userin = grabby.next();
                gamelist.itemlist.get(itemselect).addToList(userin);
            }
            else if(userchoice.equals("c"))   //change a quality of an item in list of items
            {
                System.out.println("Please enter what you would like to change and press enter");
                usertochange = grabby.next();
                System.out.println("Please enter what you would like to change it to and press enter");
                userin = grabby.next();
                gamelist.itemlist.get(itemselect).changeToList(usertochange, userin);
            }
            else if(userchoice.equals("d"))    //delete
            {
                System.out.println("Please enter what you would like to delete and press enter");
                userin = grabby.next();
                gamelist.itemlist.get(itemselect).deleteInList(userin);
            }
            else if(userchoice.equals("g"))    //show unique values
            {
                System.out.println("Choose which category you want to display unique values of.");
                System.out.println("(1)ID (2)Name (3)Year (4)Developer (5)Publisher (6)Price (7)Platform");
                int category = grabby.nextInt();
                System.out.println(gamelist.showunique(category));
            }
            else if(userchoice.equals("h"))    //show count of developers
            {
                System.out.println(gamelist.devcount());
            }
            else if(userchoice.equals("j"))  //show count of publishers
            {
                System.out.println(gamelist.pubcount());
            }
            else if(userchoice.equals("v"))   //view all items
            {
                for(int n = 1; n <= itemcount; n++)
                {
                    gamelist.itemlist.get(n-1).viewItem();
                }
            }
            else if(userchoice.equals("k"))    //sort by game name
            {
                Collections.sort(gamelist.itemlist, new ItemFirstNameSorter());
                for(Item stuff : gamelist.itemlist)
                {
                    System.out.println(stuff.item);
                }
            }
            else if(userchoice.equals("b"))   //binary search for name
            {
                System.out.println("Which name are you searching for?");
                String searchy = grabby.nextLine();
                System.out.println(gamelist.binary(searchy));
            }
            else if(userchoice.equals("x"))     //exit
            {
                System.out.println("Thank you for your time");
                userresponse = "no"; 
            }
            else
            {
                System.out.println("");
            }
        }
    }

}
