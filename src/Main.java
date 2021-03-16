import java.util.*;

public class Main {
    public static List<Item> mainList = new LinkedList<Item>();

    public static void main(String[] args) {





    }

    public static void setList(Scanner in) {
        int i = 0;
        while(in.hasNextLine()) {
            int ID = in.nextInt();
            String name = in.nextLine();
            String state = in.next();
            String location = in.next();
            Item newItem = new Item(ID, name, new State(state, location));
            mainList.add(newItem);
        }
    }

}
