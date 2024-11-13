package src;
import java.util.ArrayList;

/**
 * Represents a transition in a Petri net.
 * A transition can be triggered if certain conditions are met.
 */
public class Transition {

    private ArrayList<ArcIn> arcsIn;
    private ArrayList<ArcOut> arcsOut;

    /**
     * Constructs a transition.
     * 
     */
    public Transition() {
        this.arcsIn = new ArrayList<ArcIn>();
        this.arcsOut = new ArrayList<ArcOut>();
    }

    
	/**
	 * Gets the ArcIn
     * 
	 * @return all the ArcIn of the Transition
	 */
	public ArrayList<ArcIn> getArcsIn() {
		return arcsIn;
	}
	
	/**
	 * Add a ArcIn to the Transition
     * 
	 * @param arcsIn the new ArcIn of the Transition
	 */
	public void addArcIn(ArcIn arcIn) {
		this.arcsIn.add(arcIn);
	}
	
	/**
	 * Gets the ArcOut
     * 
	 * @return all the ArcOut of the Transition
	 */
	public ArrayList<ArcOut> getArcsOut() {
		return arcsOut;
	}
	
	/**
	 * Add an ArcOut to the Transition
     * 
	 * @param arcOut the new ArcOut of the Transition
	 */
	public void addArcOut(ArcOut arcOut) {
		this.arcsOut.add(arcOut);
	}

    /**
     * Triggers the transition.
     * 
     */
    public void triggerTransition(){
        Boolean trigger = true;
        for(int i = 0; i < this.arcsOut.size(); i++){
            
            if(!arcsOut.get(i).isTriggerable()){
                trigger = false;
                break;
            }
        }
        if(trigger){
            for(int i = 0; i < this.arcsOut.size(); i++){
                this.arcsOut.get(i).trigger();
            }
            for(int i = 0; i < this.arcsIn.size(); i++){
                this.arcsIn.get(i).trigger();
            }
        }
    }
}
