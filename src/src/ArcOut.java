package src;

/**
 * Represents an outgoing arc in a Petri net.
 * This arc connects a place to a transition.
 */
public class ArcOut extends Arc {

     /**
     * Constructs an incoming arc with the specified place.
     * 
     * @param place the place connected to this arc
     * @param value the value of this arc
     */
    public ArcOut(Place place, int value) {
        super(place, value);
    }


    /**
     * Checks if the arc can be triggered.
     * 
     * @return true if the arc can be triggered, false otherwise
     */
    public Boolean isTriggerable() {
        if (this.getPlace().getNbTokens() >= this.getValue()) {
            return true;
        }
        return false;
    }

    /**
     * Triggers the arc, removing tokens from the connected place.
     */
    public void trigger() {
        this.getPlace().remTokens(this.getValue());
    }

}
