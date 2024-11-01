package petri;
import java.util.ArrayList;

/**
 * Represents a Petri net.
 * Provides methods to manipulate places, transitions, and arcs within the Petri net.
 */
public class PetriNet implements IPetriNet{

    private ArrayList<Arc> arcs;
    private ArrayList<Place> places;
    private ArrayList<Transit> transis;

    /**
     * Constructs a new PetriNet.
     */
    public PetriNet() {
        this.arcs = new ArrayList<>();
        this.places = new ArrayList<>();
        this.transis = new ArrayList<>();
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
    public void remTransit(Transit transit){
        this.transis.remove(transit);
    };

    /**
     * Adds a transition to the Petri net.
     * 
     * @param transition the transition to add
     */
    public void addTransit(Transit transit){
        this.transis.add(transit);
    };


};