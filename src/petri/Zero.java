package petri;

/**
 * Represents a special type of outgoing arc in a Petri net that triggers when a place has zero tokens.
 */
public class Zero extends ArcOut {

    Place place;

     /**
     * Constructs a Zero arc with the specified place.
     * 
     * @param place the place connected to this arc
     */
    public Zero(Place place) {
        super(place);
    }

    /**
     * Checks if the arc can be triggered.
     * 
     * @return true if the place has zero tokens, false otherwise
     */
    @Override
    public Boolean isTriggerable(){
        return (this.place.getNbJetons() == 0);
    }


    /**
     * Triggers the arc.
     * 
     */
    @Override
    public void trigger(){
        
    }
}
