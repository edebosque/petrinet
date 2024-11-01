package petri;

/**
 * Interface representing a Petri net.
 * Provides methods to manipulate the Petri net.
 */
public interface IPetriNet {

    /**
     * Adds a place to the Petri net.
     * 
     * @param place the place to add
     */
    void addPlace(Place place);

    /**
     * Removes a place from the Petri net.
     * 
     * @param place the place to remove
     */
    void remPlace(Place place);

    /**
     * Adds a transition to the Petri net.
     * 
     * @param transition the transition to add
     */
    void addTransit(Transit transition);

    /**
     * Removes a transition from the Petri net.
     * 
     * @param transition the transition to remove
     */
    void remTransit(Transit transition);

    /**
     * Adds an arc to the Petri net.
     * 
     * @param arc the arc to add
     */
    void addArc(Arc arc);

    /**
     * Removes an arc from the Petri net.
     * 
     * @param arc the arc to remove
     */
    void remArc(Arc arc);

}
