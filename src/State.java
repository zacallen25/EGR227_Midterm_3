public class State {
    int state;
    String destination;

    public State() {
        state = 999;
        this.destination = "None";
    }

    public State(int state, String destination) {
        this.state = state;
        this.destination = destination;
    }

    public String getCurrentState() {
        return switch (state) {
            case 0 -> "outbound";
            case 1 -> "in warehouse";
            case 2 -> "inbound";
            default -> "unknown";
        };
    }

    @Override
    public String toString() {
        return getCurrentState() + " Destination: " + destination;
    }
}
