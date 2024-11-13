package petrinet;
import java.util.ArrayList;

/**
 * Represents a Petri net.
 * Provides methods to manipulate places, transitions, and arcs within the Petri net.
 */
public class PetriNet implements IPetriNet{

    private ArrayList<Arc> arcs;
    private ArrayList<Place> places;
    private ArrayList<Transition> transitions;


    /**
     * Constructs a new PetriNet.
     */
    public PetriNet() {
        this.arcs = new ArrayList<>();
        this.places = new ArrayList<>();
        this.transitions = new ArrayList<>();
    }

    /**
     * Removes an arc from the Petri net.
     * 
     * @param arc the arc to remove
     */
    public void remArc(Arc arc){
        this.arcs.remove(arc);
    };
    
    /**
     * Adds an arc to the Petri net.
     * 
     * @param arc the arc to add
     */
    public void addArc(Arc arc){
        this.arcs.add(arc);
    };

    /**
     * Removes a place from the Petri net.
     * 
     * @param place the place to remove
     */
    public void remPlace(Place place){
        for (Arc arc : new ArrayList<>(arcs)) {
            if (arc.getPlace().equals(place)) {
                remArc(arc);
            }
        }
        this.places.remove(place);
    };

    /**
     * Adds a place to the Petri net.
     * 
     * @param place the place to add
     */
    public void addPlace(Place place){
        this.places.add(place);
    };

    /**
     * Removes a transition from the Petri net.
     * 
     * @param transition the transition to remove
     */
    public void remTransition(Transition transition){
        this.transitions.remove(transition);
    };

    /**
     * Adds a transition to the Petri net.
     * 
     * @param transition the transition to add
     */
    public void addTransition(Transition transition){
        this.transitions.add(transition);
    };

    /**
	* Gets the Arcs from the Petri net.
    * 
	* @return all the Arcs of the Petri net.
    */
    public ArrayList<Arc> getArcs() {
        return arcs;
    }

    /**
	* Gets the Places from the Petri net.
    * 
	* @return all the Places of the Petri net.
    */
    public ArrayList<Place> getPlaces() {
        return places;
    }

     /**
	* Gets the Transitions from the Petri net.
    * 
	* @return all the Transitions of the Petri net.
    */
    public ArrayList<Transition> getTransitions() {
        return transitions;
    }


};