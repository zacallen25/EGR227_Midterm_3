public class Item {
    int ID;
    String name;
    State state;

    public Item() {
        ID = 0;
        name = "N/A";
        state = new State();
    }

    public Item(int ID, String name, State state) {
        this.ID = ID;
        this.name = name;
        this.state = state;
    }


}
