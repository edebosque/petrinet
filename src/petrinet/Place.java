package petrinet;

/**
 * Represents a place in a Petri net.
 * A place can hold a certain number of tokens.
 */
public class Place {

    private int nbTokens;

    /**
     * Constructs a place with the specified number of tokens.
     * 
     * @param nbTokens the initial number of tokens
     */
    public Place(int nbTokens) {
        this.setNbTokens(nbTokens);
    }

    /**
     * Adds tokens to the place.
     * 
     * @param nbTokens the number of tokens to add
     */
    public void addTokens(int nbTokens) {
        if (nbTokens < 0) {
           return;
        }
        else{
            this.nbTokens += nbTokens;
        }
    }

    /**
     * Removes tokens from the place.
     * 
     * @param nbTokens the number of tokens to remove
     */
    public void remTokens(int nbTokens) {
        if (nbTokens < 0) {
           return;
        }
        if( this.nbTokens - nbTokens < 0){
            this.nbTokens = 0;
            return;
        }
        else{
            this.nbTokens -= nbTokens;
        }
        
    }

    /**
     * Sets the number of tokens in the place.
     * 
     * @param nbTokens the new number of tokens
     */
    public void setNbTokens(int nbTokens) {
        if (nbTokens < 0) {
            this.nbTokens = 0;
            return;
        }
        this.nbTokens = nbTokens;
    }

    /**
     * Gets the number of tokens in the place.
     * 
     * @return the number of tokens
     */
    public int getNbTokens() {
        return this.nbTokens;
    }

}
