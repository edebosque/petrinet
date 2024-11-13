package petri;

import java.util.ArrayList;

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
    void addTransition(Transition transition);

    /**
     * Removes a transition from the Petri net.
     * 
     * @param transition the transition to remove
     */
    void remTransition(Transition transition);

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

    /**
	* Gets the Arcs from the Petri net.
    * 
	* @return all the Arcs of the Petri net.
    */
    ArrayList<Arc> getArcs();

    /**
	* Gets the Places from the Petri net.
    * 
	* @return all the Places of the Petri net.
    */
    public ArrayList<Place> getPlaces();

    /**
	* Gets the Transitions from the Petri net.
    * 
	* @return all the Transitions of the Petri net.
    */
    public ArrayList<Transition> getTransis();

}
