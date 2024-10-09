public class Arc_out extends Arc {

    private Place place;

    public Boolean isTriggerable(){
        if (place.getNbJetons() >= this.getValue()){
            return true;
        }
        return false;
    }

    public void trigger(){
        this.place.remJetons(this.getValue());
    }

}
