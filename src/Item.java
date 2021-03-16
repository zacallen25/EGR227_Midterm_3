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

    @Override
    public String toString() {
        return "ID: " + ID + " Name: " + name + " State: " + state;
    }

    public int gettID() {
        return ID;
    }

    public String getName() {return name;}

    public State getState() {return state; }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setState(int status, String destination) {
        this.state = new State(status, destination);
    }


}
