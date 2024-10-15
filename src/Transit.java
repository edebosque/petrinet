import java.util.ArrayList;

public class Transit {
    private ArrayList<Arc_out> liste_arc_out;
    private ArrayList<Arc_in> liste_arc_in;

    public Transit(ArrayList<Arc_out> liste_arc_out, ArrayList<Arc_in> liste_arc_in){
        this.liste_arc_out = liste_arc_out;
        this.liste_arc_in = liste_arc_in;
    }

    public void tirer(){
        for (Arc_in arc_in : liste_arc_in) {
            
        };
        for (Arc_out arc_out : liste_arc_out) {
            if(arc_out.isTriggerable()){
                arc_out.trigger();
            }
        };
    
    }
}
