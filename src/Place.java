public class Place {
    private int nbJetons;

    public void addJetons(int nbJetons){
        this.nbJetons += nbJetons;
    }

    public void remJetons( int nbJetons){
        this.nbJetons -= nbJetons;
    }

    public void setNbJetons(int nbJetons){
        this.nbJetons = nbJetons;
    }

    public int getNbJetons(){
        return this.nbJetons;
    }

}
