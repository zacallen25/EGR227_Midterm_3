import java.io.*;
import java.util.*;

public class Main  {

    public static List<Item> mainList = new LinkedList<Item>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("text.txt"));
        setList(in);
        System.out.println(mainList);
        System.out.println(search(00001));
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

    public static Item search(int itemID) {
        for (int i = 0; i < mainList.size(); i++) {
            if (mainList.get(i).gettID() == itemID) {
                return mainList.get(i);
            }
        }
        return new Item();
    }
}
