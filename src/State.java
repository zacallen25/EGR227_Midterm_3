public class State {
    int state;
    String destination;

    public State() {
        state = 999;
        this.destination = "None";
    }

    public State(int state, String dest) {
        this.state = state;
        if (dest.equals(".")) {
            this.destination = "None";
        }
        else {
            this.destination = dest;
        }
    }

    public int getStateInt() {
        return state;
    }

    public String getStateAsString() {
        return switch (state) {
            case 0 -> "outbound";
            case 1 -> "in warehouse";
            case 2 -> "inbound";
            default -> "unknown";
        };
    }

    public String getDestination() {
        return destination;
    }

    public void setStateInt(int state) {
        this.state = state;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return getStateAsString() + "\nDestination: " + destination;
    }
}
