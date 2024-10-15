import java.util.ArrayList;

public class Petrinet implements IPetriNet{

    private ArrayList<Arc> arcs;
    private ArrayList<Place> places;
    private ArrayList<Transit> transis;

    public void remArc(Arc arc){
        this.arcs.remove(0);
    };
    
    public void addArc(Arc arc){
        this.arcs.add(arc);
    };

    public void remPlace(Place place){
        this.places.remove(0);
    };

    public void addPlace(Place place){
        this.places.add(place);
    };

    public void remTransi(Transit transi){
        this.transis.remove(0);
    };

    public void addTransi(Transit transi){
        this.transis.add(transi);
    };


};