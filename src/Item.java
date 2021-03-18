public class Item {
    int ID;
    String name;
    String description;
    State state;

    public Item() {
        ID = 0;
        name = "N/A";
        description = "None";
        state = new State();
    }

    public Item(int ID, String name, String description, State state) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.state = state;
    }

    public String toData() { return ID + "\n" + name + "\n" + description + "\n" + state.getStateInt() + "\n" + state.getDestination(); }

    @Override
    public String toString() {
        return "ID: " + ID + "\nName: " + name + "\nDescription: " + description + "\nState: " + state;
    }

    public int getID() {
        return ID;
    }

    public String getName() {return name;}

    public String getDescription() {return description;}

    public State getState() {return state; }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setState(int status, String destination) {
        this.state = new State(status, destination);
    }


}
