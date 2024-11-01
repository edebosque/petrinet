package petri;

/**
 * Represents an arc in a Petri net.
 * An arc can have a value that determines the number of tokens it can transfer.
 */
public class Arc {
    private int value;

    /**
     * Constructs an arc with a default value of 1.
     */
    public Arc() {
        this.value = 1;
    }

    /**
     * Constructs an arc with the specified value.
     * 
     * @param value the value of the arc
     */
    public Arc(int value) {
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

}
