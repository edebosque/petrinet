package src;

/**
 * Represents an incoming arc in a Petri net.
 * This arc connects a place to a transition.
 */
public class ArcIn extends Arc {

    /**
     * Constructs an incoming arc with the specified place.
     * 
     * @param place the place connected to this arc
     * @param value the value of this arc
     */
    public ArcIn(Place place, int value) {
        super(place, value);
    }

    /**
     * Triggers the arc, adding tokens to the connected place.
     */
    public void trigger() {
        this.getPlace().addTokens(this.getValue());
    }

}
