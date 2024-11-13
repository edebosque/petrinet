package petrinet;

/**
 * Represents an arc in a Petri net.
 * An arc can have a value that determines the number of tokens it can transfer.
 */
public abstract class Arc {
    
    private int value;
    private Place place;

    /**
     * Constructs an arc with the specified value.
     * 
     * @param value the value of the arc
     * @param place the place of the arc
     */
    public Arc(Place place, int value) {
        if(value < 0){
            throw new IllegalArgumentException("Value cannot be negative");
        }
        this.place = place;
        this.value = value;
    }

    /**
     * Sets the value of the arc.
     * 
     * @param value the new value of the arc
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Gets the value of the arc.
     * 
     * @return the value of the arc
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Gets the place of the arc.
     * 
     * @return the place of the arc
     */
    public Place getPlace() {
        return this.place;
    }

    /**
     * Triggers the arc, acting differetly for ArcIn and ArcOut .
     */
    abstract public void trigger();

}
