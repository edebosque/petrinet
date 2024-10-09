import java.util.ArrayList;

public class PetriNet {

    private ArrayList<Arc> arcs;
    private ArrayList<Place> places;
    private ArrayList<Transit> transis;

    public void remArc(){
        this.arcs.remove(0);
    }

    public void addArc(){
        this.arcs.add(new Arc());
    }

    public void remPlace(){
        this.places.remove(0);
    }

    public void addPlace(){
        this.places.add(new Place());
    }

    public void remTransi(){
        this.transis.remove(0);
    }

    public void addTransi(){
        this.transis.add(new Transit());
    }
}
