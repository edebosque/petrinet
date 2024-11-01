package petri;

/**
 * Represents a place in a Petri net.
 * A place can hold a certain number of tokens.
 */
public class Place {

    private int nbJetons;

    /**
     * Constructs a place with the specified number of tokens.
     * 
     * @param nbJetons the initial number of tokens
     */
    public Place(int nbJetons) {
        this.setNbJetons(nbJetons);
    }

    /**
     * Adds tokens to the place.
     * 
     * @param nbJetons the number of tokens to add
     */
    public void addJetons(int nbJetons) {
        this.nbJetons += nbJetons;
    }

    /**
     * Removes tokens from the place.
     * 
     * @param nbJetons the number of tokens to remove
     */
    public void remJetons(int nbJetons) {
        if (this.nbJetons - nbJetons < 0) {
            this.nbJetons = 0;
            return;
        }
        this.nbJetons -= nbJetons;
    }

    /**
     * Sets the number of tokens in the place.
     * 
     * @param nbJetons the new number of tokens
     */
    public void setNbJetons(int nbJetons) {
        if (nbJetons < 0) {
            this.nbJetons = 0;
            return;
        }
        this.nbJetons = nbJetons;
    }

    /**
     * Gets the number of tokens in the place.
     * 
     * @return the number of tokens
     */
    public int getNbJetons() {
        return this.nbJetons;
    }

}
