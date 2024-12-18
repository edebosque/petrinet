package petrinet;

/**
 * Represents a special type of outgoing arc in a Petri net that empties a place.
 */
public class Videur extends ArcOut {

    /**
     * Constructs a Videur with the specified place.
     * 
     * @param place the place connected to this arc
     * @param value the value of this arc
     */
    public Videur(Place place){
        super(place, 1);
    }

    /**
     * Checks if the arc can be triggered.
     * 
     * @return true if the arc can be triggered, false otherwise
     */
    @Override
    public Boolean isTriggerable(){ 
        
        return (this.getPlace().getNbTokens() >= 1);
    
    }

    /**
     * Triggers the arc, setting the number of tokens in the connected place to zero.
     */
    @Override
    public void trigger(){
        this.getPlace().setNbTokens(0);
    }

}
