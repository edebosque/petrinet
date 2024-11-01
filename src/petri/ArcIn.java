package petri;

/**
 * Represents an incoming arc in a Petri net.
 * This arc connects a place to a transition.
 */
public class ArcIn extends Arc {

    private Place place;

    /**
     * Constructs an incoming arc with the specified place.
     * 
     * @param place the place connected to this arc
     */
    public ArcIn(Place place) {
        this.place = place;
    }

    /**
     * Triggers the arc, adding tokens to the connected place.
     */
    public void trigger() {
        this.place.addJetons(this.getValue());
    }

}
