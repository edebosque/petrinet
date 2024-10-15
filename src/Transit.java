import java.util.ArrayList;

public class Transit {

    private ArrayList<Arc_in> arcs_in;
    private ArrayList<Arc_out> arcs_out;

    public Transit() {
        this.arcs_in = new ArrayList<Arc_in>();
        this.arcs_out = new ArrayList<Arc_out>();
    }

    public void tier(){
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
