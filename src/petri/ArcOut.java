package petri;

/**
 * Represents an outgoing arc in a Petri net.
 * This arc connects a place to a transition.
 */
public class ArcOut extends Arc {

    private Place place;

    /**
     * Constructs an outgoing arc with the specified place.
     * 
     * @param place the place connected to this arc
     */
    public ArcOut(Place place) {
        this.place = place;
    }

    /**
     * Checks if the arc can be triggered.
     * 
     * @return true if the arc can be triggered, false otherwise
     */
    public Boolean isTriggerable() {
        if (place.getNbJetons() >= this.getValue()) {
            return true;
        }
        return false;
    }

    /**
     * Triggers the arc, removing tokens from the connected place.
     */
    public void trigger() {
        this.place.remJetons(this.getValue());
    }

}
