import java.io.*;
import java.util.*;

public class Main  {

    public static List<Item> mainList = new LinkedList<Item>();

    public static void main(String[] args) throws FileNotFoundException {

        Scanner user = new Scanner(System.in);

        System.out.println("Welcome to Waaaaa-rehouseOS! This OS allows the user to view items within a warehouse, add items to a warehouse, delete items from a warehouse, and change an item's valued.");
        System.out.println("Please input the name of the warehouse you would like to interact with. [a text document with the file extension]");

        String warehouse = user.nextLine();

        Scanner in = new Scanner(new File(warehouse));

        setList(in);

        boolean quit = false;
        do {
            System.out.println("Please input a command. [search, add, delete, edit, update, quit]");

            String command = user.next().toLowerCase();
            switch (command) {
                case "search" -> {
                    System.out.println("Please enter an item ID.");
                    int id = user.nextInt();
                    user.nextLine();
                    search(id);
                }
                case "add" -> {
                    System.out.println(
                            "\nID\n" +
                                    "Name\n" +
                                    "Description\n" +
                                    "State Integer [0 = outbound, 1 = in warehouse, 2 = inbound]\n" +
                                    "Destination\n\n" +
                                    "Please enter all of the data fields for a new item as shown above.");
                    add(user);
                    System.out.printf("Added!");
                }
                case "delete" -> {
                    System.out.println("Please enter an item ID.");
                    int id = user.nextInt();
                    user.nextLine();
                    delete(id);
                }
                case "edit" -> {
                    System.out.println("Please enter an item ID.");
                    int id = user.nextInt();
                    user.nextLine();
                    edit(id, user);
                }
                case "update" ->
                        update();
                case "quit" ->
                        quit = true;
                default ->
                        System.out.println("Invalid command: \"" + command + "\"\n");

            }

            System.out.println("\n");

        } while (! quit);

        System.out.println("Thank you for using Waaaaa-rehouseOS!");

    }

    public static void setList(Scanner in){
        while(in.hasNextLine()) {
            Item newItem = getItem(in);
            mainList.add(newItem);
        }
    }

    private static Item getItem(Scanner in){
        int ID = in.nextInt();
        in.nextLine();
        String name = in.nextLine();
        String description = in.nextLine();
        int state = in.nextInt();
        in.nextLine();
        String destination = in.nextLine();
        return new Item(ID, name, description, new State(state, destination));
    }

    public static void search(int itemID) {
        int hits = 0;
        for (Item item : mainList) {
            if (item.getID() == itemID) {
                System.out.println("Found item!");
                System.out.println(item.toString());
                System.out.println();
                hits++;
            }
        }
        if(hits == 0)
            System.out.println("No item found with id " + itemID);
        else if(hits > 1)
            System.out.println(hits + " hits for ID number " + itemID);
    }

    public static void add(Scanner in) {
        Item newItem = getItem(in);
        mainList.add(newItem);
    }

    public static void delete(int itemID) {
        for (int i = 0; i < mainList.size(); i++) {
            if (mainList.get(i).getID() == itemID) {
                mainList.remove(mainList.get(i));
                i--;
            }
        }
    }

    public static void edit(int itemID, Scanner in){
        boolean invalid = false;
        System.out.println("Here is the item's current data:");
        printFromID(itemID);
        int trueID = itemID;
        do {
            System.out.println("Please enter a value to edit. [id, name, description, state, destination]");
            String value = in.nextLine();
            switch (value) {
                case "id" -> {
                    invalid = false;
                    System.out.println("Enter a new item ID.");
                    int newValue = in.nextInt();
                    in.nextLine();
                    for (Item item : mainList) {
                        if (item.getID() == itemID) {
                            item.setID(newValue);
                        }
                    }
                    trueID = newValue;
                }
                case "name" -> {
                    invalid = false;
                    System.out.println("Enter a new name.");
                    String newValue = in.nextLine();
                    for (Item item : mainList) {
                        if (item.getID() == itemID) {
                            item.setName(newValue);
                        }
                    }
                }
                case "description" -> {
                    invalid = false;
                    System.out.println("Enter a new description");
                    String newValue = in.next();
                    in.nextLine();
                    for (Item item : mainList) {
                        if (item.getID() == itemID) {
                            item.setDescription(newValue);
                        }
                    }
                }
                case "state" -> {
                    invalid = false;
                    System.out.println("Enter a new state. [0 = outbound, 1 = in warehouse, 2 = inbound]");
                    int newValue = in.nextInt();
                    in.nextLine();
                    for (Item item : mainList) {
                        if (item.getID() == itemID) {
                            item.setState(newValue, item.getState().getDestination());
                        }
                    }
                }
                case "destination" -> {
                    invalid = false;
                    System.out.println("Enter a destination");
                    String newValue = in.nextLine();
                    for (Item item : mainList) {
                        if (item.getID() == itemID) {
                            item.setState(item.getState().getStateInt(), newValue);
                        }
                    }
                }
                default -> {
                    System.out.println("Invalid value: " + value + "\n");
                    invalid = true;
                }
            }
            System.out.println("Here is the item's new data:\n");
            printFromID(trueID);
        } while(invalid);
    }

    public static void update(){
        // PUSH NEW LIST TO WAREHOUSE FILE?
    }

    private static void printFromID(int id){
        int hits = 0;
        for (Item item : mainList) {
            if (item.getID() == id) {
                System.out.println(item.toString() + "\n");
                hits++;
            }
        }
        System.out.println(hits + " hits for ID number " + id);
    }
}