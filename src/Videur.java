public class Videur extends Arc_out {

    Place place;
    public Videur(Place place){
        super(place);
    }

    @Override
    public Boolean isTriggerable(){
        return (this.place.getNbJetons() == 0);
    }

}
