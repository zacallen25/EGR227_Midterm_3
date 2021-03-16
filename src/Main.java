import java.io.*;
import java.util.*;

public class Main  {

    public static List<Item> mainList = new LinkedList<Item>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("text.txt"));
        setList(in);
        System.out.println(mainList);
    }

    public static void setList(Scanner in) {
        while(in.hasNextLine()) {
            int ID = in.nextInt();
            String name = in.next();
            int state = in.nextInt();
            String location = in.next();
            Item newItem = new Item(ID, name, new State(state, location));
            mainList.add(newItem);
        }
    }



}
