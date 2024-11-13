package petrinet;

/**
 * Represents a special type of outgoing arc in a Petri net that triggers when a place has zero tokens.
 */
public class Zero extends ArcOut {

     /**
     * Constructs a Zero arc with the specified place.
     * 
     * @param place the place connected to this arc
     * @param value the value of this arc
     */
    public Zero(Place place) {
        super(place, 0);
    }

    /**
     * Checks if the arc can be triggered.
     * 
     * @return true if the place has zero tokens, false otherwise
     */
    @Override
    public Boolean isTriggerable(){
        return (this.getPlace().getNbTokens() == 0);
    }


    /**
     * Triggers the arc.
     * 
     */
    @Override
    public void trigger(){
        // Nothing
    }
}
