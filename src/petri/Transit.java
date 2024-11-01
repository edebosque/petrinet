package petri;
import java.util.ArrayList;

/**
 * Represents a transition in a Petri net.
 * A transition can be triggered if certain conditions are met.
 */
public class Transit {

    private ArrayList<ArcIn> arcs_in;
    private ArrayList<ArcOut> arcs_out;

    /**
     * Constructs a transition.
     * 
     */
    public Transit() {
        this.arcs_in = new ArrayList<ArcIn>();
        this.arcs_out = new ArrayList<ArcOut>();
    }

    /**
     * Triggers the transition.
     * 
     */
    public void tirer(){
        Boolean tirage = true;
        for(int i = 0; i < this.arcs_out.size(); i++){
            
            if(!arcs_out.get(i).isTriggerable()){
                tirage = false;
                break;
            }
        }
        if(tirage){
            for(int i = 0; i < this.arcs_out.size(); i++){
                this.arcs_out.get(i).trigger();
            }
            for(int i = 0; i < this.arcs_in.size(); i++){
                this.arcs_in.get(i).trigger();
            }
        }
    }
}
